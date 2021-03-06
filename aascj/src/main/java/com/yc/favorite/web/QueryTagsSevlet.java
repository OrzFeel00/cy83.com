package com.yc.favorite.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.yc.favorite.dao.TagMapper;
import com.yc.favorite.util.MyBatisHelper;

/**
 * Servlet implementation class QueryTagSevlet
 */
public class QueryTagsSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public QueryTagsSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		SqlSession session=MyBatisHelper.openSession();
		TagMapper tm=session.getMapper(TagMapper.class);
		
		Gson gson=new Gson();
		String json =gson.toJson(tm.selectAll());
		response.getWriter().append(json);
 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
