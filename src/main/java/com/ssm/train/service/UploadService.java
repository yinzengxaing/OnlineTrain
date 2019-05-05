package com.ssm.train.service;

import java.util.Map;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;

/**
 * 实现文件上传的service 
 * @author Hp
 *
 */

public interface UploadService {
    //保存上传视频
	public void insertVideoFile(InputObject inputObject, OutputObject outputObject, CommonsMultipartFile files) throws Exception;
	//设置视频对应课程
	public void updateVideoCourseId(InputObject inputObject, OutputObject outputObject) throws Exception;
	//修改课程信息
	public void updateCourseInfo(InputObject inputObject, OutputObject outputObject) throws Exception;
	//插入课程信息
	public void insertCourse(InputObject inputObject, OutputObject outputObject) throws Exception;
	//按id查找课程信息
	public void selectCourseInfo(InputObject inputObject, OutputObject outputObject) throws Exception;
	//插入试卷
	public void insertExam(InputObject inputObject, OutputObject outputObject) throws Exception;
	//删除课程
	public void deleteCourse(InputObject inputObject, OutputObject outputObject) throws Exception;
	//删除视频
	public void deleteVideo(InputObject inputObject, OutputObject outputObject) throws Exception;
	//添加试题
	public void insertTest(InputObject inputObject, OutputObject outputObject) throws Exception;
	//按id查找考试信息 
	public void selectExamById(InputObject inputObject, OutputObject outputObject) throws Exception;
	//按id查找试题信息
	public void selectTestById(InputObject inputObject, OutputObject outputObject) throws Exception;
	//修改试题信息
	public void updateTest(InputObject inputObject, OutputObject outputObject) throws Exception;
	//按examid删除试题
	public void deleteTestByExamid(InputObject inputObject, OutputObject outputObject) throws Exception;
	//修改试题信息
	public void updateExam(InputObject inputObject, OutputObject outputObject) throws Exception;
	//删除试卷
	public void deleteExam(InputObject inputObject, OutputObject outputObject) throws Exception;
	//更新train
	public void insertTrain(InputObject inputObject, OutputObject outputObject) throws Exception;
	
	
}
