package com.yc.user.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="order")//网元服务名
public interface IOrderAction {
	@GetMapping("order")//对方网元下对应的action 地址
	public String order();
}
