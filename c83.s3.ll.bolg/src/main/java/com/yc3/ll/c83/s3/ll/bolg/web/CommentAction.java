package com.yc3.ll.c83.s3.ll.bolg.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc3.ll.c83.s3.ll.bolg.bean.Comment;
import com.yc3.ll.c83.s3.ll.bolg.bean.Result;
import com.yc3.ll.c83.s3.ll.bolg.bean.User;
import com.yc3.ll.c83.s3.ll.bolg.biz.CommentBiz;
import com.yc3.ll.c83.s3.ll.bolg.dao.CommentMapper;

@RestController
public class CommentAction {
	@Resource
	private CommentMapper cMapper;
	@Resource
	private CommentBiz cBiz;
	
	@PostMapping("comment")
	public Result comment(Comment comm, @SessionAttribute User loginedUser) {
		comm.setCreateby(loginedUser.getId());
		cBiz.create(comm);
		return new Result(1, "回复成功", comm);
	}
	
	@GetMapping("queryComm")
	public Result comment(int articleid) {
		return new Result(1, "查询回复成功", cMapper.selectByAricle(articleid));
	}


}
