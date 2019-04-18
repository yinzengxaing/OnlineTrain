package com.ssm.train.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;
import com.ssm.train.service.LoginService;
import com.ssm.train.service.UserService;

@Controller
public class LoginController {

	@Resource
	private LoginService loginService;
	

	@RequestMapping( "/post/LoginController/loginByUserid")
	@ResponseBody
	//登陆系统
	public void loginByUserid(InputObject inputObject,OutputObject outputObject) throws Exception {
		//System.out.println("........................");
		loginService.loginByUserid(inputObject, outputObject);
		//userService.queryUserById(inputObject, outputObject);
	}
}
