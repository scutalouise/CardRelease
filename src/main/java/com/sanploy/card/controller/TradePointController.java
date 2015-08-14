package com.sanploy.card.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sanploy.card.pojo.Customer;
import com.sanploy.card.pojo.KDLimit;
import com.sanploy.card.pojo.TradePoint;
import com.sanploy.card.pojo.User;
import com.sanploy.card.service.CardOperService;
import com.sanploy.card.service.CustomerService;
import com.sanploy.card.service.HairpinService;
import com.sanploy.card.service.KDLimitService;
import com.sanploy.card.service.TradePointService;
import com.sanploy.card.utils.CardKeyGenerator;
import com.sanploy.card.utils.Constant;
import com.sanploy.card.utils.DateUtils;

/**
 * @Description:处理交易和充值核心
 * @author:scuta
 * @since:2015年7月14日
 * @version:default 0.0.0.1
 */
@Controller
@RequestMapping("/trade")
public class TradePointController {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(TradePointController.class);

	@Autowired
	private TradePointService tradePointService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private KDLimitService kdlimitService;

	@Autowired
	private CardOperService cardOperService;

	@Autowired
	private HairpinService hairpinService;

	/**
	 * @Description:消费扣点页面
	 * @param map
	 * @return
	 * @since:2015年7月14日 下午5:11:43
	 */
	@RequestMapping(value = "/comsume", method = RequestMethod.GET)
	public String consumePoints(Map<String, Object> map) {
		map.put("tradePoint", new TradePoint());
		return "trade/comsume";
	}

	/**
	 * @Description:消费扣点具体操作过程：注意判断是否有超过当天扣点的最大限制；
	 * @param tradePoint
	 * @param customer
	 * @param map
	 * @return
	 * @since:2015年7月14日 下午5:41:45
	 */
	@ResponseBody
	@RequestMapping(value = "/comsume", method = RequestMethod.POST)
	public Map<String, Object> comsumePoints(TradePoint tradePoint, @RequestParam("mac") String mac, HttpServletRequest request, @ModelAttribute("customer") Customer customer) {
		// 需要考虑进网点Dot,考虑到session中去取；
		Map<String, Object> map = new HashMap<String, Object>();
		if (null == customer) {
			map.put(Constant.RESULT, Constant.FAILED);// 未找到客户
		} else {
			// 关联上客户--通过银行卡卡号，即customer表主键； 设置消费与客户的关联关系
			tradePoint.setCustomer(customer);
			// 由于有不挂失卡存在的可能性，检查卡是否为挂失卡先! 失卡(0-非失卡 1-失卡 2-挂失已补卡)
			if ("1".equals(customer.getLoss())) {
				map.put(Constant.RESULT, Constant.LOSS);
				map.put("message", "当前卡为挂失卡不能进行体验");
			} else {
				// 接着判断是否在有效期内：
				if (!DateUtils.compare(new Date(), customer.getInvalid())) {
					//检查客户余额是否大于当前消费次数；
					if(Integer.parseInt(customer.getRemainingPt()) < 1){//默认每次扣除一个点
						map.put(Constant.RESULT, Constant.NOTENOUGH);
					}else{
						// 检查是否有超过当天扣点的最大限制；
						// 检查：1.当天消费总次数:
						String hql = "select SUM(ptTrade) from TradePoint where cardNo = ? and tradeType = 2 and to_days(tradeDate) = to_days(now())";
						String[] param = { tradePoint.getCustomer().getCardNo() };
						int sum = Math.abs(kdlimitService.count(hql, param));
						
						// 检查：2.每天扣费，限制的最大值
						String id = tradePoint.getCustomer().getBankCardType().getBankCardTypeId();
						KDLimit kdlimit = kdlimitService.get(id);
						int limit = 100;// 默认限制为100
						if (null != kdlimit && null != kdlimit.getLimitPoint()) {
							limit = Integer.parseInt(kdlimit.getLimitPoint());
						}
						// 第一次检查:当日消费总点值，已经到了上限
						if (sum >= limit) {
							map.put("message", "每日扣点限制为：" + limit + "点;您当前已经消费：" + sum + "点");
						}
						// 第二次检查：当日已经消费，接下来的消费将不能超过，每日限制额度-当天已经消费点值
						if (sum - limit < Integer.parseInt(tradePoint.getPtTrade())) {
							map.put("message", "每日扣点限制为：" + limit + "点;您当前已经消费:" + sum + "点;本次最多消费：" + Math.abs((sum - limit)) + "点");
						}
						
						// 注意检查，对customer的级联更新；
						tradePoint.setTradePointNo(getId(tradePointService));// 设置id
						tradePoint.setTradeType("2");// 交易类型（1-充点，2-扣点）
						String ptBefore = tradePoint.getCustomer().getRemainingPt(); // 消费前点数
						Integer points = Integer.parseInt(tradePoint.getPtTrade()); // 本次消费点数:注意消费为负数
						points = -Math.abs(points);
						Integer PtAfter = Integer.parseInt(ptBefore) + points; // 消费后点数
						// 更新customer,消费后的点数
						tradePoint.getCustomer().setRemainingPt(String.valueOf(PtAfter));
						
						tradePoint.setPtBefore(ptBefore);
						tradePoint.setPtTrade(String.valueOf(points));
						tradePoint.setPtAfter(String.valueOf(PtAfter));
						// 执行保存与更新操作:使用级联更新操作
						tradePoint.setTradeDate(new Date());
						tradePoint.setOperateDate(new Date());
						User userFromSession = (User) request.getSession().getAttribute("user");
						tradePoint.setOperator(String.valueOf(userFromSession.getUserId()));
						// 将网点放入到 tradePoint
						User user = (User) request.getSession().getAttribute("user");
						tradePoint.setDot(user.getDot());
						tradePoint.setCardNo(customer.getCardNo());
						// 执行保存
						tradePointService.save(tradePoint);
						
						// 回显数据：
						String todayComsumeHql = "select sum(ptTrade) from TradePoint where tradeType = '2' and to_days(now())=to_days(tradeDate) and cardNo = ?";// 交易类型（1-充点，2-扣点）
						int todayComsumeCount = tradePointService.count(todayComsumeHql, new String[] { tradePoint.getCardNo() });
						
						String sumComsumeHql = "select sum(ptTrade) from TradePoint where tradeType = '2' and cardNo = ?";
						int sumComsumeCount = tradePointService.count(sumComsumeHql, new String[] { tradePoint.getCardNo() });
						
						map.put(Constant.RESULT, Constant.SUCCESS);
						map.put("customerName", customer.getCustomerName());
						map.put("todayComsume",Math.abs(todayComsumeCount) + "点");// 今日消费点数
						map.put("sumComsume", Math.abs(sumComsumeCount) + "点");// 累计消费点数
						map.put("remainComsume", tradePoint.getPtAfter() + "点");// 剩余点数
						map.put("dotId", user.getDot().getDotId());// 需要写入卡信息；
						map.put("tradeDate", DateUtils.formatFromDate(tradePoint.getTradeDate()));// 需要写入卡信息
						map.put("message", "客户扣点1次成功");
					}
				} else {
					map.put(Constant.RESULT, Constant.INVALID);
					map.put("message", "您已超过有效期.");
				}
			}
		}

		map.put("customer", customer);
		map.putAll(CardKeyGenerator.getKey(mac));
		return map;
	}

