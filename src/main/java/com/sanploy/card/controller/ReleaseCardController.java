package com.sanploy.card.controller;

import java.util.Date;
import java.util.HashMap;
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

import com.sanploy.card.pojo.Hairpin;
import com.sanploy.card.pojo.User;
import com.sanploy.card.service.CustomerService;
import com.sanploy.card.service.HairpinService;
import com.sanploy.card.utils.CardKeyGenerator;
import com.sanploy.card.utils.Constant;
import com.sanploy.card.utils.DateUtils;

/**
 * @Description:发卡核心控制器
 * @author:scuta
 * @since:2015年7月1日
 * @version:default 0.0.0.1
 */
@Controller
@RequestMapping("/cardRelease")
public class ReleaseCardController {

	private static Logger logger = LoggerFactory.getLogger(ReleaseCardController.class);

	@Autowired
	private HairpinService hairpinService;// 需要将发卡记录，保存下来；

	@Autowired
	private CustomerService customerService;

	/**
	 * @Description:发卡跳转页面；
	 * @return
	 * @since 2015年7月16日 下午11:04:40
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String cardRelease() {
		return "release/cardRelease";
	}

	/**
	 * @Description:发卡核心操作；返回密钥
	 * @param macAddress
	 * @return
	 * @since 2015年7月13日 下午9:32:17
	 */
	@ResponseBody
	@RequestMapping(value = "/getKey/{mac}", method = RequestMethod.GET)
	public Map<String, String> getKey(@PathVariable("mac") String macAddress) {
		System.out.println("getKey from mac:" + macAddress);
		// 记录日志
		StringBuilder sb = new StringBuilder();
		sb.append(DateUtils.formatFromDate(new Date()) + "----mac:" + macAddress + "----\n");
		Map<String, String> map = CardKeyGenerator.getKey(macAddress);
		for (String key : map.keySet()) {
			System.out.println(key + ":" + map.get(key));
			sb.append(key + ":" + map.get(key) + "\n");
		}
		logger.info(sb.toString());
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/release", method = RequestMethod.POST)
	public Map<String, String> releaseCard(@RequestParam("mac") String macAddress, @RequestParam("cardNo") String cardNo, HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		// 放入数据库;放入数据库的时候，id生成需要按照规则去组合：yyyyMMdd****;
		Hairpin hairpin = new Hairpin();
		hairpin.setCardNo(cardNo);
		hairpin.setCardPhysicalAdd(macAddress);
		hairpin.setHairpinTime(new Date());
		hairpin.setOperateDate(new Date());
		User userFromSession = (User) request.getSession().getAttribute("user");
		hairpin.setOperator(String.valueOf(userFromSession.getUserId()));
		hairpinService.save(hairpin);
		// 发卡信息已经记录成功，则返回密钥与结果
		map.put(Constant.RESULT, Constant.SUCCESS);
		map.putAll(getKey(macAddress));
		return map;
	}

	/**
	 * @Description:判断卡号是否存在，发卡的时候保证，不重复
	 * @param cardNo
	 * @return
	 * @since 2015年7月19日 下午11:34:02
	 */
	@ResponseBody
	@RequestMapping(value = "/isCardNoExist", method = RequestMethod.POST)
	public Map<String, Object> isCardNoExist(@RequestParam("cardNo") String cardNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (hairpinService.isExists("cardNo", cardNo)) {
			map.put(Constant.RESULT, Constant.SUCCESS);
			map.put(Constant.INFO, cardNo + "已经存在,不能重复发卡");
		} else {
			map.put(Constant.RESULT, Constant.FAILED);
			map.put(Constant.INFO, "可以使用");
		}
		;
		return map;
	}

}
