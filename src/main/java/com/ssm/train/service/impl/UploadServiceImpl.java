package com.ssm.train.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;
import com.ssm.train.dao.UploadMapper;
import com.ssm.train.service.UploadService;
import com.ssm.util.UploadUtil;
@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	private UploadMapper uploadMapper;
	
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


}
