package com.yc.cinema.biz;

import org.springframework.stereotype.Service;

import com.yc.cinema.dao.CommentsDao;
import com.yc.cinema.dao.MovieDao;

@Service
public class CommentsBiz {

	private UserBiz ubiz;

	private CommentsDao cdao;

	private MovieDao mdao;

	public UserBiz getUbiz() {
		return ubiz;
	}

	public void setUbiz(UserBiz ubiz) {
		this.ubiz = ubiz;
	}

	public CommentsDao getCdao() {
		return cdao;
	}

	public void setCdao(CommentsDao cdao) {
		this.cdao = cdao;
	}

	public MovieDao getMdao() {
		return mdao;
	}

	public void setMdao(MovieDao mdao) {
		this.mdao = mdao;
	}

}
