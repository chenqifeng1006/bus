package com.cc.record.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.notice.dto.Notice;
import com.cc.record.dao.RecordMapper;
import com.cc.record.dto.Record;
import com.utils.common.JPage;

@Service
public class RecordService {
	
	@Autowired
	private RecordMapper recordMapper;
	
	public List<Record> queryList(JPage page){
		return this.recordMapper.queryList(page);
	}
	
	public int count(){
		return this.recordMapper.count();
	}
	
	
	public void update(Record record){
		this.recordMapper.update(record);
	}
	
	
	
	public int add(Record record){
		return this.recordMapper.add(record);
	}
	
	public void delete(Record record){
		this.recordMapper.delete(record);
	}
	
	public Record getById(Record record){
		return this.recordMapper.getById(record);
	}
	
}