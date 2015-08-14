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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sanploy.card.pojo.CardOper;
import com.sanploy.card.pojo.Customer;
import com.sanploy.card.pojo.Hairpin;
import com.sanploy.card.pojo.User;
import com.sanploy.card.service.CardOperService;
import com.sanploy.card.service.CustomerService;
import com.sanploy.card.service.HairpinService;
import com.sanploy.card.service.TradePointService;
import com.sanploy.card.utils.Constant;
import com.sanploy.card.utils.DateUtils;

@Controller
@RequestMapping("/loss")
public class LossController {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LossController.class);

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CardOperService cardOperService;

	@Autowired
	private HairpinService hairpinService;

	@Autowired
	private TradePointService tradePointService;

	/**
	 * @Description:转发到挂失的页面
	 * @return
	 * @since:2015年7月27日 下午5:09:26
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toLoss() {
		return "loss/loss";
	}

	/**
	 * @Description:挂失卡的处理
	 * @param cardNo
	 * @param request
	 * @return
	 * @since:2015年7月28日 上午9:46:03
	 */
	@ResponseBody
	@RequestMapping(value = "/lossHandle", method = RequestMethod.POST)
	public Map<String, String> lossHandle(@RequestParam(value = "cardNo") String cardNo, @ModelAttribute Customer customer, HttpServletRequest request) {
		// 挂失卡的处理：查出cardno对应的customer；新生成一条记录在卡操作记录表cardOper中，并修改customer表中的对应卡状态；
		CardOper cardOper = wrapCardOper(cardNo, customer, request);// 已经封装了5个通用属性
		cardOper.setRemainingPt(customer.getRemainingPt());
		cardOper.setOperType("1");// (1-挂失 2-解挂 3-补卡)
		String id = LossController.getId(cardOperService);
		cardOper.setOperNo(id);// 生成主键id
		// 修改customer
		customer.setLoss("1");// 失卡(0-非失卡 1-失卡 2-挂失已补卡)
		Map<String, String> map = new HashMap<String, String>();
		if (id.equals(cardOperService.save(cardOper, customer))) {
			map.put(Constant.RESULT, Constant.SUCCESS);
			map.put(Constant.INFO, "挂失成功");
		} else {
			map.put(Constant.RESULT, Constant.FAILED);
			map.put(Constant.INFO, "挂失失败");
		}
		return map;
	}

	/**
	 * @Description:解挂失的处理
	 * @param cardNo
	 * @param customer
	 * @param request
	 * @return
	 * @since:2015年7月28日 上午10:00:17
	 */
	@ResponseBody
	@RequestMapping(value = "/cancelLossHandle", method = RequestMethod.POST)
	public Map<String, String> cancelLossHandle(@RequestParam(value = "cardNo") String cardNo, @ModelAttribute Customer customer, HttpServletRequest request) {
		// 解除挂失的处理：加载对应cardno的customer；首先判断是否为挂失卡；接着，新生成一条记录在卡操作记录表cardOper中，并修改customer表中的对应卡状态；
		Map<String, String> map = new HashMap<String, String>();
		if ("1".equals(customer.getLoss())) {// 失卡(0-非失卡 1-失卡 2-挂失已补卡)
			// 新增一条cardOper记录；
			CardOper cardOper = wrapCardOper(cardNo, customer, request);// 已经封装了5个通用属性
			cardOper.setRemainingPt(customer.getRemainingPt());
			cardOper.setOperType("2");// (1-挂失 2-解挂 3-补卡)
			String id = LossController.getId(cardOperService);
			cardOper.setOperNo(id);// 生成主键id
			// 修改customer中loss状态
			customer.setLoss("0");// 非挂失
			if (id.equals(cardOperService.save(cardOper, customer))) {
				map.put(Constant.RESULT, Constant.SUCCESS);
				map.put(Constant.INFO, "解除挂失成功");
			} else {
				map.put(Constant.RESULT, Constant.FAILED);
				map.put(Constant.INFO, "解除挂失失败");
			}
		} else {
			map.put(Constant.RESULT, Constant.FAILED);
			map.put(Constant.INFO, "非挂失卡");
		}
		return map;
	}

	/**
	 * @Description:补卡的处理过程；
	 * @param oldCardNo
	 * @param newCardNo
	 * @param customer
	 * @param request
	 * @return
	 * @since:2015年7月28日 上午10:00:07
	 */
	@ResponseBody
	@RequestMapping(value = "/reReleaseHandle", method = RequestMethod.POST)
	public Map<String, String> reReleaseHandle(@RequestParam(value = "oldCardNo") String oldCardNo, @RequestParam(value = "newCardNo") String newCardNo, @ModelAttribute Customer customer,
			HttpServletRequest request) {
		// 补卡，前提是已挂失卡并且没有解挂失，补卡时新增已挂失卡记录，在customer中标记为补卡；并按照新增客户写入客户记录(此处为修改客户)和新增消费记录；
		Map<String, String> map = new HashMap<String, String>();
		if ("1".equals(customer.getLoss())) {// 挂失卡(0-非失卡 1-失卡 2-挂失已补卡)
			// 新增一条cardOper记录；
			CardOper cardOper = wrapCardOper(oldCardNo, customer, request);// 已经封装了5个通用属性
			cardOper.setNewCardNo(newCardNo);
			cardOper.setRemainingPt(customer.getRemainingPt());
			cardOper.setOperType("3");// (1-挂失 2-解挂 3-补卡)
			String id = LossController.getId(cardOperService);
			cardOper.setOperNo(id);// 生成主键id
			// 修改customer中loss状态与补卡相关的信息
			customer.setLoss("2");// 挂失已补办
			customer.setCardNo(newCardNo);
			if (id.equals(cardOperService.save(cardOper, customer))) {
				map.put(Constant.RESULT, Constant.SUCCESS);
				map.put(Constant.INFO, "补卡成功");
			} else {
				map.put(Constant.RESULT, Constant.FAILED);
				map.put(Constant.INFO, "补卡失败");
			}
		} else {
			map.put(Constant.RESULT, Constant.FAILED);
			map.put(Constant.INFO, "非挂失卡");
		}
		return map;
	}

	/**
	 * @Description:对挂失卡和补办的卡号的ajax判断:用户可能录入(使用cardNo判断);当使用读卡器读取时(使用mac判断)
	 * @param cardNo
	 * @return
	 * @since:2015年7月28日 下午1:23:53
	 */
	@ResponseBody
	@RequestMapping(value = "/isLossCardExist", method = RequestMethod.POST)
	public Map<String, Object> isLossCardExist(@RequestParam(value = "cardNo", required = false) String cardNo, @RequestParam(value = "mac", required = false) String mac) {
		Map<String, Object> map = new HashMap<String, Object>();
		/**
		 * 判断逻辑：1.是否初始化；2.是否发给客户 [含有非挂失、挂失、挂失已补办]；3.是否属于失卡，并且已经进行了补卡；
		 */
		map = LossController.getMapByMac(mac, cardNo, hairpinService);// 已经封装了通用的操作：卡是否初始化
		if (null == map.get(Constant.RESULT)) {// 已经初始化
			String temp = (String) map.get("cardNo");
			String hql = "from Customer where cardNo = ?";// 失卡(0-非失卡1-失卡2-挂失已补卡)
			Customer customer = customerService.unique(hql, new String[] { temp });
			if (null != customer) {// 此卡是属于某个客户;判断下当前卡状态
				if ("0".equals(customer.getLoss())) {
					map.put(Constant.RESULT, Constant.SUCCESS);
					map.put("info", "卡号：" + temp + ",存在,并正在使用!");
				}
				if ("1".equals(customer.getLoss())) {
					map.put(Constant.RESULT, Constant.LOSS);
					map.put("info", "卡号：" + temp + ",已经挂失!");
				}
				map.put("cardNo", temp);
			} else {// 此卡目前不属于某个客户,接着判断下，此卡是否属于挂失卡且已补办；
				String hqlForCardOper = "from CardOper where operType = '3' and  oldCardNo = ?";
				if (null != cardOperService.unique(hqlForCardOper, new String[] { temp })) {// 此卡并非有挂失过
					map.put("result", Constant.RERELEASED);
					map.put("info", temp + "此卡为挂失卡，并且已经有进行补卡...");
				} else {
					map.put("result", Constant.FAILED);
					map.put("info", temp + "卡已经初始化,并且没有发放给任何一个客户");
				}
			}
		}

		return map;
	}

	/**
	 * @Description:提取的工具类
	 * @param mac
	 * @param hairpinService
	 * @return
	 * @since:2015年7月28日 下午3:00:30
	 */
	public static Map<String, Object> getMapByMac(String mac, String cardNo, HairpinService hairpinService) {
		Map<String, Object> map = new HashMap<String, Object>();
		String cardNoFromMac = null;
		/**
		 * 根据mac判断过程：1.是否初始化，2.已经将此卡发给客户并且已挂失
		 */
		if (null != mac) {// 根据卡物理地址，找到客户；
			// 根据卡物理地址，找到卡号；
			String hqlForCardNo = "from Hairpin where cardPhysicalAdd = ?";
			String[] paramForCardNo = { mac };
			Hairpin hairpin = hairpinService.unique(hqlForCardNo, paramForCardNo);
			if (null == hairpin) {
				map.put(Constant.RESULT, Constant.NOTINITIAL);
				map.put(Constant.INFO, "此卡未初始化.");
			} else {
				cardNoFromMac = hairpin.getCardNo();
				if (null == cardNoFromMac) {
					map.put("result", Constant.NOTINITIAL);
					map.put("info", "卡未初始化,找不到相应的信息");
					return map;
				}
			}
			map.put("cardNo", null == cardNoFromMac ? "" : cardNoFromMac);
		}

		/**
		 * 根据卡号判断是否可挂失的条件：1.卡是否初始化；2.已经将此卡发给客户并且已挂失
		 */
		if (null != cardNo) {
			// 首先判断，有没有初始化卡号的记录；再判断是否为挂失卡；
			boolean isExist = hairpinService.isExists("cardNo", cardNo);
			if (!isExist) {
				map.put("result", Constant.NOTINITIAL);
				map.put("info", "卡号：" + cardNo + ",未初始化");
				return map;
			}
			map.put("cardNo", cardNo);
		}

		return map;

	}

	/**
	 * @Description:生成CardOper的id;当数据库为空时，默认生成尾号0001
	 * @param tradePointservice
	 * @return
	 * @since:2015年7月20日 下午4:04:25
	 */
	@SuppressWarnings("unchecked")
	public static String getId(CardOperService cardOperService) {
		String hql = "select MAX(operNo) from CardOper";
		String[] param = {};
		String id = "";
		List<String> list = cardOperService.getObject(hql, param);
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

	/**
	 * @Description:封装对象通用属性
	 * @param cardNo
	 * @param customer
	 * @param request
	 * @return
	 * @since:2015年7月28日 下午3:04:46
	 */
	private CardOper wrapCardOper(String cardNo, Customer customer, HttpServletRequest request) {
		CardOper cardOper = new CardOper();
		cardOper.setOldCardNo(cardNo);
		User user = (User) request.getSession().getAttribute("user");
		cardOper.setDot(user.getDot());
		cardOper.setOperateDate(new Date());
		cardOper.setOperator(String.valueOf(user.getUserId()));
		cardOper.setOperDate(new Date());
		// customer的通用属性
		customer.setOperateDate(new Date());
		customer.setOperator(String.valueOf(user.getUserId()));
		return cardOper;
	}

	@ModelAttribute
	public void populateCardOper(@RequestParam(value = "cardNo", required = false) String cardNo, @RequestParam(value = "oldCardNo", required = false) String oldCardNo, Map<String, Object> map) {
		String hql = "from Customer where cardNo = ?";
		Customer customer = null;
		if (null != cardNo && !"".equals(cardNo)) {
			customer = customerService.unique(hql, new String[] { cardNo });
			map.put("customer", customer);
		}

		if (null != oldCardNo && !"".equals(oldCardNo)) {
			customer = customerService.unique(hql, new String[] { oldCardNo });
			map.put("customer", customer);
		}
	}

}
