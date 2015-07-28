/**
 * 
 */
package com.sanploy.card.intercepter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sanploy.card.pojo.Function;
import com.sanploy.card.pojo.User;

/**@Description:
 * @Author:
 * @Since: 2015年7月16日 下午11:17:26
 */
public class AuthorityIntercepter implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(AuthorityIntercepter.class);
	/**
	 * 目标方法调用前，进行全新的检查，
	 * 1.是否是登录提交，登录的话，可以通过；
	 * 2.不是登录的情况，检查访问的权限；
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String path = request.getServletPath();
		logger.info("request path:" + path);
		System.out.println("request path:" + path);
		if(null != path){
			if("/login".equals(path) || "/".equals(path) /*|| (path.endsWith("png"))*/){//首先检查有没有登陆，登陆的时候不检查权限；检查权限不通过，转发到登陆页面，并放入信息到request中；
				return true;
			}else{
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("user");
				if(null == user) {//检查是否登陆
					request.setAttribute("message", "您未登陆,请先登陆!");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					return true;
				}else{//检查是否有访问权限
					@SuppressWarnings("unchecked")
					List<Function> list =  (List<Function>) session.getAttribute("functions");
					boolean contains = false;
					for(Function function : list){
						if(path.startsWith(function.getUrl())){
							contains = true;
							break;
						}
					}
					
					if(contains){//没有当前资源访问权限，返回到登陆页面；
						contains = false;
						return true;
					}else{
						request.setAttribute("message", "没有当前资源访问权限!");
						request.getRequestDispatcher("/login.jsp").forward(request, response);
						return false;
					}
				}
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {		// TODO Auto-generated method stub
		
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
		
	}

}
