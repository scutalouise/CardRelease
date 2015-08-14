package com.sanploy.card.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sanploy.card.service.CustomerService;
import com.sanploy.card.service.HairpinService;
import com.sanploy.card.service.TradePointService;

/**
 * @Description: 计划统计3个数据：今日发售多少新卡，今日多少客户消费，今日充值多少用户，当前共有多少客户
 * @author:scuta
 * @since:2015年7月16日
 * @version:default 0.0.0.1
 */
@Controller
@RequestMapping("/index")
public class IndexController {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private TradePointService tradePointService;

	@Autowired
	private HairpinService hairpinService;

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(HttpSession session, Map<String, Object> map) {
		// 封装数据1:用户总量
		int customer = customerService.count();
		map.put("customer", customer);
		// 封装数据2：今日消费多少次卡
		String trade4Sale = "select count(tradePointNo) from TradePoint where tradeType = 2 and to_days(tradeDate) = to_days(now())";
		String[] trade4SaleParam = {};
		int sale = tradePointService.count(trade4Sale, trade4SaleParam);
		map.put("sale", sale);
		// 封装数据3：今日共充值多少次卡
		String trade4Recharge = "select COUNT(tradePointNo) from TradePoint where tradeType = 1 and to_days(tradeDate) = to_days(now())";
		String[] trade4RechargeParam = {};
		int recharge = tradePointService.count(trade4Recharge, trade4RechargeParam);
		map.put("recharge", recharge);
		// 今天发卡数量：
		String hairpinSql = "select count(hairpinNo) from Hairpin where to_days(hairpinTime) = to_days(now())";
		String[] hairpinParam = {};
		int hairpin = hairpinService.count(hairpinSql, hairpinParam);
		map.put("hairpin", hairpin);

		// 所有数据放到session里，便于以后取用；
		session.setAttribute("customer", customer);
		session.setAttribute("sale", sale);
		session.setAttribute("recharge", recharge);
		session.setAttribute("hairpin", hairpin);

		return "index";
	}

}
