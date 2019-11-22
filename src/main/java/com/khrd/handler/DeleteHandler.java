package com.khrd.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.SpmsDAO;
import com.khrd.dao.SpmsDAOImpl;
import com.khrd.util.MyBatisSqlSessionFactory;

public class DeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String sNo = request.getParameter("no");
		int no = Integer.parseInt(sNo);
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		SpmsDAO dao = SpmsDAOImpl.getInstance(sqlSession);
		dao.delete(no);
		
		sqlSession.commit();
		sqlSession.close();
		
		response.sendRedirect(request.getContextPath() + "/list.do");
		return null;
	}

}
