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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sanploy.card.dao.utils.HqlHelper;
import com.sanploy.card.pojo.BankCardType;
import com.sanploy.card.pojo.KDLimit;
import com.sanploy.card.pojo.User;
import com.sanploy.card.service.BankCardTypeService;
import com.sanploy.card.service.CustomerService;
import com.sanploy.card.service.KDLimitService;
import com.sanploy.card.utils.Constant;
import com.sanploy.card.utils.DateUtils;

@Controller
@RequestMapping("/basedata")
public class BaseDataController {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(BaseDataController.class);

	@Autowired
	private BankCardTypeService bankCardTypeService;

	@Autowired
	private KDLimitService kdlimitService;

	@Autowired
	private CustomerService customerService;

	/**
	 * @Description:处理银行卡类型
	 * @return
	 * @since 2015年7月11日 上午2:30:18
	 */
	@RequestMapping("/addBankCardTypeUI")
	public String addBankCardTypeUI(Map<String, Object> map) {
		map.put("bankCardType", new BankCardType());
		return "basedata/addBankCardType";
	}

	/**
	 * @Description:银行卡类型：增,往数据库中插入之前，加入ajax判断是否存在编号
	 * @param bankCardType
	 * @param map
	 * @return
	 * @since:2015年7月13日 上午9:53:23
	 */
	@RequestMapping(value = "/addBankCardType", method = RequestMethod.POST)
	public String addBankCardType(BankCardType bankCardType, Map<String, Object> map, HttpServletRequest request) {
		User userFromSession = (User) request.getSession().getAttribute("user");
		bankCardType.setOperator(String.valueOf(userFromSession.getUserId()));
		bankCardTypeService.save(bankCardType);
		map.put("message", "添加成功！");
		return "basedata/addBankCardType";
	}

	@ResponseBody
	@RequestMapping(value = "/isBankCardTypeIdExist", method = RequestMethod.POST)
	public Map<String, String> isBankCardTypeIdExist(@RequestParam(value = "bankCardTypeId") String bankCardTypeId) {
		Map<String, String> map = new HashMap<String, String>();
		String hql = "from BankCardType where bankCardTypeId = ?";
		String[] param = { bankCardTypeId };
		BankCardType bct = bankCardTypeService.unique(hql, param);
		if (null == bct) {
			map.put("result", Constant.FAILED);
			map.put("info", "编号可以使用");
		} else {
			map.put("result", Constant.SUCCESS);
			map.put("info", "编号已经存在");
		}
		return map;
	}

	/**
	 * @Description:银行卡类型：删:注意不能删除有被扣点限制引用的数据，需要再处理,使用ajax先判断，给出提示；
	 * @param id
	 * @return
	 * @since:2015年7月13日 上午9:53:39
	 */
	@RequestMapping(value = "/deleteBankCardType/{id}", method = RequestMethod.DELETE)
	public String deleteBankCardType(@PathVariable String id) {
		bankCardTypeService.delete(id);
		return "redirect:/basedata";
	}

	@ResponseBody
	@RequestMapping(value = "/isBankCardTypeRefByCustomer", method = RequestMethod.POST)
	public Map<String, String> isBankCardTypeRefByCustomer(@RequestParam("bankCardTypeId") String bankCardTypeId) {
		Map<String, String> map = new HashMap<String, String>();
		// String hql = "from Customer where bankCardType.bankCardTypeId = ?";
		// String[] param = {bankCardTypeId};
		boolean isExist = customerService.isExists("bankCardType.bankCardTypeId", bankCardTypeId);
		if (isExist) {
			map.put("result", Constant.SUCCESS);
			map.put("info", "操作不被允许。\n当前银行卡类型已被客户引用，每个客户必须确定一个银行卡类型，要想删除此类型，需要将关联的客户删除！");
		} else {
			map.put("result", Constant.FAILED);
		}
		return map;
	}

