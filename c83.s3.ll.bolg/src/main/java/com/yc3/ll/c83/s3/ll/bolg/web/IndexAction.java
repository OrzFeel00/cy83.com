package com.yc3.ll.c83.s3.ll.bolg.web;



import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc3.ll.c83.s3.ll.bolg.dao.ArticleMapper;

@Controller
public class IndexAction {
    @Resource
	private ArticleMapper ampper;

	@GetMapping("/")
	public String index( Model m) {
		m.addAttribute("alist",ampper.selectByNew());
		System.out.println("ooo");
	 return "index";
	}
}
