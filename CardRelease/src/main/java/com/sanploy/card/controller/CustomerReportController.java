/**
 * 
 */
package com.sanploy.card.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sanploy.card.pojo.Customer;
import com.sanploy.card.report.CardReportView;
import com.sanploy.card.report.pojo.CustomerReportCondition;
import com.sanploy.card.service.CustomerService;
import com.sanploy.card.utils.Constant;

/**
 * @Description:
 * @Author:
 * @Since: 2015年7月18日 上午2:13:53
 */
@Controller
@RequestMapping("/customerReport")
public class CustomerReportController {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(CustomerReportController.class);

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String customerReportUI(Map<String, Object> map) {
		// 准备回显的数据；
		map.put("customers", customerService.list());
		return "report/customerTradeQuery";
	}

	@RequestMapping(value = "/html", method = RequestMethod.POST)
	public ModelAndView customerTradeResolve(CustomerReportCondition condition) {
		Map<String, Object> map = new HashMap<String, Object>();// 封装参数
		map.put("startTime", condition.getStartDate());
		map.put("endTime", condition.getEndDate());

		if ("-1".equals(condition.getBankCardNo())) {// 根据客户，-1代表全体客户，生成报表中condition条件，或为"";
			map.put("condition", "");
		} else {
			Customer cust = customerService.get(condition.getBankCardNo());
			map.put("customerName", cust.getCustomerName());
			map.put("cardNo", cust.getCardNo());
			map.put("customerTel", cust.getCustomerTel());
			map.put("condition", " and c.bankCardNo='" + condition.getBankCardNo() + "'");
		}
		map.put(CardReportView.DEFAULT_FORMAT_KEY, "pdf");
		return new ModelAndView("1".equals(condition.getCustomerReportType()) ? "customerTradeSummaryReport" : "customerTradeDetailReport", map);
	}

	@RequestMapping(value = "/excel", method = RequestMethod.POST)
	public ModelAndView customerTradeResolve(CustomerReportCondition condition, HttpServletRequest request) {
		// 封装参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startTime", condition.getStartDate());
		map.put("endTime", condition.getEndDate());
		if ("-1".equals(condition.getBankCardNo())) {// 根据客户编号，-1代表全体客户；生成报表中condition条件，或为"";
			map.put("condition", "");
		} else {
			Customer cust = customerService.get(condition.getBankCardNo());
			map.put("customerName", cust.getCustomerName());
			map.put("cardNo", cust.getCardNo());
			map.put("customerTel", cust.getCustomerTel());
			map.put("condition", " and c.bankCardNo='" + condition.getBankCardNo() + "'");
		}
		map.put(Constant.FORMAT, "xls");// 网页中查看
		map.put(CardReportView.ATTACHEMT_FILE_NAME_KEY, "1".equals(condition.getCustomerReportType()) ? "客户交易汇总表" : "客户交易明细表");
		return new ModelAndView("1".equals(condition.getCustomerReportType()) ? "customerTradeSummaryReport" : "customerTradeDetailReport", map);
	}

}
