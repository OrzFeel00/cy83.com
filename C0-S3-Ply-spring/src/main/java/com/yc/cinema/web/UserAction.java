package com.yc.cinema.web;
import org.springframework.stereotype.Controller;

import com.yc.cinema.biz.CommentsBiz;
import com.yc.cinema.biz.UserBiz;


@Controller
public class UserAction {
	
	private UserBiz ubiz;
	
	private CommentsBiz cbiz;

	public UserBiz getUbiz() {
		return ubiz;
	}

	public void setUbiz(UserBiz ubiz) {
		this.ubiz = ubiz;
	}

	public CommentsBiz getCbiz() {
		return cbiz;
	}

	public void setCbiz(CommentsBiz cbiz) {
		this.cbiz = cbiz;
	}

}
