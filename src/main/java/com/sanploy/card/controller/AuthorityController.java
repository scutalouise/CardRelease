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
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sanploy.card.dao.utils.HqlHelper;
import com.sanploy.card.pojo.Dot;
import com.sanploy.card.pojo.Function;
import com.sanploy.card.pojo.Role;
import com.sanploy.card.pojo.RoleFunction;
import com.sanploy.card.pojo.User;
import com.sanploy.card.service.DotService;
import com.sanploy.card.service.FunctionService;
import com.sanploy.card.service.RoleFunctionService;
import com.sanploy.card.service.RoleService;
import com.sanploy.card.service.UserService;
import com.sanploy.card.utils.Constant;
import com.sanploy.card.utils.MD5Tools;

@Controller
@RequestMapping("/authority")
public class AuthorityController {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(AuthorityController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private FunctionService functionService;

	@Autowired
	private RoleFunctionService roleFunctionService;

	@Autowired
	private DotService dotService;

	/******************************** 处理用户 ******************************************/
	/**
	 * @Description:新增系统用户的UI
	 * @return
	 * @since:2015年7月10日 下午5:45:22
	 */
	@RequestMapping("/addUserUI")
	public String addUI(Map<String, Object> map) {
		map.put("dots", dotService.list());
		map.put("roles", roleService.list());
		map.put("user", new User());
		return "authority/addUser";
	}

	/**
	 * @Description:新增系统用户的操作过程:需要先检查，是否登录名已经存在：
	 * @param user
	 * @return
	 * @since:2015年7月14日 上午9:25:23
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(User user, Map<String, Object> map, HttpServletRequest request) {
		// 设置对象与其关联对象的关系
		if (null != user.getDot().getDotId()) {
			Dot dot = new Dot();
			dot = dotService.get(user.getDot().getDotId());
			user.setDot(dot);
		} else {
			user.setDot(null);
		}
		if (user.getRole().getRoleId() > 0) {
			Role role = new Role();
			role = roleService.get(user.getRole().getRoleId());
			user.setRole(role);
		} else {
			user.setRole(null);
		}
		User usrFromSession = (User) request.getSession().getAttribute("user");
		user.setOperateDate(new Date());// 默认的一些属性设置：
		user.setOperator(String.valueOf(usrFromSession.getUserId()));// 从session载入
		user.setPassword(MD5Tools.getMD5(user.getPassword()));// 对密码进行加密
		// 执行保存
		userService.save(user);

		map.put("dots", dotService.list());
		map.put("roles", roleService.list());
		map.put("message", user.getLoginName() + ":保存成功!~");
		return "authority/addUser";
	}

	/**
	 * @Description:删除一个系统用户
	 * @param id
	 * @return
	 * @since:2015年7月14日 上午9:25:50
	 */
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		userService.delete(id);
		return "redirect:/authority";
	}

