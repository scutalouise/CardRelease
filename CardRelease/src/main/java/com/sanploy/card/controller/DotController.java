package com.sanploy.card.controller;

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

import com.sanploy.card.dao.utils.HqlHelper;
import com.sanploy.card.pojo.Dot;
import com.sanploy.card.pojo.User;
import com.sanploy.card.service.DotService;
import com.sanploy.card.utils.Constant;

/**
 * @Description:处理网点类
 * @Author:
 * @Since: 2015年7月15日 下午10:02:55
 */
@Controller
@RequestMapping("/dot")
public class DotController {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(DotController.class);

	@Autowired
	private DotService dotService;

	/**
	 * @Description: 添加页面
	 * @param map
	 * @return
	 * @since 2015年7月15日 下午10:03:16
	 */
	@RequestMapping("/addDotUI")
	public String addUI(Map<String, Object> map) {
		map.put("dot", new Dot());
		return "dot/addDot";
	}

	/**
	 * @Description:添加的具体操作过程：:添加前使用ajax判断是否存在相同的id；
	 * @param dot
	 * @param request
	 * @return
	 * @since 2015年7月15日 下午10:03:59
	 */
	@RequestMapping(value = "/addDot", method = RequestMethod.POST)
	public String addDot(Dot dot, HttpServletRequest request) {
		User userFromSession = (User) request.getSession().getAttribute("user");
		dot.setOperator(String.valueOf(userFromSession.getUserId()));
		dotService.save(dot);
		request.setAttribute("dot", new Dot());
		request.setAttribute("message", "添加成功");
		return "dot/addDot";
	}

	@ResponseBody
	@RequestMapping(value = "/isDotIdExist", method = RequestMethod.POST)
	public Map<String, String> isisDotIdExist(@RequestParam(value = "dotId") String dotId) {
		Map<String, String> map = new HashMap<String, String>();
		boolean isExist = dotService.isExists("dotId", dotId);
		if (isExist) {
			map.put("result", Constant.SUCCESS);
			map.put("info", "网点编号：" + dotId + ",已经存在");
		} else {
			map.put("result", Constant.FAILED);
			map.put("info", "验证通过");
		}
		return map;
	}

	/**
	 * @Description:删除操作：是否有外部引用？有的话，需要判断，是否能删除；
	 * @param id
	 * @return
	 * @since 2015年7月15日 下午10:04:21
	 */
	@RequestMapping(value = "/deleteDot/{id}", method = RequestMethod.DELETE)
	public String deleteDot(@PathVariable String id) {
		dotService.delete(id);
		return "redirect:/dot";
	}

	/**
	 * @Description:更新的UI页面；
	 * @param id
	 * @param map
	 * @return
	 * @since 2015年7月15日 下午10:04:34
	 */
	@RequestMapping(value = "/updateDot/{id}", method = RequestMethod.GET)
	public String updateDotUI(@PathVariable String id, Map<String, Object> map) {
		map.put("dot", dotService.get(id));
		return "dot/updateDot";
	}

	/**
	 * @Description:更新的具体操作过程
	 * @param dot
	 * @param map
	 * @return
	 * @since 2015年7月15日 下午10:06:03
	 */
	@RequestMapping(value = "/updateDot", method = RequestMethod.PUT)
	public String updateDot(Dot dot, Map<String, Object> map, HttpServletRequest request) {
		// Dot d = dotService.get(dot.getDotId());
		// BeanUtils.copyProperties(dot, d);
		User userFromSession = (User) request.getSession().getAttribute("user");
		dot.setOperator(String.valueOf(userFromSession.getUserId()));
		dotService.saveOrUpdate(dot);
		map.put("message", "修改成功!");
		return "dot/updateDot";
	}

	/**
	 * @Description:dot首页显示，默认
	 * @param map
	 * @return
	 * @since 2015年7月15日 下午10:06:16
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listDots(Map<String, Object> map) {
		// 使用分页查询
		HqlHelper hqlHelper = new HqlHelper(Dot.class);
		map.put("page", dotService.getPage(1, hqlHelper));
		return "dot/list";
	}

	/**
	 * @Description:dot翻页显示，之后可扩展条件筛选；
	 * @param currentPage
	 * @param map
	 * @return
	 * @since 2015年7月15日 下午10:06:42
	 */
	@RequestMapping(value = "/{currentPage}", method = RequestMethod.GET)
	public String listDots(@PathVariable("currentPage") Integer currentPage, Map<String, Object> map) {
		// 使用分页查询
		HqlHelper hqlHelper = new HqlHelper(Dot.class);
		map.put("page", dotService.getPage(currentPage, hqlHelper));
		return "dot/list";
	}

}
