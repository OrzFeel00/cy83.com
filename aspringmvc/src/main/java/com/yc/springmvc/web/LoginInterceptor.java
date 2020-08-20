package com.yc.springmvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
//判断是否登录的拦截器
@Component//通用主键注解
public class LoginInterceptor  implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 判断当前是否登录
		if(request.getSession().getAttribute("logineduser")==null) {
			//根据当前的请求方式返回不同结果
			//判断当前是页面跳转还是ajax
			String accept=request.getHeader("Accept");
			if(accept.startsWith("application/json")) {
				//ajax请求
				response.getWriter().append("{code:0,msg:'请先登录系统''}");
			}else {
				//页面跳转
				response.setContentType( "text/html;charset=utf-8");
				response.sendRedirect("/login.html");
			}
			return false;
		}else {
			
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	//重写方法
	

}
