package com.ssm.train.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;
import com.ssm.train.dao.UserManageMapper;
import com.ssm.train.service.UserManageService;
import com.ssm.train.util.JudgeUtil;
@Service
public class UserManageServiceImpl implements UserManageService {
    @Resource
    private UserManageMapper userManageMapper;
	@Override
	//查找所有职员信息
	public void selectAllUser(InputObject inputObject, OutputObject outputObject) throws Exception {
//		List<Map<String,Object>> beans = userManageMapper.selectAllUser();
//		outputObject.setBeans(beans);
		Map<String, Object> params = inputObject.getParams();
		//获取分页信息
		int page = Integer.parseInt(params.get("offset").toString())/Integer.parseInt(params.get("limit").toString());
		page++;
		int limit = Integer.parseInt(params.get("limit").toString());
		List<Map<String,Object>> userList = userManageMapper.selectAllUser(params, new PageBounds(page, limit));
		PageList<Map<String, Object>> abilityInfoPageList = (PageList<Map<String, Object>>) userList;
		int total = abilityInfoPageList.getPaginator().getTotalCount();
		outputObject.setBeans(userList);
		outputObject.settotal(total); 
		

	}
	//查找所有管理员信息
	@Override
	public void selectAllAdministrator(InputObject inputObject, OutputObject outputObject) throws Exception {
		List<Map<String,Object>> beans = userManageMapper.selectAllAdministrator();
		outputObject.setBeans(beans);

	}
	//批量添加职员
	@Override
	public void insertAllUser(InputObject inputObject, OutputObject outputObject) throws Exception {
			Map<String,Object> map = inputObject.getParams();
			String startUser = map.get("startUser").toString();
			String endUser = map.get("endUser").toString();
//			String startUser = "541507010100";
//			String endUser = "541507010155";
			int length = startUser.length();
			//找的user开始不同的位置
			int i=0;
			for(i=0;i<length;i++){
				if(startUser.charAt(i) != endUser.charAt(i))
					break;
			}
			String start = startUser.substring(i);
			String end = endUser.substring(i);
			String sameString = startUser.substring(0, i);
			//将其变成int数字
			int startNumber = Integer.parseInt(start);
			int endNumber = Integer.parseInt(end);
			List<Map<String,Object>> beans = new ArrayList<Map<String,Object>>();
			//依次生成从startUser开始到endUser的用户
			for(;startNumber<=endNumber;startNumber++){
				Map<String,Object> bean = new HashMap<String,Object>();
				if(startNumber<10){
					bean.put("user", sameString+"0"+String.valueOf(startNumber));
					bean.put("password", (sameString+"0"+String.valueOf(startNumber)).substring(6));
				}
				else
				{
					bean.put("user", sameString+String.valueOf(startNumber));
					bean.put("password", (sameString+String.valueOf(startNumber)).substring(6));
				}
	            beans.add(bean);
			}
			Map<String,Object> mapbean = new HashMap<String,Object>();
			mapbean.put("userstart",sameString+String.valueOf(startNumber));
			userManageMapper.updateUserStart(map);//修改用户账号起始值
			userManageMapper.insertAllUser(beans);			
			
	}
	//添加管理员
	@Override
	public void insertAdministrator(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> map = inputObject.getParams();
		map.put("password", map.get("user").toString().substring(6));
		map.put("role", 1);
		userManageMapper.insertAdministrator(map);
		
	}
	//修改用户信息
	@Override
	public void updateUserInfo(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> map = inputObject.getParams();
		if(JudgeUtil.isNull(map.get("telephonenumber").toString())){
			outputObject.setreturnMessage("手机号不能为空");
		}
		else if(!JudgeUtil.isPhoneNO(map.get("telephonenumber").toString())){
			outputObject.setreturnMessage("手机号不合法");
		}
		else if(JudgeUtil.isNull(map.get("username").toString())){
			outputObject.setreturnMessage("姓名不能为空");
		}
		else{
			userManageMapper.updateUserInfo(map);
			//outputObject.setreturnCode(1);
		}
	}
	@Override
	public void selectUserStart(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> map = userManageMapper.selectUserStart();
		outputObject.setBean(map);
	}

}
