package com.ssm.train.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;
import com.ssm.train.service.UserService;

@Controller
public class UserController {

	@Resource
	private UserService userService;
	

	@RequestMapping( "/post/UserController/queryUserList")
	@ResponseBody
	public void queryUserById(InputObject inputObject,OutputObject outputObject) throws Exception {
		userService.queryUserById(inputObject, outputObject);
	}
	
	
}
