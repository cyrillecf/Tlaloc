package com.aistos.tlaloc.data.dao;

import java.util.List;

import com.aistos.tlaloc.data.Dto;

public interface Dao {

	public List<?> list();
	
	public boolean insert(Dto dto);
	
	public boolean update(Dto dto);
	
	public boolean delete(int i);
}
