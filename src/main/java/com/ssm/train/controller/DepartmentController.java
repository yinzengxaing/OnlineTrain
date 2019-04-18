package com.ssm.train.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;
import com.ssm.train.service.DepartmentService;
import com.ssm.train.service.UserService;

@Controller
public class DepartmentController {

	@Resource
	private DepartmentService departmentService;
	
	@RequestMapping( "/post/DepartmentController/getDepartmentList")
	@ResponseBody
	public void getDepartmentList(InputObject inputObject,OutputObject outputObject) throws Exception {
		departmentService.getDepartmentList(inputObject, outputObject);
	}
	
	@RequestMapping( "/post/DepartmentController/insertDepartment")
	@ResponseBody
	public void insertDepartment(InputObject inputObject,OutputObject outputObject) throws Exception {
		departmentService.insertDepartment(inputObject, outputObject);
	}
	@RequestMapping( "/post/DepartmentController/updateDepartment")
	@ResponseBody
	public void updateDepartment(InputObject inputObject,OutputObject outputObject) throws Exception {
		departmentService.updateDepartment(inputObject, outputObject);
	}
	
}
