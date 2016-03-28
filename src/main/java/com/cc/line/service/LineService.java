package com.cc.line.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cc.bus.dao.BusMapper;
import com.cc.bus.dto.Bus;
import com.cc.driver.dao.DriverMapper;
import com.cc.line.dao.LineMapper;
import com.cc.line.dto.Line;
import com.utils.common.JPage;

@Service
@Transactional
public class LineService {
	
	@Autowired
	private DriverMapper driverMapper;
	@Autowired
	private BusMapper busMapper;
	@Autowired
	private LineMapper lineMapper;
	
	
	public List<Line> queryList(JPage page){
		return this.lineMapper.queryList(page);
	}
	
	public int count(){
		return this.lineMapper.count();
	}
	
	public void update(Line line){
		this.lineMapper.update(line);
	}
	
	public int add(Line line){
		return this.lineMapper.add(line);
	}
	
	public void delete(Line line){
		this.lineMapper.delete(line);
	}
	
	public Line getById(Line line){
		return this.lineMapper.getById(line);
	}

}