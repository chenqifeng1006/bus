package com.cc.message.dao;

import java.util.List;

import com.cc.line.dto.Line;
import com.cc.message.dto.Message;
import com.utils.common.JPage;

public interface MessageMapper {
	
	
	List<Message> queryList(JPage page);
	
	int count();
	
	int add(Message message);
	
	void delete(Message message);
	
	Message getById(Message message);
}