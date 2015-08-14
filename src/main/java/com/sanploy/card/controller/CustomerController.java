package com.sanploy.card.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sanploy.card.dao.utils.HqlHelper;
import com.sanploy.card.pojo.BankCardType;
import com.sanploy.card.pojo.Customer;
import com.sanploy.card.pojo.TradePoint;
import com.sanploy.card.pojo.User;
import com.sanploy.card.service.BankCardTypeService;
import com.sanploy.card.service.CustomerService;
import com.sanploy.card.service.HairpinService;
import com.sanploy.card.service.TradePointService;
import com.sanploy.card.utils.Constant;

/**
 * @Description:处理客户信息的控制器
 * @author:scuta
 * @since:2015年7月16日
 * @version:default 0.0.0.1
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@Autowired
	private BankCardTypeService bankCardTypeService;

	@Autowired
	private TradePointService tradePointService;

	@Autowired
	private HairpinService hairpinService;

	/**
	 * @Description:处理客户，新增页面
	 * @return
	 * @since 2015年7月11日 上午2:19:00
	 */
	@RequestMapping("/addCustomerUI")
	public String addUI(Map<String, Object> map) {
		map.put("bankCardTypes", bankCardTypeService.list());
		return "customer/addCustomer";
	}

	/**
	 * @Description:新增客户操作：新增客户时候，首先通过ajax检查是否有相同的银行卡号已经存在
	 * @param customer
	 * @param map
	 * @return
	 * @since:2015年7月13日 下午5:04:38
	 */
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String addCustomer(Customer customer, Map<String, Object> map, HttpServletRequest request) {
		// 新增客户的原始点数，与剩余点数相同，剩余点数需要单独设置；
		customer.setRemainingPt(customer.getOriginalPt());
		// customer与tradePoint有几个属性需要在此处方便设置
		TradePoint tradePoint = new TradePoint();
		User user = (User) request.getSession().getAttribute("user");
		tradePoint.setDot(user.getDot());
		tradePoint.setOperator(String.valueOf(user.getUserId()));
		tradePoint.setTradePointNo(TradePointController.getId(tradePointService));
		// Customer在7月中旬加入有loss标志和发卡区域，默认新增的时候为正常，即0
		customer.setLoss("0");
		customer.setOperator(String.valueOf(user.getUserId()));
		customerService.save(customer, tradePoint);
		map.put("customer", new Customer());
		map.put("bankCardTypes", bankCardTypeService.list());
		map.put("message", "添加成功");
		return "customer/addCustomer";
	}

	@ResponseBody
	@RequestMapping(value = "/isBankCardNoExist", method = RequestMethod.POST)
	public Map<String, String> isBankCardTypeIdExist(@RequestParam(value = "bankCardNo") String bankCardNo) {
		Map<String, String> map = new HashMap<String, String>();
		boolean isExist = customerService.isExists("bankCardNo", bankCardNo);
		if (isExist) {
			map.put("result", Constant.SUCCESS);
			map.put("info", "银行卡：" + bankCardNo + ",已经存在");
		} else {
			map.put("result", Constant.FAILED);
			map.put("info", "验证通过");
		}
		return map;
	}

	/**
	 * @Description:删除操作
	 * @param id
	 * @return
	 * @since:2015年7月13日 下午5:04:55
	 */
	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.DELETE)
	public String deleteCustomer(@PathVariable String id) {
		customerService.delete(id);
		return "redirect:/customer";
	}

	/**
	 * @Description: 修改页面
	 * @param customer
	 * @param mav
	 * @return
	 * @since:2015年7月13日 下午5:05:18
	 */
	@RequestMapping(value = "/updateCustomer/{id}", method = RequestMethod.GET)
	public ModelAndView updateCustomer(@PathVariable("id") String id, ModelAndView mav) {
		mav.addObject("customer", customerService.get(id));
		mav.addObject("bankCardTypes", bankCardTypeService.list());
		mav.setViewName("customer/updateCustomer");
		return mav;
	}

	/**
	 * @Description:修改操作：注意保留客户原有的初始点数与剩余点数不让修改；
	 * @param customer
	 * @param mav
	 * @return
	 * @since:2015年7月13日 下午5:08:34
	 */
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT)
	public ModelAndView updateCustomer(Customer customer, ModelAndView mav, HttpServletRequest request) {
		Customer customerFromDB = customerService.get(customer.getBankCardNo());

		BankCardType bankCardType = bankCardTypeService.get(customer.getBankCardType().getBankCardTypeId());
		customer.setBankCardType(bankCardType);
		BeanUtils.copyProperties(customer, customerFromDB, "originalPt", "remainingPt", "loss");
		User userFromSession = (User) request.getSession().getAttribute("user");
		customerFromDB.setOperator(String.valueOf(userFromSession.getUserId()));
		customerService.saveOrUpdate(customerFromDB);
		mav.setViewName("customer/updateCustomer");
		mav.addObject("customer", customer);
		mav.addObject("bankCardTypes", bankCardTypeService.list());
		mav.addObject("message", "修改成功！~");
		return mav;
	}

	/**
	 * @Description:分页列表
	 * @param map
	 * @return
	 * @since:2015年7月13日 下午5:05:43
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listCustomer(Map<String, Object> map) {
		// 使用分页查询
		HqlHelper hqlHelper = new HqlHelper(Customer.class);
		map.put("page", customerService.getPage(1, hqlHelper));
		return "customer/list";
	}

	/**
	 * @Description:带条件分页列表
	 * @param currentPage
	 * @param map
	 * @return
	 * @since:2015年7月13日 下午5:06:34
	 */
	@RequestMapping(value = "/{currentPage}", method = RequestMethod.GET)
	public String listCustomer(@PathVariable("currentPage") Integer currentPage, Map<String, Object> map) {
		// 使用分页查询
		HqlHelper hqlHelper = new HqlHelper(Customer.class);
		map.put("page", customerService.getPage(currentPage, hqlHelper));
		return "customer/list";
	}

	/**
	 * form表单提交 Date类型数据绑定 <功能详细描述>
	 * 
	 * @param binder
	 * @see [类、类#方法、类#成员]
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	
	
	

	/**
	 * @Description:对客户进行发卡时，检查卡号是否可用；直接使用LossController里的处理，查询；
	 * @param cardNo
	 * @return
	 * @since:2015年7月29日 上午11:11:04
	 */
	@Deprecated
	@ResponseBody
	@RequestMapping(value = "/isVipCardNoExist", method = RequestMethod.POST)
	public Map<String, String> isVipCardNoExist(@RequestParam(value = "cardNo") String cardNo) {
		Map<String, String> map = new HashMap<String, String>();
		// 首先判断，有没有初始化次卡号的记录；再判断是否已经有发此卡；
		boolean isExist = hairpinService.isExists("cardNo", cardNo);
		if (!isExist) {
			map.put("result", Constant.SUCCESS);// 此处为配合ajax前端处理，设置为success
			map.put("info", "卡号：" + cardNo + ",未初始化");
			return map;
		}
		isExist = customerService.isExists("cardNo", cardNo);
		if (isExist) {
			map.put("result", Constant.SUCCESS);
			map.put("info", "卡号：" + cardNo + ",已经存在并发给了其他客户");
		} else {
			map.put("result", Constant.FAILED);
			map.put("info", "验证通过");
		}
		return map;
	}


}
