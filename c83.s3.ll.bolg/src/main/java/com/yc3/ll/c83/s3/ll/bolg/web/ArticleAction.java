package com.yc3.ll.c83.s3.ll.bolg.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.yc3.ll.c83.s3.ll.bolg.bean.Article;
import com.yc3.ll.c83.s3.ll.bolg.bean.User;
import com.yc3.ll.c83.s3.ll.bolg.biz.ArticleBiz;
import com.yc3.ll.c83.s3.ll.bolg.dao.ArticleMapper;
import com.yc3.ll.c83.s3.ll.bolg.util.Utils;



@RestController
public class ArticleAction {

	@Resource
	private ArticleBiz abiz;

	/*
	 * Controller里的写法，返回的是返回视图
	 * @GetMapping("toAddArticle")
	public String toAddArticle() {
		return "addArticle";
	}*/
	
	@Resource
	private ArticleMapper amapper;
	
	@GetMapping("article")
	public ModelAndView article(int id, ModelAndView mav) {
		mav.addObject("article", amapper.selectById(id));
		mav.setViewName("article");
		return mav;
	}
	
	
	//这里是@RestController返回视图的方式
	@GetMapping("toAddArticle")//to...转到某个页面（命名习惯） xxxx.do让服务器在进行业务
	public ModelAndView toAddArticle(ModelAndView mav) {
		mav.setViewName("addArticle");
		return mav;
	}

	@PostMapping("addArticle.do")
	public ModelAndView addArticle(@Valid Article a, Errors errors, ModelAndView mav,
			@SessionAttribute("loginedUser") User user) {

		// ModelAndView = Model + View
		if (errors.hasErrors()) {
			mav.addObject("errors", Utils.asMap(errors));//m.addAttribute("errors", Utils.asMap(errors));同理
			mav.addObject("article", a);
			mav.setViewName("addArticle");//跳转页面到addarticle
			System.out.println("ooooooooooooooooooo");
		} else {
			// 作者的名字写入文章实体 ==> loginUser
			a.setAuthor(user.getName());
			abiz.create(a);
			// a.id ==> 有值 ==> 数据库的自增列 ==> MyBatis(获取自增列） ==> @Options
			//redirect响应重定向     把article?id=" + a.getId()发送给浏览器，浏览器把这个的地址重新发给请求给服务器，最后访问到页面
			mav.setViewName("redirect:article?id=" + a.getId()); // 未完待续 .. 展示新添加的文章
		}
		return mav;
	}

}