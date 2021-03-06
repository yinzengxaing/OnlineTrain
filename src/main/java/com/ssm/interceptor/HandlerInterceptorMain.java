package com.ssm.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.util.CustomException;
import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;
import com.ssm.object.PutObject;
import com.ssm.train.util.Constants;
import com.ssm.train.util.JudgeUtil;


public class HandlerInterceptorMain implements HandlerInterceptor{
	
	private static final String[] URL = {"/OnlineTrain/post/LoginController/loginByUserid"};
	
	private static final String[] OTHER_MAIN_URL = {""};

	//在进入Handler方法之前执行  
	//用于身份认证、身份授权、  
	//比如身份认证，如果认证不通过表示当前用户没有登录，需要此方法拦截不再向下执行
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	new PutObject(request,response);
    	//boolean passNo = false;
    	HttpServletRequest servletRequest = (HttpServletRequest) request;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String url = servletRequest.getContextPath() + servletRequest.getServletPath();
		Map<String,Object> user = InputObject.getLogInParams();
/*		System.out.println(user);
		System.out.println(url);*/
		
		if (user == null && !JudgeUtil.contains(URL,url)) {
			//throw new CustomException("错误提示:您还未登录,请先登录<br/>错误类型:Session为空");
			return true;
		}
		if(user == null){
			if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
	        	//如果是ajax请求响应头会有x-requested-with
				System.out.println("ajax请求被执行了");
	    		return true;
	        }else{
	        	System.out.println("非ajax请求被执行了");
	        	return true;
	        }
		}else{
/*			List<Map<String,Object>> beans = InputObject.getLogPermissionInParams();
			if(beans.isEmpty()||beans==null){
				throw new CustomException("错误提示:该角色不具备权限或角色未上线<br/>"+url+"错误类型:权限错误");
			}
			for (Map<String,Object> bean : beans) {
				if( url.equals("/wechatpro/"+bean.get("url").toString()) && bean != null ){
					passNo =  true;
					break;
				}
			}
			if(JudgeUtil.contains(OTHER_MAIN_URL, url)){
				passNo =  true;
			}
			if(passNo){
				if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
		        	//如果是ajax请求响应头会有x-requested-with
		    		return true;
		        }else{
		            //非ajax请求时
		        	return true;
		        }
			}else{
				throw new CustomException("错误提示:您不具备该权限<br/>"+url+"错误类型:权限错误");
			}*/
			return true;
		}
    }

    //进入Handler方法之后，在返回ModelAndView之前执行  
    //应用场景从modelAndView对象出发：将公用的模型数据(比如菜单的导航)在这里传到视图，也可以在这里面来统一指定视图
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
        	//如果是ajax请求响应头会有x-requested-with
        	if(OutputObject.getCode()==Constants.WRONG){
        		OutputObject.setCode(0);
        		if(OutputObject.getMessage().equals(Constants.WRONG_MESSAGE)){
        			OutputObject.setMessage("成功");
        		}else{
        			OutputObject.setCode(Constants.WRONG);
        		}
        	}
        	OutputObject.put();
        	PutObject.removeRequest();
        }else{
        	//非ajax请求时
        	if(OutputObject.getCode()==Constants.WRONG){
        		OutputObject.setCode(0);
        		if(OutputObject.getMessage().equals(Constants.WRONG_MESSAGE)){
        			OutputObject.setMessage("成功");
        		}else{
        			OutputObject.setCode(Constants.WRONG);
        		}
        	}
        	OutputObject.put();
        	PutObject.removeRequest();
        }
    }

    //执行Handler完成后执行此方法  
  	//应用场景：统一的异常处理，统一的日志处理  
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}

