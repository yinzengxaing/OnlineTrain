package com.ssm.train.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;
import com.ssm.train.service.UserManageService;
import com.ssm.train.service.UserService;


@Controller
public class UsersManageController {

	@Resource
	private UserManageService userManageService;
	

	@RequestMapping( "/post/UserManageController/selectAllUser")
	@ResponseBody
	//查找所有职员信息
	public void selectAllUser(InputObject inputObject,OutputObject outputObject) throws Exception {
		userManageService.selectAllUser(inputObject, outputObject);
	}
	@RequestMapping( "/post/UserManageController/selectAllAdministrator")
	@ResponseBody
	//查找所有管理员信息
	public void selectAllAdministrator(InputObject inputObject,OutputObject outputObject) throws Exception {
		userManageService.selectAllAdministrator(inputObject, outputObject);
	}
	@RequestMapping( "/post/UserManageController/insertAllUser")
	@ResponseBody
	//批量添加职员
	public void insertAllUser(InputObject inputObject,OutputObject outputObject) throws Exception {
		userManageService.insertAllUser(inputObject, outputObject);
	}
	@RequestMapping( "/post/UserManageController/insertAdministrator")
	@ResponseBody
	//添加管理员
	public void insertAdministrator(InputObject inputObject,OutputObject outputObject) throws Exception {
		userManageService.insertAdministrator(inputObject, outputObject);
	}
	@RequestMapping( "/post/UserManageController/updateUserInfo")
	@ResponseBody
	//修改用户信息
	public void updateUserInfo(InputObject inputObject,OutputObject outputObject) throws Exception {
		userManageService.updateUserInfo(inputObject, outputObject);
	}
	@RequestMapping( "/post/UserManageController/selectUserStart")
	@ResponseBody
	//查询用户账号起始值
	public void selectUserStart(InputObject inputObject,OutputObject outputObject) throws Exception {
		userManageService.selectUserStart(inputObject, outputObject);
	}
	
	
}
