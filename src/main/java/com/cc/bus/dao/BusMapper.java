package com.cc.bus.dao;

import java.util.List;

import com.cc.admin.dto.Admin;
import com.cc.bus.dto.Bus;
import com.utils.common.JPage;

public interface BusMapper {
	
	List<Bus> queryList(JPage page);
	
	int count();

	void update(Bus bus);
	
	int add(Bus bus);
	
	void delete(Bus bus);
	
	Bus getById(Bus bus);
}