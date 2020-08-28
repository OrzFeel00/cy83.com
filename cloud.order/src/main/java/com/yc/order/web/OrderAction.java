package com.yc.order.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class OrderAction {
	@Resource
	private RestTemplate resttemplate;
	@GetMapping("order")
	public String order( HttpServletRequest sql) {
		return String.format("server:user ; ip:%s; port:%s",
				sql.getLocalAddr(),
				sql.getLocalPort());
	}
	//测试地址 127.0.0.1:8002/user
	@GetMapping("user")
	public String user() {
	//	String url="http://127.0.0.1:8001/user";
		String url="http://user/user";
		String res=resttemplate.getForObject(url, String.class);//返回类型这里是string的类对象
		return res;
	}
	
	@Resource
	IUseraction iua;
	
	@GetMapping("user1")
	public String user1() {
		//声明式远程服务调用
		return  iua.user();
	}
	


}
