package com.yc.c83.springboot.ll.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.damai.bean.DmProduct;

public interface ProductMapper {
	@Select("select * from dm_product")
	List<DmProduct> selectAll();
	
	

}
