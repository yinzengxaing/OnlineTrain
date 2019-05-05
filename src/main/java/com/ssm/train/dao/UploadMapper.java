package com.ssm.train.dao;

import java.util.Map;

public interface UploadMapper {
	//保存上传视频
	public void insertVideo(Map<String,Object> map) throws Exception;
	//设置视频对应课程
	public void updateVideoCourseId(Map<String,Object> map) throws Exception;
	//修改课程信息
	public void updateCourseInfo(Map<String,Object> map) throws Exception;
	//插入课程信息
	public void insertCourse(Map<String,Object> map) throws Exception;
	//按id查找课程信息
	public Map<String,Object> selectCourseInfo(Map<String,Object> map) throws Exception;
	//插入试卷
	public void insertExam(Map<String,Object> map) throws Exception;
	//删除课程
	public void deleteCourse(Map<String,Object> map) throws Exception;
	//删除视频
	public void deleteVideo(Map<String,Object> map) throws Exception;
	//添加试题
	public void insertTest(Map<String,Object> map) throws Exception;
	//按id查找考试信息
	public Map<String,Object> selectExamById(Map<String,Object> map) throws Exception;
	//按id查找试题信息
	public Map<String,Object> selectTestById(Map<String,Object> map) throws Exception;
	//修改试题信息
	public void updateTest(Map<String,Object> map) throws Exception;
	//按examid删除试题
	public void deleteTestByExamid(Map<String,Object> map) throws Exception;
	//修改试题信息
	public void updateExam(Map<String,Object> map) throws Exception;
	//删除试卷
	public void deleteExam(Map<String,Object> map) throws Exception;
	//更新train
	public void insertTrain(Map<String,Object> map) throws Exception;
	
}
