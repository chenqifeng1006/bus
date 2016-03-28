package com.cc.message.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.line.dto.Line;
import com.cc.message.dao.MessageMapper;
import com.cc.message.dto.Message;
import com.utils.common.JPage;

@Service
public class MessageService {
	
	@Autowired
	private MessageMapper messageMapper;
	
	public List<Message> queryList(JPage page){
		return this.messageMapper.queryList(page);
	}
	
	public int count(){
		return this.messageMapper.count();
	}
	
	
	public int add(Message message){
		return this.messageMapper.add(message);
	}
	
	public void delete(Message message){
		this.messageMapper.delete(message);
	}
	
	public Message getById(Message message){
		return this.messageMapper.getById(message);
	}

}