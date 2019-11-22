package com.khrd.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.khrd.dto.Spms;

public class SpmsDAOImpl implements SpmsDAO {
	private static final SpmsDAOImpl dao = new SpmsDAOImpl();
	private SqlSession sqlSession = null;
	private static final String namespace = "mappers.spmsMapper";
	private SpmsDAOImpl() {}
	
	public static SpmsDAO getInstance(SqlSession sqlSession) {
		dao.sqlSession = sqlSession;
		return dao;
	}
		
	@Override
	public List<Spms> selectList() {
		return sqlSession.selectList(namespace + ".selectList");
	}

	@Override
	public Spms selectByNo(int no) {
		return sqlSession.selectOne(namespace + ".selectByNo", no);
	}

	@Override
	public void insert(Spms spms) {
		sqlSession.insert(namespace + ".insert", spms);
	}

	@Override
	public void delete(int no) {
		sqlSession.delete(namespace + ".delete", no);
	}

	@Override
	public void update(Spms spms) {
		sqlSession.update(namespace + ".update", spms);
	}
}
