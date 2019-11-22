package com.khrd.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.SpmsDAO;
import com.khrd.dao.SpmsDAOImpl;
import com.khrd.dto.Spms;
import com.khrd.util.MyBatisSqlSessionFactory;

public class ReadHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String sNo = request.getParameter("no");
		int no = Integer.parseInt(sNo);
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		SpmsDAO dao = SpmsDAOImpl.getInstance(sqlSession);
		Spms spms = dao.selectByNo(no);
		
		request.setAttribute("spms", spms);

		sqlSession.commit();
		sqlSession.close();
		
			
		return "/WEB-INF/view/read.jsp";
		
	}

}
