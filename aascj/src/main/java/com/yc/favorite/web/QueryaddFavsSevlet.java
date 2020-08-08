package com.yc.favorite.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.yc.favorite.FavoriteBiz;
import com.yc.favorite.bean.Favorite;
import com.yc.favorite.dao.FavoriteMapper;
import com.yc.favorite.util.MyBatisHelper;

@WebServlet("/addFavs.do")
public class QueryaddFavsSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public QueryaddFavsSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		SqlSession session=MyBatisHelper.openSession();
		//FavoriteMapper tm=session.getMapper(FavoriteMapper.class);
		 FavoriteBiz fb=new FavoriteBiz();
		   Favorite f=new Favorite();
		String bm = request.getParameter("bm");
		String ads = request.getParameter("ads");
		String ca = request.getParameter("ca");
		String a = request.getParameter("a");
		
		 if(bm==null || bm.trim().isEmpty() || "null".equals(bm)) {
	
			 response.sendRedirect("http://localhost:8089/aascj/sos.html");
			}else if(ads==null || ads.trim().isEmpty() || "null".equals(ads)) {
				response.sendRedirect("http://localhost:8089/aascj/sos.html");
			}else if(ca==null || ca.trim().isEmpty() || "null".equals(ca)) {
				response.sendRedirect("http://localhost:8089/aascj/sos.html");
			}else if(a==null || a.trim().isEmpty() || "null".equals(a)) {
				response.sendRedirect("http://localhost:8089/aascj/sos.html");
			}else {
		
		
		   f.setFlabel(bm);
		   f.setFurl(ads);
		   f.setFdesc(ca);
		   f.setFtags(a);
		   fb.addFavorite(f);
		  
		   response.sendRedirect("http://localhost:8089/aascj/index.html");
		   }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
