package com.cc.record.dao;

import java.util.List;

import com.cc.notice.dto.Notice;
import com.cc.record.dto.Record;
import com.utils.common.JPage;

public interface RecordMapper {

	
	List<Record> queryList(JPage page);
	
	int count();
	
	void update(Record record);
	
	int add(Record record);
	
	void delete(Record record);
	
	Record getById(Record record);
	
}