	/**
	 * @Description:银行卡类型：改的页面
	 * @param id
	 * @param mav
	 * @return
	 * @since:2015年7月13日 上午9:53:56
	 */
	@RequestMapping(value = "/updateBankCardType/{id}", method = RequestMethod.GET)
	public ModelAndView updateBankCardType(@PathVariable String id, ModelAndView mav) {
		mav.addObject("bankCardType", bankCardTypeService.get(id));
		mav.setViewName("basedata/updateBankCardType");
		return mav;
	}

	/**
	 * @Description:银行卡类型:修改
	 * @param bankCardType
	 * @return
	 * @since:2015年7月13日 上午9:54:14
	 */
	@RequestMapping(value = "/updateBankCardType", method = RequestMethod.PUT)
	public ModelAndView updateBankCardType(BankCardType bankCardType, HttpServletRequest request) {
		User userFromSession = (User) request.getSession().getAttribute("user");
		bankCardType.setOperator(String.valueOf(userFromSession.getUserId()));
		bankCardTypeService.saveOrUpdate(bankCardType);
		return new ModelAndView("basedata/updateBankCardType").addObject("message", "修改成功！~");
	}

	/******************************** 扣点限制信息 ********************************/
	/**
	 * @Description:新增扣点限制页面:自动生成id
	 * @param map
	 * @return
	 * @since:2015年7月15日 下午4:12:05
	 */
	@RequestMapping("/addKDLimitUI")
	public String addKDLimitUI(Map<String, Object> map) {
		map.put("bankcardTypes", bankCardTypeService.list());
		KDLimit kdlimit = new KDLimit();
		kdlimit.setLimitNo(getId(kdlimitService));
		map.put("kdlimit", kdlimit);
		return "basedata/addKDLimit";
	}

	/**
	 * @Description:新增扣点限制操作：注意判断是否有相同的银行卡类型已经存在限制（最好通过ajax去判断）
	 * @param kdlimit
	 * @param map
	 * @return
	 * @since:2015年7月15日 下午4:12:31
	 */
	@RequestMapping(value = "/addKDLimit", method = RequestMethod.POST)
	public String addKDLimit(KDLimit kdlimit, Map<String, Object> map, HttpServletRequest request) {
		// 关联对象保存
		BankCardType bct = bankCardTypeService.get(kdlimit.getBankCardType().getBankCardTypeId());
		kdlimit.setBankCardType(bct);
		User userFromSession = (User) request.getSession().getAttribute("user");
		kdlimit.setOperator(String.valueOf(userFromSession.getUserId()));
		kdlimitService.save(kdlimit);
		map.put("message", "添加成功！");
		map.put("bankcardTypes", bankCardTypeService.list());
		KDLimit kdl = new KDLimit();
		kdl.setLimitNo(getId(kdlimitService));
		map.put("kdlimit", kdl);
		return "basedata/addKDLimit";
	}

	/**
	 * @Description:删除卡限制类型:转发到basedata
	 * @param id
	 * @return
	 * @since:2015年7月15日 下午4:13:28
	 */
	@RequestMapping(value = "/deleteKDLimit/{id}", method = RequestMethod.DELETE)
	public String deleteKDLimit(@PathVariable String id) {
		kdlimitService.delete(id);
		return "redirect:/basedata";
	}

	/**
	 * @Description:更新卡扣点限制的页面
	 * @param id
	 * @param mav
	 * @return
	 * @since:2015年7月15日 下午4:14:06
	 */
	@RequestMapping(value = "/updateKDLimit/{id}", method = RequestMethod.GET)
	public ModelAndView updateKDLimit(@PathVariable String id, ModelAndView mav) {
		mav.addObject("kdlimit", kdlimitService.get(id));
		mav.addObject("bankCardTypes", bankCardTypeService.list());
		mav.setViewName("basedata/updateKDLimit");
		return mav;
	}