	/**
	 * @Description:更新系统用户的UI
	 * @param id
	 * @return
	 * @since:2015年7月14日 上午9:26:08
	 */
	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET)
	public ModelAndView updateUserUI(@PathVariable Long id, ModelAndView mov) {
		mov = new ModelAndView("authority/updateUser");
		mov.addObject("user", userService.get(id));
		mov.addObject("dots", dotService.list());
		mov.addObject("roles", roleService.list());
		return mov;
	}

	/**
	 * @Description:对系统用户的更新
	 * @param user
	 * @return
	 * @since:2015年7月14日 上午9:30:07
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public ModelAndView updateUser(User user, ModelAndView mov, HttpServletRequest request) {
		mov = new ModelAndView("authority/updateUser");
		User userFromDB = userService.get(user.getUserId());
		// 设置与user关联的对象关系
		if (!"-1".equals(user.getDot().getDotId())) {
			Dot dot = new Dot();
			dot = dotService.get(user.getDot().getDotId());
			user.setDot(dot);
		} else {
			user.setDot(null);
		}
		if (user.getRole().getRoleId() > 0) {
			Role role = new Role();
			role = roleService.get(user.getRole().getRoleId());
			user.setRole(role);
		} else {
			user.setRole(null);
		}
		User usrFromSession = (User) request.getSession().getAttribute("user");
		user.setOperateDate(new Date());
		user.setOperator(String.valueOf(usrFromSession.getUserId()));// 从session载入
		BeanUtils.copyProperties(user, userFromDB, "password");
		userService.update(userFromDB);
		// 往客户端返回视图数据
		mov.addObject("dots", dotService.list());
		mov.addObject("roles", roleService.list());
		mov.addObject("user", user);
		mov.addObject("message", "更新成功！~");
		return mov;
	}

	/**
	 * @Description:检查用户名是否存在:注意要筛选判断是否是在修改，是在修改的话，需要判断，当前的loginName是否与之前的相同；
	 * @param loginName
	 * @return
	 * @since:2015年7月16日 下午5:36:35
	 */
	@ResponseBody
	@RequestMapping(value = "/isLoginNameExist", method = RequestMethod.POST)
	public Map<String, String> isLoginNameExist(@RequestParam("loginName") String loginName, @RequestParam(value = "userId", required = false, defaultValue = "-1") String userId) {
		Map<String, String> map = new HashMap<String, String>();
		// 检查是否存在用户名，
		if ("-1".equals(userId)) {// 沒有传用户id，说明是在添加user；
			String checkUserHql = "from User where loginName = ?";
			String[] checkUserParam = { loginName };
			if (null != userService.unique(checkUserHql, checkUserParam)) {// 通知到客户端!
				map.put(Constant.RESULT, Constant.SUCCESS);
				map.put(Constant.INFO, "已经存在,不能使用");
			} else {
				map.put(Constant.INFO, "可以使用");
				map.put(Constant.RESULT, Constant.FAILED);
			}
		} else {
			User user = userService.get(Long.parseLong(userId));
			if (loginName.equals(user.getLoginName())) {
				map.put(Constant.RESULT, Constant.FAILED);// 代表可以使用
				map.put(Constant.INFO, "");
			} else {
				String checkUserHql = "from User where loginName = ?";
				String[] checkUserParam = { loginName };
				if (null != userService.unique(checkUserHql, checkUserParam)) {// 通知到客户端!
					map.put(Constant.RESULT, Constant.SUCCESS);
					map.put(Constant.INFO, "已经存在,不能使用");
				} else {
					map.put(Constant.RESULT, Constant.FAILED);
					map.put(Constant.INFO, "可以使用");
				}
			}
		}
		return map;
	}

	/**
	 * @Description:用户修改密码，首先判断其当前密码是否正确;通过ajax进行通讯
	 * @param userId
	 * @param password
	 * @param map
	 * @return
	 * @since:2015年7月15日 上午9:56:02
	 */
	@ResponseBody
	@RequestMapping(value = "/isPasswordCorrect", method = RequestMethod.POST)
	public Map<String, String> isExist(@RequestParam("userId") Long userId, @RequestParam("password") String password) {
		Map<String, String> map = new HashMap<String, String>();
		if (null != userId && null != password) {
			String hql = "from User where userId = ? and password = ?";
			Object[] param = { userId, MD5Tools.getMD5(password) };
			User user = userService.unique(hql, param);
			if (null == user) {
				map.put("result", "failed");
				map.put("info", "当前密码不正确！");
			} else {
				map.put("result", "success");
				map.put("info", "验证通过！");
			}
		}
		return map;
	}

	/**
	 * @Description:密码修改的页面
	 * @param userId
	 * @param map
	 * @return
	 * @since:2015年7月15日 上午9:34:35
	 */
	@RequestMapping(value = "/updatePasswordUI/{userId}", method = RequestMethod.GET)
	public String updatePassword(@PathVariable("userId") Long userId, Map<String, Object> map) {
		if (null != userId && userId > 0) {
			map.put("user", userService.get(userId));
		}
		return "authority/updatePassword";
	}

	/**
	 * @Description:密码修改的操作过程，主要修改password、operateDate,Operater;其他属性不变，此处不使用modelAttribute
	 * @param userId
	 * @param password
	 * @param map
	 * @return
	 * @since:2015年7月15日 上午9:34:48
	 */
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public String updatePassword(@RequestParam("userId") Long userId, @RequestParam(value = "password", required = false) String password, Map<String, Object> map, HttpServletRequest request) {
		User user = null;
		if (null != userId && userId > 0) {
			user = userService.get(userId);
			if (null != user) {
				if (null != password && password.length() > 0) {
					user.setPassword(MD5Tools.getMD5(password));
					user.setOperateDate(new Date());
					User userFromSession = (User) request.getSession().getAttribute("user");
					user.setOperator(String.valueOf(userFromSession.getUserId()));// 从session中载入
					userService.update(user);
					map.put("message", user.getLoginName() + ":修改成功，系统将在您下次登录时使用新密码验证！");
				}
			} else {
				map.put("message", "没找到用户信息!密码修改不成功");
			}
		}
		return "authority/updatePassword";
	}

	/******************************** 处理角色 ******************************************/
	/**
	 * @Description:新增角色的页面
	 * @param map
	 * @return
	 * @since:2015年7月16日 上午10:52:02
	 */
	@RequestMapping(value = "/addRoleUI", method = RequestMethod.GET)
	public String addRole(Map<String, Object> map) {
		map.put("role", new Role());
		return "authority/addRole";
	}

	/**
	 * @Description:新增角色的具体操作流程
	 * @param role
	 * @param map
	 * @return
	 * @since:2015年7月16日 上午10:52:25
	 */
	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public String addRole(Role role, Map<String, Object> map, HttpServletRequest request) {
		// 设置未在前端提交的信息
		role.setSetTime(new Date());
		role.setOperateDate(new Date());
		User userFromSession = (User) request.getSession().getAttribute("user");
		role.setOperator(String.valueOf(userFromSession.getUserId()));
		roleService.save(role);// 执行保存操作
		map.put("message", "保存成功！");
		return "authority/addRole";
	}

	/**
	 * @Description:刪除角色的操作
	 * @param id
	 * @return
	 * @since:2015年7月16日 上午10:52:47
	 */
	@RequestMapping(value = "/deleteRole/{id}", method = RequestMethod.DELETE)
	public String deleteRole(@PathVariable Long id) {
		roleService.delete(id);
		return "redirect:/authority";
	}

	/**
	 * @Description:更新角色的页面
	 * @param id
	 * @param map
	 * @return
	 * @since:2015年7月16日 上午10:53:20
	 */
	@RequestMapping(value = "/updateRole/{id}", method = RequestMethod.GET)
	public String updateRole(@PathVariable Long id, Map<String, Object> map) {
		map.put("role", roleService.get(id));
		return "authority/updateRole";
	}

	/**
	 * @Description:修改角色的操作：某些属性不修改，因此使用modelAttribute从数据库中加载一次
	 * @param role
	 * @param map
	 * @return
	 * @since:2015年7月16日 上午10:53:37
	 */
	@RequestMapping(value = "/updateRole", method = RequestMethod.PUT)
	public String updateRole(@ModelAttribute("role4update") Role role, Map<String, Object> map, HttpServletRequest request) {
		// 创建时间不修改
		role.setOperateDate(new Date());
		User userFromSession = (User) request.getSession().getAttribute("user");
		role.setOperator(String.valueOf(userFromSession.getUserId()));
		roleService.saveOrUpdate(role);
		map.put("role", role);
		map.put("message", "修改成功！~");
		return "authority/updateRole";
	}

	/**
	 * @Description:主要为修改的操作，某些属性不修改，因此使用modelAttribute从数据库中加载一次
	 * @param roleId
	 * @param model
	 * @since:2015年7月16日 上午10:55:15
	 */
	@ModelAttribute(value = "/updateRole")
	public void populateModel(@RequestParam(value = "roleId", required = false) Long roleId, Model model) {
		if (null != roleId && roleId > 0) {
			model.addAttribute("role4update", roleService.get(roleId));
		}
	}

	/******************************** 处理系统功能 ******************************************/
	/**
	 * @Description:新加系统功能的页面
	 * @param map
	 * @return
	 * @since:2015年7月16日 上午10:46:46
	 */
	@RequestMapping(value = "/addFunctionUI", method = RequestMethod.GET)
	public String addFunction(Map<String, Object> map) {
		map.put("function", new Function());
		return "authority/addFunction";
	}

	/**
	 * @Description:新加系统功能的具体操作流程
	 * @param function
	 * @param map
	 * @return
	 * @since:2015年7月16日 上午10:47:10
	 */
	@RequestMapping(value = "/addFunction", method = RequestMethod.POST)
	public String addFunction(Function function, Map<String, Object> map, HttpServletRequest request) {
		// 设置未在前端提交的某些不为空的参数
		function.setCreateDate(new Date());
		function.setOperateDate(new Date());
		User userFromSession = (User) request.getSession().getAttribute("user");
		function.setOperator(String.valueOf(userFromSession.getUserId()));
		function.setParentId(null);// 由于数据库表设计时有考虑到多级结构，因此需要设置关联关系；

		functionService.save(function);
		map.put("message", function.getFunctionName() + ":添加成功！~");
		return "authority/addFunction";
	}

	/**
	 * @Description:修改系统功能的页面
	 * @param id
	 * @param map
	 * @return
	 * @since:2015年7月16日 上午10:47:46
	 */
	@RequestMapping(value = "/updateFunction/{id}", method = RequestMethod.GET)
	public String updateFunction(@PathVariable Long id, Map<String, Object> map) {
		map.put("function", functionService.get(id));
		return "authority/updateFunction";
	}

	/**
	 * @Description:修改系统功能的具体操作流程：修改的时候某些属性(创建时间...)不能修改，因此使用modelAttribute处理，从数据库中加载
	 * @param function
	 * @param map
	 * @return
	 * @since:2015年7月16日 上午10:48:04
	 */
	@RequestMapping(value = "/updateFunction", method = RequestMethod.PUT)
	public String updateFunction(@ModelAttribute("function4update") Function function, Map<String, Object> map, HttpServletRequest request) {
		function.setOperateDate(new Date());
		User userFromSession = (User) request.getSession().getAttribute("user");
		function.setOperator(String.valueOf(userFromSession.getUserId()));

		function.setParentId(null);// 由于数据库表设计时有考虑到多级结构，因此需要设置关联关系；
		functionService.saveOrUpdate(function);
		map.put("message", function.getFunctionName() + "修改成功！~");
		return "authority/updateFunction";
	}

	/**
	 * @Description:辅助处理系统功能的修改，某些属性不被修改，从数据库中加载一次；
	 * @param function
	 * @param model
	 * @since:2015年7月16日 上午10:49:12
	 */
	@ModelAttribute(value = "/updateFunction")
	public void populateFunction(Function function, Model model) {
		if (null != function) {
			model.addAttribute("function4update", functionService.get(function.getFunctionId()));
		}
	}

	/**
	 * @Description:删除一个系统功能的操作,设置了级联删除对应的role、function关系
	 * @param id
	 * @param mav
	 * @return
	 * @since:2015年7月16日 上午10:49:46
	 */
	@RequestMapping(value = "/deleteFunction/{id}")
	public ModelAndView deleteFunction(@PathVariable("id") Long id, ModelAndView mav) {
		functionService.delete(id);
		mav.setViewName("redirect:/authority");
		return mav;
	}

	/******************************** 处理角色与系统功能关系 ******************************************/
	/**
	 * @Description:角色与功能的关系设定UI,注意封装数据
	 * @param id
	 * @param map
	 * @return
	 * @since:2015年7月16日 上午10:43:26
	 */
	@RequestMapping(value = "/addRoleFunctionUI/{roleId}", method = RequestMethod.GET)
	public String addRoleFunction(@PathVariable(value = "roleId") Long id, Map<String, Object> map) {
		map.put("role", roleService.get(id));
		map.put("functions", functionService.list());
		String hql = "from RoleFunction where role.roleId = ?";
		Long[] param = { id };
		map.put("roleFunctions", roleFunctionService.getObject(hql, param));
		map.put("roleFunction", new RoleFunction());
		return "authority/addRoleFunction";
	}

	/**
	 * @Description:角色与功能设定，具体操作流程；
	 * @param functionIds
	 * @param map
	 * @return
	 * @since:2015年7月16日 上午10:43:52
	 */
	@RequestMapping(value = "/addRoleFunction", method = RequestMethod.POST)
	public String addRoleFunction(@RequestParam("roleId") Long id, @RequestParam("functionId") Long[] functionIds, Map<String, Object> map, HttpServletRequest request) {
		// TODO先将rolefunction中，roleId对应的所有功能删除掉，级联删除；再对rolefunction进行保存；
		// 执行保存RoleFunction操作
		User userFromSession = (User) request.getSession().getAttribute("user");
		String operator = String.valueOf(userFromSession.getUserId());
		roleFunctionService.save(id, functionIds, operator);

		System.out.println(functionIds);
		map.put("role", roleService.get(id));
		map.put("functions", functionService.list());
		String hql = "from RoleFunction where role.roleId = ?";
		Long[] param = { id };
		map.put("roleFunctions", roleFunctionService.getObject(hql, param));
		map.put("message", "保存成功！~");
		return "authority/addRoleFunction";
	}

	/************************* 默认authority首页： *************************************/
	/**
	 * @Description:默认首页，默认的pageSize, page
	 * @param map
	 * @return
	 * @since:2015年7月16日 上午10:44:42
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String authority(Map<String, Object> map) {
		HqlHelper userHql = new HqlHelper(User.class);
		HqlHelper roleHql = new HqlHelper(Role.class);
		HqlHelper functionHql = new HqlHelper(Function.class);
		map.put("user_page", userService.getPage(1, userHql));
		map.put("role_page", roleService.getPage(1, roleHql));
		map.put("function_page", functionService.getPage(1, functionHql));
		return "authority/list";
	}

	/**
	 * @Description:authority首页传过来的每个具体子功能对应的页数；
	 * @param user_currentPage
	 * @param role_currentPage
	 * @param function_currentPage
	 * @param map
	 * @return
	 * @since:2015年7月16日 上午10:45:06
	 */
	@RequestMapping("/{user_currentPage}/{role_currentPage}/{function_currentPage}")
	public String authority(@PathVariable("user_currentPage") Integer user_currentPage, @PathVariable("role_currentPage") Integer role_currentPage,
			@PathVariable("function_currentPage") Integer function_currentPage, Map<String, Object> map) {
		HqlHelper userHql = new HqlHelper(User.class);
		HqlHelper roleHql = new HqlHelper(Role.class);
		HqlHelper functionHql = new HqlHelper(Function.class);
		map.put("user_page", userService.getPage(user_currentPage, userHql));
		map.put("role_page", roleService.getPage(role_currentPage, roleHql));
		map.put("function_page", functionService.getPage(function_currentPage, functionHql));
		return "authority/list";
	}

	/**
	 * form表单提交 Date类型数据绑定 <功能详细描述>:参数类型转换，主要处理日期格式由前端string转为date类型；
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

}