	/************************** 充点过程 *********************************/
	/**
	 * @Description:充点、详情页面
	 * @param map
	 * @return
	 * @since:2015年7月14日 下午5:17:09
	 */
	@RequestMapping(value = "/recharge", method = RequestMethod.GET)
	public String recharge(Map<String, Object> map) {
		map.put("tradePoint", new TradePoint());
		return "trade/recharge";
	}

	/**
	 * @Description:充点具体操作过程
	 * @param tradePoint
	 * @param customer
	 * @param map
	 * @return
	 * @since:2015年7月14日 下午5:42:00
	 */
	@RequestMapping(value = "/recharge", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> recharge(TradePoint tradePoint, @RequestParam("mac") String mac, HttpServletRequest request, @ModelAttribute("customer") Customer customer) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 关联上客户--通过银行卡卡号，即customer表主键； 设置消费与客户的关联关系.
		tradePoint.setCustomer(customer);
		// 由于有不挂失卡存在的可能性，检查卡是否为挂失卡先! 失卡(0-非失卡 1-失卡 2-挂失已补卡)
		if ("1".equals(customer.getLoss())) {
			map.put("message", "当前卡为挂失卡不能进行体验:充点");
		} else {
			if (!DateUtils.compare(new Date(), customer.getInvalid())) {
				// 设置id
				tradePoint.setTradePointNo(getId(tradePointService));
				// 关联上客户--通过银行卡卡号，即customer表主键； 设置消费与客户的关联关系
				// 设置其他未在客户端设置的属性与参数:其中的标识位，是交易还是充值，一定要区分开；
				tradePoint.setTradeType("1");// 交易类型（1-充点，2-扣点）
				String ptBefore = customer.getRemainingPt(); // 充值前点数
				Integer points = Integer.parseInt(tradePoint.getPtTrade()); // 本次充值点数
				Integer PtAfter = Integer.parseInt(ptBefore) + points; // 充值后点数
				// 更新customer
				customer.setRemainingPt(String.valueOf(PtAfter));
				// 更新tradePoint
				tradePoint.setPtBefore(ptBefore);
				tradePoint.setPtTrade(String.valueOf(points));
				tradePoint.setPtAfter(String.valueOf(PtAfter));

				// 执行保存操作:计算并更新customer,使用级联更新；
				tradePoint.setTradeDate(new Date());
				tradePoint.setOperateDate(new Date());
				// 将网点放入到 tradePoint
				User user = (User) request.getSession().getAttribute("user");
				tradePoint.setOperator(String.valueOf(user.getUserId()));
				tradePoint.setDot(user.getDot());
				tradePoint.setCardNo(customer.getCardNo());
				tradePointService.save(tradePoint);
				// 返回页面展示的数据
				map.put("ptBefore", tradePoint.getPtBefore());
				map.put("ptTrade", tradePoint.getPtTrade());
				map.put("ptAfter", tradePoint.getPtAfter());
				map.put("message", "充点成功");
			} else {
				map.put(Constant.RESULT, Constant.INVALID);
				map.put("message", "您已超过有效期.");
			}

		}

		map.put("customer", customer);
		map.putAll(CardKeyGenerator.getKey(mac));
		return map;
	}

