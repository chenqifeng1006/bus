package com.cc.admin.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.admin.dto.RemindValue;
import com.cc.admin.dto.User;
import com.cc.admin.service.RemindValueService;
import com.cc.admin.service.UserService;
import com.cc.base.BaseController;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;



@Controller
@RequestMapping("remindValue")
public class RemindValueController extends BaseController {
	

	@Autowired
	private RemindValueService remindValueService;
	



	
	/**
	 * �޸��û���Ϣ ��  �޸�����
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public JsonSuccess update( RemindValue remindValue) throws Exception {

		
			this.remindValueService.update(remindValue);
		
		return new JsonSuccess("�޸ĳɹ�");
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public JsonSuccess save( RemindValue remindValue) throws Exception {

		RemindValue existValue=this.remindValueService.queryByType(remindValue.getType());
		if(existValue!=null){
			if(existValue.getType().equals("temperture")){
				throw new Exception("�¶ȵķ�ֵ�Ѿ����ڣ������ظ��½�");
			}else{
				throw new Exception("ʪ�ȵķ�ֵ�Ѿ����ڣ������ظ��½�");

			}
			
		}
		
		this.remindValueService.save(remindValue);
		
		return new JsonSuccess("�����ɹ�");
	}
	
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public JsonSuccess delete( RemindValue remindValue) throws Exception {
		
		this.remindValueService.delete(remindValue.getId());
		
		return new JsonSuccess("ɾ���ɹ�");
	}
}