	/**
	 * @Description:执行卡扣点限制修改的具体操作；
	 * @param kdlimit
	 * @param mav
	 * @return
	 * @since:2015年7月15日 下午4:14:36
	 */
	@RequestMapping(value = "/updateKDLimit", method = RequestMethod.PUT)
	public ModelAndView updateKDLimit(KDLimit kdlimit, ModelAndView mav, HttpServletRequest request) {
		// 关联对象保存
		BankCardType bct = bankCardTypeService.get(kdlimit.getBankCardType().getBankCardTypeId());
		kdlimit.setBankCardType(bct);
		User userFromSession = (User) request.getSession().getAttribute("user");
		kdlimit.setOperator(String.valueOf(userFromSession.getUserId()));
		kdlimitService.saveOrUpdate(kdlimit);
		mav.setViewName("basedata/updateKDLimit");
		mav.addObject("kdlimit", kdlimit);
		mav.addObject("bankCardTypes", bankCardTypeService.list());
		mav.addObject("message", "修改成功！~");
		return mav;
	}

	/**
	 * @Description:检查选择的银行卡，在卡限制里是否已经存在相应记录
	 * @param bankCardTypeId
	 * @return
	 * @since:2015年7月15日 下午4:33:19
	 */
	@ResponseBody
	@RequestMapping(value = "/isKDLimitExist", method = RequestMethod.POST)
	public Map<String, String> isExist(@RequestParam(value = "bankCardTypeId") String bankCardTypeId) {
		Map<String, String> map = new HashMap<String, String>();
		String hql = "from KDLimit where bankCardType.bankCardTypeId = ?";
		String[] param = { bankCardTypeId };
		KDLimit kdl = kdlimitService.unique(hql, param);
		if (null == kdl) {
			map.put(Constant.RESULT, Constant.FAILED);
		} else {
			map.put(Constant.RESULT, Constant.SUCCESS);
			map.put(Constant.INFO, "");
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public static String getId(KDLimitService kdlimitservice) {
		String hql = "select MAX(limitNo) from KDLimit";
		String[] param = {};
		List<String> list = kdlimitservice.getObject(hql, param);
		String id = "";
		String maxId = list.get(0);
		String date = DateUtils.formatFromDate("yyyyMMdd", new Date());
		if (null != maxId) {
			int sufix = Integer.parseInt(maxId.substring(8));
			sufix = sufix + 1;
			String temp = String.valueOf(sufix);
			if (null != temp) {
				if (temp.length() > 2) {
					temp.substring(temp.length() - 2, temp.length());
				} else {
					for (int i = 0; i < 2 - temp.length(); i++) {
						temp = "0" + temp;
					}
				}
			}
			id = date + temp;
		} else {
			id = date + "01";
		}
		return id;
	}

	/**
	 * @Description:默认基础数据模块首页
	 * @param map
	 * @return
	 * @since:2015年7月13日 上午9:59:50
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {
		HqlHelper bankCardTypeHqlHelper = new HqlHelper(BankCardType.class);
		HqlHelper kdlimitHqlHelper = new HqlHelper(KDLimit.class);
		map.put("b_page", bankCardTypeService.getPage(1, bankCardTypeHqlHelper));
		map.put("k_page", kdlimitService.getPage(1, kdlimitHqlHelper));
		return "basedata/list";
	}

	@RequestMapping(value = "/list/{bankCardType_currentPage}/{kdlimit_currentPage}", method = RequestMethod.GET)
	public String listDots(@PathVariable("bankCardType_currentPage") Integer bankCardType_currentPage, @PathVariable("kdlimit_currentPage") Integer kdlimit_currentPage, Map<String, Object> map) {
		// 使用分页查询
		HqlHelper bankCardTypeHqlHelper = new HqlHelper(BankCardType.class);
		HqlHelper kdlimitHqlHelper = new HqlHelper(KDLimit.class);
		map.put("b_page", bankCardTypeService.getPage(bankCardType_currentPage, bankCardTypeHqlHelper));
		map.put("k_page", kdlimitService.getPage(kdlimit_currentPage, kdlimitHqlHelper));
		return "basedata/list";
	}

}
