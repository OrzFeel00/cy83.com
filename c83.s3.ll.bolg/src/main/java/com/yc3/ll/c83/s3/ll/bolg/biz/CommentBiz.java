package com.yc3.ll.c83.s3.ll.bolg.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc3.ll.c83.s3.ll.bolg.bean.Comment;
import com.yc3.ll.c83.s3.ll.bolg.dao.CommentMapper;

@Service
public class CommentBiz {
	@Resource
	private CommentMapper cMapper;
	
	public Comment create(Comment comm) {
		cMapper.insert(comm);
		return comm;
	}

}
