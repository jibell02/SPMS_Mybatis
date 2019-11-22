package com.khrd.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.SpmsDAO;
import com.khrd.dao.SpmsDAOImpl;
import com.khrd.dto.Spms;
import com.khrd.util.MyBatisSqlSessionFactory;

public class UpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request.getMethod().equalsIgnoreCase("get")) {
			String sNo = request.getParameter("no");
			int no = Integer.parseInt(sNo);
			request.setAttribute("no", no);
			
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			SpmsDAO dao = SpmsDAOImpl.getInstance(sqlSession);
			Spms spms = dao.selectByNo(no);
			
			request.setAttribute("spms", spms);

			sqlSession.commit();
			sqlSession.close();
			
			return "/WEB-INF/view/updateForm.jsp";
			
		}else if(request.getMethod().equalsIgnoreCase("post")) {

			String sNo = request.getParameter("no");
			int no = Integer.parseInt(sNo);
			String name = request.getParameter("name");
			String content = request.getParameter("content");
			String sDate = request.getParameter("startDate");
			String eDate = request.getParameter("endDate");
			String state = request.getParameter("state");
			
			SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = d.parse(sDate);
			Date endDate = d.parse(eDate);
			
			
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			SpmsDAO dao = SpmsDAOImpl.getInstance(sqlSession);
			Spms spms = new Spms(no, name, content, startDate, endDate, state);
			dao.update(spms);
			

			sqlSession.commit();
			sqlSession.close();
			
			response.sendRedirect(request.getContextPath() + "/list.do");
			return null;
		}
		
		return null;
	}

}
