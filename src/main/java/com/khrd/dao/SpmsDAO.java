package com.khrd.dao;

import java.util.List;

import com.khrd.dto.Spms;

public interface SpmsDAO {
	public List<Spms> selectList();
	public Spms selectByNo(int no);
	public void insert(Spms spms);
	public void delete(int no);
	public void update(Spms spms);
}
