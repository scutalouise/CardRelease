package com.sanploy.card.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sanploy.card.service.CardOperService;
import com.sanploy.card.service.CustomerService;
import com.sanploy.card.service.HairpinService;
import com.sanploy.card.utils.CardKeyGenerator;
import com.sanploy.card.utils.Constant;
import com.sanploy.card.utils.DateUtils;

@Controller
@RequestMapping("/loss")
public class LossController {

	private static Logger logger = LoggerFactory.getLogger(LossController.class);

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CardOperService cardOperService;

	@Autowired
	private HairpinService hairpinService;

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
	 * @return
	 * @since 2015年7月27日 下午10:40:05
	 */
	@RequestMapping(value = "/lossHandle", method = RequestMethod.POST)
	public String lossHandle(@RequestParam(value = "cardNo") String cardNo) {
		// 挂失卡的处理：新生成一条记录在卡操作记录表cardOper中，并修改customer表中的对应卡状态；

		return null;
	}

	/**
	 * @Description:解挂失的处理
	 * @param cardNo
	 * @return
	 * @since 2015年7月27日 下午10:40:16
	 */
	@RequestMapping(value = "/cancelLossHandle", method = RequestMethod.POST)
	public String cancelLossHandle(@RequestParam(value = "cardNo") String cardNo) {
		// 解除挂失的处理：首先判断是否为挂失卡；接着，新生成一条记录在卡操作记录表cardOper中，并修改customer表中的对应卡状态；

		return null;
	}

	/**
	 * @Description:补卡的处理过程；
	 * @param oldCardNo
	 * @param newCardNo
	 * @return
	 * @since 2015年7月27日 下午10:40:31
	 */
	@RequestMapping(value = "/reReleaseHandle", method = RequestMethod.POST)
	public String reReleaseHandle(@RequestParam(value = "oldCardNo") String oldCardNo, @RequestParam(value = "newCardNo") String newCardNo) {
		// 补卡，前提是已挂失卡，补卡时新增已挂失卡记录，在customer中标记为补卡；并按照新发卡写入发卡和消费记录；

		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/isCardNoExist", method = RequestMethod.POST)
	public Map<String, String> isCardNoExist(@RequestParam(value = "cardNo") String cardNo) {
		Map<String, String> map = new HashMap<String, String>();
		// 首先判断，有没有初始化次卡号的记录；再判断是否已经有发此卡；
		boolean isExist = hairpinService.isExists("cardNo", cardNo);
		if (!isExist) {
			map.put("result", Constant.NOTINITIAL);
			map.put("info", "卡号：" + cardNo + ",未初始化");
			return map;
		}
		isExist = customerService.isExists("cardNo", cardNo);
		if (isExist) {
			map.put("result", Constant.SUCCESS);
			map.put("info", "卡号：" + cardNo + ",存在");
		} else {
			map.put("result", Constant.FAILED);
			map.put("info", cardNo + "卡初始化,但并未发放给任何一个客户");
		}
		return map;
	}

	/**
	 * @Description:读卡返回密钥
	 * @param macAddress
	 * @return
	 * @since 2015年7月27日 下午10:39:41
	 */
	@ResponseBody
	@RequestMapping(value = "/getKey/{mac}", method = RequestMethod.POST)
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
}
