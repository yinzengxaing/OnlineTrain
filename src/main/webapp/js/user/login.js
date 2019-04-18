var oError = $("#error_box")
$(function(e){
	eventInit();
});

/*function dataInit(){
	AjaxPostUtil.request({url:path+"/post/wechatAdminLoginController/selectSession",params:{},type:'json',callback:function(jsonSession){		
		if(jsonSession.returnCode==0){
			if(!isNull(jsonSession.bean)){
				location.href = 'pcsuccess.html';
			}
		}else{
			
		}
	}});
}*/

function eventInit(){
	
	 oError.innerHTML = "";
	 $('body').on('click', '#login', function(e){
		 location.href = "index.html";
//		 var params = {
//					user:$("#username").val(),
//					password:$("#password").val()
//			};
//		AjaxPostUtil.request({url:path+"/post/LoginController/loginByUserid",params:params,type:'json',callback:function(jsonSession){
//			location.href = "index.html";
//			alert(params.user);
//			alert(jsonSession.returnCode);
//			if($("#username").val().length > 20 || $("#username").val().length < 6) {
//				??oError.innerHTML = "用户名请输入6-20位字符";
//				?}
//				?
//			else if ($("#password").val().length > 20 || $("#password").val().length < 6) {
//				??oError.innerHTML = "密码请输入6-20位字符"
//				?}
//			else if(isNull(jsonSession.bean)){
//				alet(nul);
//				oError.innerHTML = "此账号不存在请重新输入";
//			}
//			else if(jsonSession.returnCode==0){
//				alert(zxr);
//					location.href = 'index.html';
//			}else{
//					oError.innerHTML = "密码错误，请重新输入!";
//			}
//		}});
	 });
	 
	$('body').on('click', '#register', function(e){
		
		location.href = "regist.html";
	});
}






