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

import com.sanploy.card.report.CardReportView;
import com.sanploy.card.report.pojo.DotReportCondition;
import com.sanploy.card.service.DotService;
import com.sanploy.card.utils.Constant;

/**
 * @Description:
 * @Author:
 * @Since: 2015年7月18日 上午2:13:53
 */
@Controller
@RequestMapping("/dotReport")
public class DotReportController {
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(DotReportController.class);

	@Autowired
	private DotService dotService;

	/**
	 * @Description:查询网点报表的首页展示
	 * @param map
	 * @return
	 * @since:2015年7月21日 上午11:18:45
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String dotReportUI(Map<String, Object> map) {
		// 准备回显的数据；
		map.put("dots", dotService.list());
		return "report/dotTradeQuery";
	}

	@RequestMapping(value = "/html", method = RequestMethod.POST)
	public ModelAndView dotTradeResolve(DotReportCondition condition) {
		Map<String, Object> map = new HashMap<String, Object>();// 封装参数
		map.put("startTime", condition.getStartDate());
		map.put("endTime", condition.getEndDate());
		if ("-1".equals(condition.getDotId())) {// 根据网点，生成报表中condition条件，或为"";
			map.put("condition", "");
		} else {
			map.put("condition", " and tp.dotId='" + condition.getDotId() + "'");
		}
		// map.put("dataSource", dataSource);// 数据源，为数据库连接
		map.put(CardReportView.DEFAULT_FORMAT_KEY, "pdf");
		return new ModelAndView("1".equals(condition.getDotReportType()) ? "dotTradeSummaryReport" : "dotTradeDetailReport", map);
	}

	@RequestMapping(value = "/excel", method = RequestMethod.POST)
	public ModelAndView dotTradeResolve(DotReportCondition condition, HttpServletRequest request) {
		// 封装参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startTime", condition.getStartDate());
		map.put("endTime", condition.getEndDate());
		if ("-1".equals(condition.getDotId())) {// 根据网点，生成报表中condition条件，或为"";
			map.put("condition", "");
		} else {
			map.put("condition", " and tp.dotId='" + condition.getDotId() + "'");
		}
		map.put(Constant.FORMAT, "xls");// 网页中查看
		map.put(CardReportView.ATTACHEMT_FILE_NAME_KEY, "1".equals(condition.getDotReportType()) ? "网点交易汇总表" : "网点交易明细表");
		return new ModelAndView("1".equals(condition.getDotReportType()) ? "dotTradeSummaryReport" : "dotTradeDetailReport", map);
	}

	/**
	 * form表单提交 Date类型数据绑定 <功能详细描述>:参数类型转换，主要处理日期格式由前端string转为date类型；
	 * 
	 * @param binder
	 * @see [类、类#方法、类#成员]
	 */
	// @InitBinder
	// public void initBinder(WebDataBinder binder) {
	// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	// dateFormat.setLenient(false);
	// binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,
	// true));
	// }

}
