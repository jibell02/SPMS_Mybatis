package com.khrd.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.SpmsDAO;
import com.khrd.dao.SpmsDAOImpl;
import com.khrd.dto.Spms;
import com.khrd.util.MyBatisSqlSessionFactory;

public class ListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		SpmsDAO dao = SpmsDAOImpl.getInstance(sqlSession);
		List<Spms> list = dao.selectList();
		
		request.setAttribute("list", list);

		sqlSession.commit();
		sqlSession.close();
			
		return "/WEB-INF/view/list.jsp";
			
	}

}
