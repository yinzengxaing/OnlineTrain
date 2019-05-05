package com.ssm.train.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;
import com.ssm.train.dao.UploadMapper;
import com.ssm.train.service.UploadService;
import com.ssm.train.util.ToolUtil;
import com.ssm.util.UploadUtil;
@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	private UploadMapper uploadMapper;
	//保存视频
	@Override
	public void insertVideoFile(InputObject inputObject, OutputObject outputObject, CommonsMultipartFile files)
			throws Exception {

		Map<String,Object> map = UploadUtil.vedioUpload(inputObject, outputObject, files);
		//将上传的信息存入数据库中
		uploadMapper.insertVideo(map);
		if(map!=null){
			outputObject.setBean(map);
		}else{
			outputObject.setreturnMessage("文件类型不正确");
		}
		
		
	}
    //设置视频对应id
	@Override
	public void updateVideoCourseId(InputObject inputObject, OutputObject outputObject)throws Exception {
		Map<String,Object> params = inputObject.getParams();
	    uploadMapper.updateVideoCourseId(params);
		
	}
    //修改课程信息
	@Override
	public void updateCourseInfo(InputObject inputObject, OutputObject outputObject)throws Exception {
		Map<String,Object> params = inputObject.getParams();
		uploadMapper.updateCourseInfo(params);
	}
    //插入课程信息
	@Override
	public void insertCourse(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		params.put("cstart", ToolUtil.getTimeAndToString().substring(0, 10));
		uploadMapper.insertCourse(params);
		outputObject.setBean(params);
	}
	//按id查询课程信息
	@Override
	public void selectCourseInfo(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		Map<String,Object> bean = uploadMapper.selectCourseInfo(params);
		outputObject.setBean(bean);	
	}
	
	//插入试卷
	@Override
	public void insertExam(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		uploadMapper.insertExam(params);
		outputObject.setBean(params);
	}
	
	//删除课程
	@Override
	public void deleteCourse(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		uploadMapper.deleteCourse(params);
	}
	
	//删除课程
	@Override
	public void deleteVideo(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		uploadMapper.deleteVideo(params);
	}
	
	//添加试题
	@Override
	public void insertTest(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		uploadMapper.insertTest(params);
		outputObject.setBean(params);
		
	}
	
	//按id查找考试信息 
	@Override
	public void selectExamById(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		Map<String,Object> bean = uploadMapper.selectExamById(params);
		outputObject.setBean(bean);
		
	}
	//按id查找试题信息
	@Override
	public void selectTestById(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		Map<String,Object> bean = uploadMapper.selectTestById(params);
		outputObject.setBean(bean);
		
		
	}
	//修改试题信息
	@Override
	public void updateTest(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		uploadMapper.updateTest(params);
	}
	
	//按examid删除试题
	@Override
	public void deleteTestByExamid(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		uploadMapper.deleteTestByExamid(params);
	}
	
	//修改试题信息
	@Override
	public void updateExam(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		uploadMapper.updateExam(params);
		
	}
	//删除试卷
	@Override
	public void deleteExam(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		uploadMapper.deleteExam(params);
		
	}
	//更新train
	@Override
	public void insertTrain(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		uploadMapper.insertTrain(params);
	}
	
	


}
