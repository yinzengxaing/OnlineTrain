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
	@RequestMapping( "/post/UserManageController/deleteUserById")
	@ResponseBody
	//删除账号
	public void deleteUserById(InputObject inputObject,OutputObject outputObject) throws Exception {
		userManageService.deleteUserById(inputObject, outputObject);
	}
	
	@RequestMapping( "/post/UserManageController/selectUserByName")
	@ResponseBody
	//按用户名查找职员
	public void selectUserByName(InputObject inputObject,OutputObject outputObject) throws Exception {
		userManageService.selectUserByName(inputObject, outputObject);
	}
	
	@RequestMapping( "/post/UserManageController/selectAdministratorByName")
	@ResponseBody
	//按用户名查找管理员
	public void selectAdministratorByName(InputObject inputObject,OutputObject outputObject) throws Exception {
		userManageService.selectAdministratorByName(inputObject, outputObject);
	}
	
	@RequestMapping( "/post/UserManageController/updateUserToAdministrator")
	@ResponseBody
	//设为管理员
	public void updateUserToAdministrator(InputObject inputObject,OutputObject outputObject) throws Exception {
		userManageService.updateUserToAdministrator(inputObject, outputObject);
	}
	
	@RequestMapping( "/post/UserManageController/selectUserById")
	@ResponseBody
	//按id查询用户
	public void selectUserById(InputObject inputObject,OutputObject outputObject) throws Exception {
		userManageService.selectUserById(inputObject, outputObject);
	}
	
	@RequestMapping( "/post/UserManageController/updatePassword")
	@ResponseBody
	//修改密码
	public void updatePassword(InputObject inputObject,OutputObject outputObject) throws Exception {
		userManageService.updatePassword(inputObject, outputObject);
	}
	
	
	
	
	
	
	
	
}
