package com.ssm.train.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;
import com.ssm.train.dao.LoginMapper;
import com.ssm.train.service.LoginService;
import com.ssm.train.util.JudgeUtil;
import com.ssm.train.util.ToolUtil;


@Service
public class LoginServiceImpl implements LoginService {

	@Resource
	private LoginMapper loginmapper;
	@Override
	public void loginByUserid(InputObject inputObject, OutputObject outputObject) throws Exception {
		//判断当前用户是否已经登录
		Map<String,Object> map = inputObject.getParams();
		//将密码加密后，与数据库有加密密码进行对比
		map.put("password", ToolUtil.MD5(map.get("password").toString()));
		
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
				return;
			}else{
				outputObject.setBean(user);
				/*System.out.println("将用户放入session 中"+user);*/
				outputObject.setLogParams(user);
			}
		}
		
		
		
	}
	/**
	 * 获取登录信息
	 */
	@Override
	public void selectSession(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> map = inputObject.getLogParams();
		if(map==null){
			outputObject.setreturnMessage("Session为空,获取信息失败...");
		}else{
			outputObject.setBean(map);
		}
	}
	
	/**
	 * 清空session
	 */
	@SuppressWarnings("static-access")
	@Override 
	public void clearSession(InputObject inputObject, OutputObject outputObject) throws Exception {
		outputObject.getRequest().getSession().invalidate();
	}

}
