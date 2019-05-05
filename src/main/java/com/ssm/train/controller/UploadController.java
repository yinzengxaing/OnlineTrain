package com.ssm.train.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;
import com.ssm.train.service.UploadService;
/**
 * 文件上传的controller
 * @author Hp
 *
 */
@Controller
public class UploadController {
	@Resource
	private UploadService uploadService;
	
	/**
	 * 上传视频
	 * 
	 */
	
	@RequestMapping("/post/UploadController/insertVideoFile")
	@ResponseBody
	public void insertImgFile(InputObject inputObject,OutputObject outputObject,@RequestParam("videoFiles") CommonsMultipartFile files) throws Exception {
		uploadService.insertVideoFile(inputObject, outputObject, files);
	}
	
	/**
	 * 设置视频对应id
	 * 
	 */
	
	@RequestMapping("/post/UploadController/updateVideoCourseId")
	@ResponseBody
	public void updateVideoCourseId(InputObject inputObject,OutputObject outputObject) throws Exception {
		uploadService.updateVideoCourseId(inputObject, outputObject);
	}
	
	/**
	 * 修改课程信息
	 * 
	 */
	
	@RequestMapping("/post/UploadController/updateCourseInfo")
	@ResponseBody
	public void updateCourseInfo(InputObject inputObject,OutputObject outputObject) throws Exception {
		uploadService.updateCourseInfo(inputObject, outputObject);
	}
	
	/**
	 * 插入课程信息
	 * 
	 */
	
	@RequestMapping("/post/UploadController/insertCourse")
	@ResponseBody
	public void insertCourse(InputObject inputObject,OutputObject outputObject) throws Exception {
		uploadService.insertCourse (inputObject, outputObject);
	}
	
	/**
	 * 按id查询课程信息
	 * 
	 */
	
	@RequestMapping("/post/UploadController/selectCourseInfo")
	@ResponseBody
	public void selectCourseInfo(InputObject inputObject,OutputObject outputObject) throws Exception {
		uploadService.selectCourseInfo (inputObject, outputObject);
	}
	
	/**
	 * 插入试卷
	 * 
	 */
	
	@RequestMapping("/post/UploadController/insertExam")
	@ResponseBody
	public void insertExam(InputObject inputObject,OutputObject outputObject) throws Exception {
		uploadService.insertExam (inputObject, outputObject);
	}
	

	/**
	 * 删除课程
	 * 
	 */
	
	@RequestMapping("/post/UploadController/deleteCourse")
	@ResponseBody
	public void deleteCourse(InputObject inputObject,OutputObject outputObject) throws Exception {
		uploadService.deleteCourse(inputObject, outputObject);
	}
	

	/**
	 * 删除试题
	 * 
	 */
	
	@RequestMapping("/post/UploadController/deleteVideo")
	@ResponseBody
	public void deleteVideo(InputObject inputObject,OutputObject outputObject) throws Exception {
		uploadService.deleteVideo(inputObject, outputObject);
	}
	
	/**
	 * 添加试题
	 * 
	 */
	
	@RequestMapping("/post/UploadController/insertTest")
	@ResponseBody
	public void insertTest(InputObject inputObject,OutputObject outputObject) throws Exception {
		uploadService.insertTest(inputObject, outputObject);
	}
	
	/**
	 * 按id查找考试信息
	 * 
	 */
	
	@RequestMapping("/post/UploadController/selectExamById")
	@ResponseBody
	public void selectExamById(InputObject inputObject,OutputObject outputObject) throws Exception {
		uploadService.selectExamById(inputObject, outputObject);
	}
	
	/**
	 * 按id查找试题信息
	 * 
	 */
	
	@RequestMapping("/post/UploadController/selectTestById")
	@ResponseBody
	public void selectTestById(InputObject inputObject,OutputObject outputObject) throws Exception {
		uploadService.selectTestById(inputObject, outputObject);
	}
	
	/**
	 * 修改试题信息
	 * 
	 */
	
	@RequestMapping("/post/UploadController/updateTest")
	@ResponseBody
	public void updateTest(InputObject inputObject,OutputObject outputObject) throws Exception {
		uploadService.updateTest(inputObject, outputObject);
	}
	
	/**
	 * 按examid删除试题
	 * 
	 */
	
	@RequestMapping("/post/UploadController/deleteTestByExamid")
	@ResponseBody
	public void deleteTestByExamid(InputObject inputObject,OutputObject outputObject) throws Exception {
		uploadService.deleteTestByExamid(inputObject, outputObject);
	}
	
	/**
	 * 修改试题信息
	 * 
	 */
	
	@RequestMapping("/post/UploadController/updateExam")
	@ResponseBody
	public void updateExam(InputObject inputObject,OutputObject outputObject) throws Exception {
		uploadService.updateExam(inputObject, outputObject);
	}
	
	/**
	 * 修改试题信息
	 * 
	 */
	
	@RequestMapping("/post/UploadController/deleteExam")
	@ResponseBody
	public void deleteExam(InputObject inputObject,OutputObject outputObject) throws Exception {
		uploadService.deleteExam(inputObject, outputObject);
	}
	
	/**
	 * 修改试题信息
	 * 
	 */
	
	@RequestMapping("/post/UploadController/insertTrain")
	@ResponseBody
	public void insertTrain(InputObject inputObject,OutputObject outputObject) throws Exception {
		uploadService.insertTrain(inputObject, outputObject);
	}
	
	
	
	
	
	
	
	
}
