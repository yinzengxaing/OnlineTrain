package com.ssm.train.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;

/**
 * 实现文件上传的service 
 * @author Hp
 *
 */

public interface UploadService {

	public void insertVideoFile(InputObject inputObject, OutputObject outputObject, CommonsMultipartFile files) throws Exception;
}
