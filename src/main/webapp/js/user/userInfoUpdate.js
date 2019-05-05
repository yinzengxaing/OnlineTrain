//问题：获取目前登陆用户的id
var id = 70;//用户id
var depid=null;//部门号
var sex=null;//性别
$(function(e){
	receiveData();
	//接收你回显用户的id值
	dataInit();
	//自己写一个方法用于回显数据
	
});

function dataInit(){
	AjaxPostUtil.request({url:path+"/post/DepartmentController/getAllDepartment",params:"",type:'json',callback:function(json){
		if(json.returnCode == 0){
			var source = $("#departId").html();
		    var template = Handlebars.compile(source);
		    $("#departnameList").html(template(json));
		    var params  = {
					id:70
			};
			//用户信息回显
			AjaxPostUtil.request({url:path+"/post/UserManageController/selectUserById",params:params,type:'json',callback:function(json){
				if(json.returnCode == 0){
					$('#username').val(json.bean.username);
					$('#sex').val(json.bean.sex);
					sex=json.bean.sex;
					$('#departnameList').val(json.bean.depid);
					depid=json.bean.depid;
					$('#telephonenumber').val(json.bean.telephonenumber);
				}else{
					qiao.bs.msg({msg:json.returnMessage,type:'danger'});
				}
			}
			});
			
		}else{
			qiao.bs.msg({msg:json.returnMessage,type:'danger'});
		}
	}
	});
	eventInit();
}

function eventInit(){
	$('#addDevelopmentForm').bootstrapValidator({
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			username: {
				validators: {
					notEmpty: {
						message: '姓名不能为空！'
					},
					stringLength: {
						max: 20,
						message: '姓名长度应小于20位'
					}
				}
			},
			telephonenumber: {
				validators: {
					notEmpty: {
						message: '联系方式不能为空'
					},
					stringLength: {
						min: 11,
						max: 11,
						message: '联系方式长度为11位'
					},
					regexp: {
						regexp: /^[a-zA-Z0-9_\.]+$/,
						message: '只接受数字和字母 '
					}
				}
			}
		}
	}).on('success.form.bv', function(e) {
			//设置参数
			var params  = {
					id:id,
					username:$('#username').val(),
					sex:sex,
					depid:depid,
					telephonenumber: $('#telephonenumber').val()
			};
			//修改个人信息
			AjaxPostUtil.request({url:path+"/post/UserManageController/updateUserInfo",params:params,type:'json',callback:function(json){
				if(json.returnCode == 0){
					$("#save").hide();
					$("#cancle").hide();
					$('#username').attr('disabled',true);
					$('#sex').attr('disabled',true);
					$('#departnameList').attr('disabled',true);
					$('#telephonenumber').attr('disabled',true);
				}else{
					$("#save").removeAttr("disabled");
					qiao.bs.msg({msg:json.returnMessage,type:'danger'});
				}
			}
			});
		
		return false; //一点要加!!!!
	});
	//取消按钮相应事件
	$('body').on('click', '#cancle', function(e){
		location.href = "index.html";
	});
//	//提交按钮相应事件
//	$('body').on('click', '#save', function(e){
//		var params = {
//				number:$('#addNumber').find("option:selected").attr("tag"),
//				userstart:userstart
//		};
//		alert(params.number);
//		alert(params.userstart);
//		AjaxPostUtil.request({url:path+"/post/UserManageController/insertAllUser",params:params,type:'json',callback:function(json){
//			if (json.returnCode == 0){
//				location.href = "userlist.html";
//			}else{
//				
//				qiao.bs.msg({msg:json.returnMessage,type:'danger'});
//			}
//		}});
//	});
	
}
//下拉框触发事件
function gradeChangedepart(){
	depid=$('#departnameList').find("option:selected").attr("tag");
}
function gradeChangesex(){
	sex=$("#sex").find("option:selected").attr("tag");
}






