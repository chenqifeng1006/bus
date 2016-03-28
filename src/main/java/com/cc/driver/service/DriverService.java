package com.cc.driver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.admin.dto.Admin;
import com.cc.bus.dto.Bus;
import com.cc.driver.dao.DriverMapper;
import com.cc.driver.dto.Driver;
import com.utils.common.JPage;

@Service
public class DriverService {
	
	@Autowired
	private DriverMapper driverMapper;
	
	public List<Driver> queryList(JPage page){
		return this.driverMapper.queryList(page);
	}
	
	public int count(){
		return this.driverMapper.count();
	}
	
	
	public Driver getByLoginId(String loginId){
		return this.driverMapper.getByLoginId(loginId);
	}
	
	public void updateInfo(Driver driver){
		this.driverMapper.updateInfo(driver);
	}
	
	public void updatePassword(Driver driver){
		this.driverMapper.updatePassword(driver);
	}
	
	public void update(Driver driver){
		this.driverMapper.update(driver);
	}
	
	public int add(Driver driver){
		return this.driverMapper.add(driver);
	}
	
	public void delete(Driver driver){
		this.driverMapper.delete(driver);
	}
	
	public Driver getById(Driver driver){
		return this.driverMapper.getById(driver);
	}
	

}