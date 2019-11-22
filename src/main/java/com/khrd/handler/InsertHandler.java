package com.khrd.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.SpmsDAO;
import com.khrd.dao.SpmsDAOImpl;
import com.khrd.dto.Spms;
import com.khrd.util.MyBatisSqlSessionFactory;

public class InsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		if(request.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/insertForm.jsp";
		}else if(request.getMethod().equalsIgnoreCase("post")){
			request.setCharacterEncoding("utf-8");
			
			String name = request.getParameter("name");
			String content = request.getParameter("content");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String state = request.getParameter("state");
			
			SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
			Date sDate = d.parse(startDate);
			Date eDate = d.parse(endDate);
			
			
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			SpmsDAO dao = SpmsDAOImpl.getInstance(sqlSession);
			Spms spms = new Spms(0, name, content, sDate, eDate, state);
			dao.insert(spms);
				
			HttpSession session = request.getSession();
			String no = (String) session.getAttribute("Auth"); 

			sqlSession.commit();
			sqlSession.close();
			
			response.sendRedirect(request.getContextPath() + "/list.do");
			return null;
		}
		return null;
	}

}
