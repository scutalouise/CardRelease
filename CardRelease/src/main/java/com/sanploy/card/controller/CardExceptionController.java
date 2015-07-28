/**
 * 
 */
package com.sanploy.card.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description:全局的异常处理器
 * @Author:
 * @Since: 2015年7月17日 上午1:11:49
 */
@ControllerAdvice
public class CardExceptionController {

	private static Logger logger = LoggerFactory.getLogger(CardExceptionController.class); 
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handle(HttpServletRequest request, Exception e) throws Exception {
		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
			try {
				throw e;
			} catch (Exception e1) {
				logger.error(null, request.getRequestURL(), e1);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		mav.addObject("exception", e);
		mav.addObject("url", request.getRequestURL());
		return mav;
	}

}