	/**
	 * @Description:根据物理卡号，返回客户端customer信息；加载customer
	 * @param mac
	 * @return
	 * @since:2015年7月15日 下午2:23:16
	 */
	@ResponseBody
	@RequestMapping(value = { "/comsume/getInfoByMac", "/recharge/getInfoByMac" }, method = RequestMethod.POST)
	public Map<String, Object> getInfoByMac(@RequestParam("mac") String mac, @ModelAttribute("customer") Customer customer) {
		// 根据卡物理地址，找到客户；
		Map<String, Object> map = new HashMap<String, Object>();
		String hqlForCard = "from Hairpin where cardPhysicalAdd = ?";
		if (null == hairpinService.unique(hqlForCard, new String[] { mac })) {// 此卡未初始化.
			map.put(Constant.RESULT, Constant.NOTINITIAL);
			return map;
		}

		if (null != customer) {// 失卡(0-非失卡 1-失卡 2-挂失已补卡)
			map.put("customer", customer);
			if ("1".equals(customer.getLoss())) {
				map.put(Constant.RESULT, Constant.LOSS);// 挂失卡
				return map;
			}
			map.put(Constant.RESULT, Constant.SUCCESS);// 正常使用中：非失卡，挂失已补卡
		} else {
			// 判断下，是否存在挂失信息
			String hqlForCardOper = "from CardOper where operType = '3' and  oldCardNo = (select cardNo from Hairpin where cardPhysicalAdd = ?)";
			if (null != cardOperService.unique(hqlForCardOper, new String[] { mac })) {// 此卡非有挂失过并且已经补卡
				map.put("result", Constant.RERELEASED);
			} else {
				map.put(Constant.RESULT, Constant.FAILED);// 未找到客户信息
			}
		}
		return map;
	}

	/**
	 * @Description:根据物理地址，返回密钥
	 * @param mac
	 * @return
	 * @since 2015年7月19日 下午7:00:54
	 */
	@ResponseBody
	@RequestMapping(value = { "/recharge/getKey/{mac}", "/comsume/getKey/{mac}" }, method = RequestMethod.GET)
	public Map<String, Object> getKey(@PathVariable("mac") String mac) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 根据卡物理地址找到对应的密钥；
		map.putAll(CardKeyGenerator.getKey(mac));
		return map;
	}

	/**
	 * @Description:充值，扣费都涉及到用户的原账户信息，查出来放入model备用
	 * @param tradePoint
	 * @param map
	 * @since:2015年7月14日 下午5:38:47
	 */
	@ModelAttribute
	public void populateTradePoint(@RequestParam(value = "mac", required = false) String mac, Map<String, Object> map) {
		if (null != mac && !"".equals(mac)) {
			String hql = "from Customer where cardNo = (select cardNo from Hairpin where cardPhysicalAdd = ?)";
			String[] param = { mac };
			map.put("customer", customerService.unique(hql, param));
		}
	}

	/**
	 * @Description:生成id;当数据库为空时，默认生成尾号0001
	 * @param tradePointservice
	 * @return
	 * @since:2015年7月20日 下午4:04:25
	 */
	@SuppressWarnings("unchecked")
	public static String getId(TradePointService tradePointservice) {
		String hql = "select MAX(tradePointNo) from TradePoint";
		String[] param = {};
		String id = "";
		List<String> list = tradePointservice.getObject(hql, param);
		String maxId = list.get(0);
		String date = DateUtils.formatFromDate("yyyyMMdd", new Date());
		if (null != maxId) {
			int sufix = Integer.parseInt(maxId.substring(8));
			sufix = sufix + 1;
			String temp = String.valueOf(sufix);
			if (null != temp) {
				if (temp.length() > 4) {
					temp.substring(temp.length() - 4, temp.length());
				} else {
					for (int i = 0; i < 4 - temp.length(); i++) {
						temp = "0" + temp;
					}
				}
			}
			id = date + temp;
		} else {// 数据库中不存在id
			id = date + "0001";
		}
		return id;
	}

}
