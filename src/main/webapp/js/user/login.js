var id = "";
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
	$('#loginForm').bootstrapValidator({
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			username: {
				message: 'The username is not valid',
				validators: {
					notEmpty: {
						message: '账户不能为空'
					},
					stringLength: {
						min: 12,
						max: 12,
						message: '账号应为12位'
					},
					regexp: {
						regexp:'^[0-9]*$',
						message: '只接受数字'
					}
				} 
			},
			password:{
				message: 'The password is not valid',
				validators: {
					notEmpty: {
						message: '密码不能为空'
					}
				}
			},
		}
	}).on('success.form.bv', function(e) {
		var params = {
				user:$("#username").val(),
				password:$("#password").val()
		};
		AjaxPostUtil.request({url:path+"/post/LoginController/loginByUserid",params:params,type:'json',callback:function(json){
			if(json.returnCode==0){
				id=json.bean.id;
				location.href = 'index.html?id='+id;
			}else{
				qiao.bs.msg({msg:json.returnMessage,type:'danger'});
			}
		}});
		return false;
	});
	
	 //oError.innerHTML = "";
//	 $('body').on('click', '#login', function(e){
//		 var params = {
//					user:$("#username").val(),
//					password:$("#password").val()
//			};
//		AjaxPostUtil.request({url:path+"/post/LoginController/loginByUserid",params:params,type:'json',callback:function(jsonSession){
//			alert(jsonSession.returnCode);
//			if($("#username").val().length > 20 || $("#username").val().length < 6) {
//				alert(1);
//				oError.innerHTML = "用户名请输入6-20位字符";
//			}
//			else if ($("#password").val().length > 20 || $("#password").val().length < 6) {
//				alert(2);
//				oError.innerHTML = "密码请输入6-20位字符"
//			}
//			else if(isNull(jsonSession.bean)){
//				oError.innerHTML = "此账号不存在请重新输入";
//			}
//			else if(jsonSession.returnCode==0){
//				alert(4);
//				location.href = 'index.html';
//			}else{
//				alert(5);
//					oError.innerHTML = "密码错误，请重新输入!";
//			}
//		}});
//	 });
	 
	$('body').on('click', '#register', function(e){
		
		location.href = "regist.html";
	});
}






