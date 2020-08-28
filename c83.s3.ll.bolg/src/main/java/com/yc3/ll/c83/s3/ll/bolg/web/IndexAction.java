package com.yc3.ll.c83.s3.ll.bolg.web;



import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.yc3.ll.c83.s3.ll.bolg.dao.ArticleMapper;

@Controller
public class IndexAction {
    @Resource
	private ArticleMapper amapper;

	@GetMapping("/") 
	//数据模型
	//@RequestParam(defaultValue = "1")  请求参数，默认的给page设置配1
	public String index( Model m,@RequestParam(defaultValue = "1")int page) {
		//查询语句执行之前，加上分页语句可以动态的增添sql语句.设置分页参数,page==>页数
		PageHelper.startPage(page,5);
		//alist 模型名字，把结果存入alist
		m.addAttribute("alist",amapper.selectByNew());
	 return "index";
	}
	

}
