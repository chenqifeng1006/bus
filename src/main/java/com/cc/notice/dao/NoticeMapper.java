package com.cc.notice.dao;

import java.util.List;

import com.cc.message.dto.Message;
import com.cc.notice.dto.Notice;
import com.utils.common.JPage;

public interface NoticeMapper {
	
	
	List<Notice> queryList(JPage page);
	
	int count();
	
	int add(Notice notice);
	
	int update(Notice notice);
	
	void delete(Notice notice);
	
	Notice getById(Notice notice);
}