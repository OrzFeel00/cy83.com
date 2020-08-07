package com.yc.favorite.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.yc.favorite.bean.Favorite;
import com.yc.favorite.bean.Tag;
import com.yc.favorite.util.MyBatisHelper;
import com.yc.favorite.FavoriteBiz;

public class BaseTest {
	
	
	private static final String FavoriteBiz = null;

	@Test
	public void Test1() {
		
		SqlSession session=MyBatisHelper.openSession();
		
		FavoriteMapper fm=session.getMapper(FavoriteMapper.class);
		TagMapper tm=session.getMapper(TagMapper.class);
		TagFavoriteMapper tfm=session.getMapper(TagFavoriteMapper.class);
		
		Favorite f=new Favorite();
		f.setFlabel("淘宝");
		f.setFurl("www.taobao.com");
		f.setFdesc("败家网站");
		f.setFtags("购物，生活");
		
		fm.insert(f);
		
		
		
		session.commit();
		session.close();
	 
		
	}
	
	@Test
	public void Test2() {
		
	   FavoriteBiz fb=new FavoriteBiz();
	   Favorite f=new Favorite();
	   f.setFlabel("淘宝");
	   f.setFurl("www.taobao.com");
	   f.setFdesc("败家网站");
	   f.setFtags("购物，生活");
	   fb.addFavorite(f);
	}
	
	@Test
	public void Test3() {
		
	   FavoriteBiz fb=new FavoriteBiz();
	   Favorite f=new Favorite();
	   f.setFlabel("网易");
	   f.setFurl("168.com");
	   f.setFdesc("好网站");
	   f.setFtags("军事，门户，生活");
	   fb.addFavorite(f);
	}
	
	@Test
	public void Test4() {
		SqlSession session=MyBatisHelper.openSession();
		FavoriteMapper fm=session.getMapper(FavoriteMapper.class);
		fm.selectByTid(null);
		fm.selectByTid(1);
		fm.selectByTid(0);
	}



}
