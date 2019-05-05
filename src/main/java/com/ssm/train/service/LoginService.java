package com.ssm.train.service;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;

public interface LoginService {
	//按userID登陆
	public void loginByUserid(InputObject inputObject, OutputObject outputObject) throws Exception;
	public void selectSession(InputObject inputObject, OutputObject outputObject) throws Exception;
	public void clearSession(InputObject inputObject, OutputObject outputObject) throws Exception;
}
