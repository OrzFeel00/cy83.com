package com.yc3.ll.c83.s3.ll.bolg.dao;

import org.apache.ibatis.annotations.Select;

import com.yc3.ll.c83.s3.ll.bolg.bean.Category;

public interface CategoryMapper {
	//根据id查询分类
	@Select("select * from category where id=#{id}")
	public Category selectById(int id);

}
