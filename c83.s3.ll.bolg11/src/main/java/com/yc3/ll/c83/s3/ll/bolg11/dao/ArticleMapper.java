package com.yc3.ll.c83.s3.ll.bolg11.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc3.ll.c83.s3.ll.bolg11.bean.Article;



public interface ArticleMapper {
	
	@Select("select * from article order by createtime desc")
	public List<Article> selectByNew();
}
