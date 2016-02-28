package com.cc.admin.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.admin.dto.User;
import com.cc.admin.service.UserService;
import com.cc.base.BaseController;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;



@Controller
@RequestMapping("admin")
public class UserController extends BaseController {
	

	@Autowired
	private UserService userService;
	

	/**
	 * ��¼
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public JsonObject login( User user,HttpServletRequest request,HttpServletResponse response) throws Exception {

		String loginId = user.getLoginId();
		String password = user.getPassword();
		
		User loginUser = userService.getByLoginId(loginId);
		if(loginUser==null){
			throw new Exception("�û������������");
		}else{
			if(!password.equals(loginUser.getPassword())){
				throw new Exception("�û������������");

			}
			
		}		
		return new JsonData(user);

	}
	
	/**
	 * ע�� 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/regist")
	@ResponseBody
	public JsonObject regist( User user) throws Exception {

		User existUser=this.userService.getByLoginId(user.getLoginId());
		if(existUser!=null){
			throw new Exception("������ע�ᣬ����������");
		}
		try{
		 
            this.userService.insert(user);
		 
		  
		}catch(Exception ex){
			throw new Exception("ע��ʧ�ܣ�����ϵϵͳ����Ա");
		}
		return new JsonData(user);
	}
	
	
	/**
	 * ��������
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/forgetPassword")
	@ResponseBody
	public JsonSuccess forgetPassword( User user) throws Exception {

		User existUser=this.userService.getByLoginId(user.getLoginId());
		if(existUser==null){
			throw new Exception("�û�������");
		}
        else{
			this.userService.fogetPassword(existUser);
		}
		
		return new JsonSuccess("�ѽ������뷢���������䣬���¼�������");
	}
	
	
	/**
	 * �޸��û���Ϣ ��  �޸�����
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public JsonSuccess update( User user) throws Exception {

		
			this.userService.update(user);
		
		return new JsonSuccess("�޸ĳɹ�");
	}
}