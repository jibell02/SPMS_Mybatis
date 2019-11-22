package com.khrd.dao;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.khrd.dto.Spms;
import com.khrd.util.MyBatisSqlSessionFactory;

public class TestDAO {
	private SqlSession sqlSession = null;
	private SpmsDAO dao = null;
	
	@Before
	public void openSqlSession() {
		sqlSession = MyBatisSqlSessionFactory.openSession();
		dao = SpmsDAOImpl.getInstance(sqlSession);
	}
	
	@After
	public void closeSqlSession() {
		sqlSession.close();
	}
	
//	@Test
	public void testInsert() {
		dao.insert(new Spms(0, "직원관리 시스템 프로젝트2", "직원관리 시스템", new Date(), new Date(), "종료"));
		sqlSession.commit();
	}
	
//	@Test
	public void testSelectList() {
		dao.selectList();
	}
	
//	@Test
	public void testSelectByNo() {
		dao.selectByNo(2);
	}
	
	@Test
	public void testDelete() {
		dao.delete(14);
		sqlSession.commit();
	}
	
//	@Test
	public void testUpdate() {
		dao.update(new Spms(9, "은행 시스템 관리 프로젝트", "은행 시스템 관리", new Date(), new Date(), "종료"));
		sqlSession.commit();
	}
}
