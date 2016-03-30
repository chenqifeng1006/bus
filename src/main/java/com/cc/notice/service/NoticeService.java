package com.cc.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.message.dto.Message;
import com.cc.notice.dao.NoticeMapper;
import com.cc.notice.dto.Notice;
import com.utils.common.JPage;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	public List<Notice> queryList(JPage page){
		return this.noticeMapper.queryList(page);
	}
	
	public int count(){
		return this.noticeMapper.count();
	}
	
	
	public int add(Notice notice){
		return this.noticeMapper.add(notice);
	}
	
	public int update(Notice notice){
		return this.noticeMapper.update(notice);
	}
	
	public void delete(Notice notice){
		this.noticeMapper.delete(notice);
	}
	
	public Notice getById(Notice notice){
		return this.noticeMapper.getById(notice);
	}
	

}