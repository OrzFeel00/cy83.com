package com.yc.order.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="user")//网元
public interface IUseraction {
	@GetMapping("user")//对应的action 地址
	public String user();

}
