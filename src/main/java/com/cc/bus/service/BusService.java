package com.cc.bus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.bus.dao.BusMapper;
import com.cc.bus.dto.Bus;
import com.utils.common.JPage;

@Service
public class BusService {
	
	@Autowired
	private BusMapper busMapper;
	
	public List<Bus> queryList(JPage page){
		return this.busMapper.queryList(page);
	}
	
	public int count(){
		return this.busMapper.count();
	}
	
	public void update(Bus bus){
		this.busMapper.update(bus);
	}
	
	public int add(Bus bus){
		return this.busMapper.add(bus);
	}
	
	public void delete(Bus bus){
		this.busMapper.delete(bus);
	}
	

}