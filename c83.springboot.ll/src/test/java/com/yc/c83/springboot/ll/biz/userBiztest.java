package com.yc.c83.springboot.ll.biz;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.yc.c83.springboot.ll.dao.UserDao;
import com.yc.damai.bean.DmUser;

@SpringBootTest
public class userBiztest {
	@MockBean
	private UserDao udao;
	@Resource
	private UserBiz ubiz;
	
	@Test
	public void testLogin() {
		try {
			DmUser db=new DmUser();
			//模拟对象方法的返回结果
			Mockito.when(udao.selectByLogin("武松", "123")).thenReturn(db);
			DmUser user=ubiz.login("武松", "123");
			Assert.isTrue(user!=null,"没有用户");
		} catch (BizException e) {
			// TODO Auto-generated catch block
			Assert.isTrue(e==null,"dao类异常");
			e.printStackTrace();
		}
	}
}
