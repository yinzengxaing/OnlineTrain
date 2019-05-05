package com.ssm.train.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;
import com.ssm.train.service.CourseManageService;
import com.ssm.train.service.UserService;

@Controller
public class CourseManageController {

	@Resource
	private CourseManageService courseManageService;
	
	//查找所有课程信息
	@RequestMapping( "/post/CourseManageController/selectAllCourseInfo")
	@ResponseBody
	public void selectAllCourseInfo(InputObject inputObject,OutputObject outputObject) throws Exception {
		courseManageService.selectAllCourseInfo(inputObject, outputObject);
	}
	
	//查找未完成课程
		@RequestMapping( "/post/CourseManageController/selectUnfinishCourse")
		@ResponseBody
		public void selectUnfinishCourse(InputObject inputObject,OutputObject outputObject) throws Exception {
			courseManageService.selectUnfinishCourse(inputObject, outputObject);
		}
	
	
}
