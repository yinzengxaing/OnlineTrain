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
}
