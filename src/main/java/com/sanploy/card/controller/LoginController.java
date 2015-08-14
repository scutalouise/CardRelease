package com.sanploy.card.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sanploy.card.pojo.Function;
import com.sanploy.card.pojo.Role;
import com.sanploy.card.pojo.RoleFunction;
import com.sanploy.card.pojo.User;
import com.sanploy.card.service.FunctionService;
import com.sanploy.card.service.RoleFunctionService;
import com.sanploy.card.service.UserService;
import com.sanploy.card.utils.DateUtils;
import com.sanploy.card.utils.MD5Tools;

@Controller
@RequestMapping("/login")
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private RoleFunctionService roleFunctionService;

	@Autowired
	private FunctionService functionService;

	/**
	 * @Description:对登录用户进行验证：1.用户名/密码是否正确；2.在1满足的时候获取用户的角色、功能；3.角色是否可用；4.功能是否可用；5.在3、4可用的情况下，放入到session中，并跳转到index页面；
	 * @param loginName
	 * @param password
	 * @param map
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @since:2015年7月17日 下午1:36:59
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void login(@RequestParam("loginName") String loginName, @RequestParam("password") String password, Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 检查loginName，password是否在user中存在，
		String hql = "from User where loginName = ? and password = ?";
		String[] param = { loginName, MD5Tools.getMD5(password) };
		User user = userService.unique(hql, param);
		if (null != user) {// 登录用户名和密码正确，封装index页面需要的数据，跳转到Index页面；
			//用户的角色是否可用：
			Role role = user.getRole();
			if(null == role){
				request.setAttribute("message", "您没有分配系统角色");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{
				if("0".equals(role.getState())){//角色状态可用
					//判断有效期
					if(DateUtils.compare(new Date(), role.getValidTime())){
						request.setAttribute("message", "角色有效期已过");
						request.getRequestDispatcher("/login.jsp").forward(request, response);
						return;
					}else{
						// 将user放入到session中
						request.getSession().setAttribute("user", user);
						// user权限判断
						List<Function> fList = new ArrayList<Function>();
						String roleFunctionHql = "from RoleFunction where role.roleId = ? order by function.functionId ASC";
						Long[] roleFunctionParam = { user.getRole().getRoleId() };
						List<RoleFunction> roleFunctions = roleFunctionService.getObject(roleFunctionHql, roleFunctionParam);
						for (RoleFunction rf : roleFunctions) {
							//判断，功能是否是可用的，可用的时候才添加
							if("1".equals(rf.getFunction().getState())){
								fList.add(rf.getFunction());
							}
						}
						// 将user拥有的功能，放入到session;如果没有功能，需要处理
						if(fList.size() == 0){
							request.getRequestDispatcher("/login.jsp").forward(request, response);
							return;
						}
						request.getSession().setAttribute("functions", fList);
						response.sendRedirect(request.getContextPath() + fList.get(0).getUrl());
//						response.sendRedirect(request.getContextPath() + "/index");
					}
				}else{
					request.setAttribute("message", "您的系统角色未启用");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					return;
				}
			}
		} else {
			request.setAttribute("message", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}


	/**
	 * @Description:
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @since:2015年7月17日 上午9:32:08
	 */
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET)
	public void loginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("functions");
		try {
			 request.getRequestDispatcher("/login.jsp").forward(request,response);
		} catch (Exception e) {
			logger.error("loginOut", e);
			e.printStackTrace();
		}
	}

}
