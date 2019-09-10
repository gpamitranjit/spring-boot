package com.amit.app.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
*
* @author Amit Patil
*
**/
public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("[LoginInterceptor-prehandle()] start");
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		logger.info("[LoginInterceptor-preHandle()] request URL: " + request.getRequestURL());
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("[LoginInterceptor-postHandle()] start");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("[LoginInterceptor-aftercompletion()] start");
		long endTime = System.currentTimeMillis();
		long totalProcessingTime = endTime - (long) request.getAttribute("startTime");
		logger.info("[LoginInterceptor-afterCompletion()] total request processing time: " + totalProcessingTime);
		super.afterCompletion(request, response, handler, ex);
	}
	
}
