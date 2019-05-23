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
		
		//发布课程 
		@RequestMapping( "/post/CourseManageController/publishCourse")
		@ResponseBody
		public void publishCourse(InputObject inputObject,OutputObject outputObject) throws Exception {
			courseManageService.publishCourse(inputObject, outputObject);
		}
				
		//取消发布课程
		@RequestMapping( "/post/CourseManageController/cancelPublishCourse")
		@ResponseBody
		public void cancelPublishCourse(InputObject inputObject,OutputObject outputObject) throws Exception {
			courseManageService.cancelPublishCourse(inputObject, outputObject);
		}
		
		//更新课程视频播放进度
		@RequestMapping( "/post/CourseManageController/updateVideoTime")
		@ResponseBody
		public void updateVideoTime(InputObject inputObject,OutputObject outputObject) throws Exception {
			courseManageService.updateVideoTime(inputObject, outputObject);
		}
		
		//查询培训
		@RequestMapping( "/post/CourseManageController/selectTrain")
		@ResponseBody
		public void selectTrain(InputObject inputObject,OutputObject outputObject) throws Exception {
			courseManageService.selectTrain(inputObject, outputObject);
		}
		
		//查询考试基本信息
		@RequestMapping( "/post/CourseManageController/selectCourseForTest")
		@ResponseBody
		public void selectCourseForTest(InputObject inputObject,OutputObject outputObject) throws Exception {
			courseManageService.selectCourseForTest(inputObject, outputObject);
		}
		
		//获取试卷
		@RequestMapping( "/post/CourseManageController/selectTestList")
		@ResponseBody
		public void selectTestList(InputObject inputObject,OutputObject outputObject) throws Exception {
			courseManageService.selectTestList(inputObject, outputObject);
		}
		
		//提交试卷
		@RequestMapping( "/post/CourseManageController/submitTest")
		@ResponseBody
		public void submitTest(InputObject inputObject,OutputObject outputObject) throws Exception {
			courseManageService.submitTest(inputObject, outputObject);
		}
	
	
}
