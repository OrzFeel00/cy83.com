package com.yc.springmvc.web;

import java.util.List;

import javax.validation.Valid;


import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.bean.DmUser;
import com.yc.damai.bean.Result;

@RestController
@RequestMapping("demo")
public class validAction {
	//@Valid加在属性前表示要验证
	//在校验对象后紧跟一个Errors对象
	
	@RequestMapping("reg.do")
	public Result reg(@Valid DmUser du, Errors errors) {
		/*
		 * errors.hasErrors(); //判断是否有错误
		errors.hasFieldErrors()//判断是否有字段错误
		//错误分层  对象级错误  字段级错误  全局错误
		
		 * 
		 * */
		if(errors.hasErrors()) {
			return new Result(0,"错了戳我",errors.getAllErrors());
			
		}else {
			return new Result(1, "ok");
		}
		
		
	}

}
