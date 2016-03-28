package com.cc.line.dao;

import java.util.List;

import com.cc.driver.dto.Driver;
import com.cc.line.dto.Line;
import com.utils.common.JPage;

public interface LineMapper {
	
	
	List<Line> queryList(JPage page);
	
	int count();
	
	void update(Line line);
	
	int add(Line line);
	
	void delete(Line line);
	
	Line getById(Line line);
}