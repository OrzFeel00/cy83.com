package com.yc.c83.springboot.ll;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.yc.c83.springboot.ll.biz.MailService;
import com.yc.c83.springboot.ll.dao.ProductMapper;

@SpringBootTest
class ApplicationTests {
	@Resource
	ProductMapper pm;
	@Resource
	MailService ms;

	@Test
	void contextLoads() {
		Assert.isTrue(pm.selectAll().size() >0,"没有数据");
	}
	
	@Test
	void testMail() {
		ms.sendSimplelMail("632360579@qq.com", "密码重置验证消息", "您的密码已更新！123xcd1q13");
	
	}

}
