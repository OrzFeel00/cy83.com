package com.yc.user.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class UserAction {
	@Resource
	 private RestTemplate resttemplate;
	@GetMapping("user")
	public String user(HttpServletRequest req) {
		return String.format("server:user ; ip:%s; port:%s",
				    req.getLocalAddr(),
				    req.getLocalPort());
	}
	//测试地址 127.0.0.1:8001/order
	@GetMapping("order")
	public String user() {
	//	String url="http://127.0.0.1:8002/order";
		String url="http://order/order";//前面是服务名，后面是url地址       ,,,分布式系统内部远程调用的地址
		String res=resttemplate.getForObject(url, String.class);
		return res;
	}
	
	@Resource
	IOrderAction ioa;
	
	@GetMapping("order1")
	public String order1() {
		return ioa.order();
	}
	

}
