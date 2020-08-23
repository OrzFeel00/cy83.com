package com.yc.c83.springboot.ll.biz;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.util.Hashtable;

import javax.websocket.Session;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@ServerEndpoint(value = "/websocket/{id}")
@Component
public class MywebSocket {
	//Hashtable用来存放每个客户端的id:session 键值对      hashmap它线程不安全的（可以空值为键）     hashtable线程安全（不可以）（这里一点定会多线程，所以用hashtable
	private static Hashtable<String, Session> webSocketMap =new Hashtable<>();
	//连接建立成功调用的方法
	@OnOpen
	public void onOpen(@PathParam("id") String id,Session session) {
		System.out.println(id+" 已经连接成功");
		//传入
		webSocketMap.put(id, session);
	}
//连接关闭调用的方法
	@OnClose
	public void onClose(Session session) {
		//移除会话
		
	}
	
	//收到客户端消息后调用的方法
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		//消息假设格式  id:msg      
		
		String[] ss=message.split(":");
		String id=ss[0];
		String msg=ss[1];
		Session targetSession =webSocketMap.get(id);
		//一定要判断，会话对象可能会失效
		if(targetSession !=null) {
			//传入msg
			targetSession.getBasicRemote().sendText(msg);
		}else {
			System.out.println(id+ "不在线");
		}
	}
	
	

}
