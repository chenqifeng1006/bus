package com.cc.bus.dao;

import java.util.List;

import com.cc.admin.dto.Admin;
import com.cc.bus.dto.Bus;
import com.utils.common.JPage;

public interface BusMapper {
	
	List<Bus> queryList(JPage page);
	
	List<Bus> queryNoLineList(JPage page);
	
	List<Bus> queryNoDriverList(JPage page);
	
	int count();
	
	int noDriverCount();
	
	int noLineCount();

	void update(Bus bus);
	
	int add(Bus bus);
	
	void delete(Bus bus);
	
	Bus getById(Bus bus);
	
	int countByLineId(Bus bus);
	
	void removeDriver(int driverId);
	
	void removeLine(int lineId);
	
}