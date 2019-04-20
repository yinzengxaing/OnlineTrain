package com.ssm.train.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;
import com.ssm.train.dao.LoginMapper;
import com.ssm.train.dao.UserMapper;
import com.ssm.train.service.LoginService;
import com.ssm.train.service.UserService;
import com.ssm.train.util.JudgeUtil;
import com.ssm.train.util.ToolUtil;


@Service
public class LoginServiceImpl implements LoginService {

	@Resource
	private LoginMapper loginmapper;
	@Override
	public void loginByUserid(InputObject inputObject, OutputObject outputObject) throws Exception {
//		Map<String,Object> user = usermapper.selectUser();
//		outputObject.setBean(user);
//		System.out.println(user);
		Map<String,Object> map = inputObject.getParams();
		//将密码加密后，与数据库有加密密码进行对比
		//map.put("password", ToolUtil.MD5(map.get("password").toString()));
		if(JudgeUtil.isNull(map.get("user").toString())){
			outputObject.setreturnMessage("用户名不能为空");
			return;
		}
		else if(JudgeUtil.isNull(map.get("password").toString())){
			outputObject.setreturnMessage("密码不能为空");
			return;
		}
		Map<String,Object> user = loginmapper.selectUser(map);
		if(user == null){
			outputObject.setreturnMessage("该用户不存在");
			return;
		}
		else{
			if(!map.get("password").toString().equals(user.get("password").toString())){
				outputObject.setreturnMessage("密码错误，请重新输入");
				outputObject.setBean(user);
				return;
			}
		}
		
	}

}
