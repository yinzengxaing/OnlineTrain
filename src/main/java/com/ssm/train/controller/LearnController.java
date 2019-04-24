package com.ssm.train.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;
import com.ssm.train.service.LearnService;
import com.ssm.train.service.UploadService;
/**
 * 文件上传的controller
 * @author Hp
 *
 */
@Controller
public class LearnController {
	@Resource
	private LearnService learnService;
	
	/**
	 * 获取播放列表
	 * 
	 */
	
	@RequestMapping("/post/LearnController/findAll")
	@ResponseBody
	public void findAll(InputObject inputObject,OutputObject outputObject) throws Exception {
		learnService.findAll(inputObject, outputObject);
	}
}
