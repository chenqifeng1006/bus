package com.cc.driver.dao;

import java.util.List;

import com.cc.bus.dto.Bus;
import com.cc.driver.dto.Driver;
import com.utils.common.JPage;

public interface DriverMapper {
	
	Driver getByLoginId(String loginId);
	
	List<Driver> queryList(JPage page);
	
	int count();
	
	void updateInfo(Driver driver);
	
	void updatePassword(Driver driver);
	
	void update(Driver driver);
	
	int add(Driver driver);
	
	void delete(Driver driver);
	
	Driver getById(Driver driver);
	
	void removeBus(int busId);
}