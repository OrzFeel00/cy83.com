package com.yc3.ll.c83.s3.ll.bolg.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc3.ll.c83.s3.ll.bolg.bean.Article;
import com.yc3.ll.c83.s3.ll.bolg.dao.ArticleMapper;

@Service
public class ArticleBiz {
	@Resource
	private ArticleMapper aMapper;
	
	public int create(Article art) {
		return aMapper.insert(art);
	}

}
