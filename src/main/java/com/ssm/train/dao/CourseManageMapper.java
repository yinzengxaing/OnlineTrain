package com.ssm.train.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;


public interface CourseManageMapper {
	//查找所有课程信息
	public List<Map<String, Object>> selectAllCourseInfo(Map<String, Object> map , PageBounds bounds) throws Exception;
	//查找未完成课程
	public List<Map<String, Object>> selectUnfinishCourse(Map<String, Object> map , PageBounds bounds) throws Exception;
	//发布课程 
	public void publishCourse(Map<String, Object> map) throws Exception;
	//绑定培训关系 
	public void insertTrain(Map<String, Object> map) throws Exception;
	//取消发布课程 
	public void cancelPublishCourse(Map<String, Object> map) throws Exception;
	//取消培训关系 
	public void deleteTrain(Map<String, Object> map) throws Exception;
	//更新课程视频播放进度
	public void updateVideoTime(Map<String, Object> map) throws Exception;
	//查询培训
	public Map<String, Object> selectTrain(Map<String,Object> map) throws Exception;
	//查询考试基本信息
	public Map<String, Object> selectCourseForTest(Map<String,Object> map) throws Exception;
	//获取试卷
	public List<Map<String, Object>> selectTestList(Map<String, Object> map) throws Exception;
	//更新考试成绩
	public void updateGrade(Map<String, Object> map) throws Exception;
}
