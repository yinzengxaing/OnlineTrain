//在上面获取你要回显部门的id
var developmentId = null;
$(function(e){
	receiveData();
	//接收你回显部门的id值
	
	dataInit();
	
	//自己写一个方法用于回显数据
	
});

function dataInit(){
//	AjaxPostUtil.request({url:path+"/post/DepartmentController/getDepartmentList",params:params,type:'json',callback:function(json){
//		if(json.returnCode == 0){
//			$("#departname").html($("#departname").html()+first+1+second+10+end);
//			
//		}else{
//			qiao.bs.msg({msg:json.returnMessage,type:'danger'});
//		}
//	}
//	});
	var params  = {
			id:70
	};
	//用户信息回显
	AjaxPostUtil.request({url:path+"/post/UserManageController/selectUserById",params:params,type:'json',callback:function(json){
		if(json.returnCode == 0){
			$('#username').val(json.bean.username);
			$('#sex').val(json.bean.sex);
			//$('#departname').val(json.bean.departname);
			$('#telephonenumber').val(json.bean.telephonenumber);
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
			//产品名称
			developmentName: {
				validators: {
					notEmpty: {
						message: '部门名称不能为空！'
					},
					stringLength: {
						 max: 20,
						message: '部门名称长度必须小于20字符！'
					}
				}
			}
		}
	}).on('success.form.bv', function(e) {
			//设置参数
			var params  = {
					id:developmentId,
					departname : $('#developmentName').val()
			};
			//进行部门的添加
			AjaxPostUtil.request({url:path+"/post/DepartmentController/updateDepartment",params:params,type:'json',callback:function(json){
				if(json.returnCode == 0){
					location.href = "development_list.html";
				}else{
					$("#saveMenu").removeAttr("disabled");
					qiao.bs.msg({msg:json.returnMessage,type:'danger'});
				}
			}
			});
		
		return false; //一点要加!!!!
	});
	//取消按钮相应事件
	$('body').on('click', '#cancle', function(e){
		location.href = "userlist.html";
	});
	//提交按钮相应事件
	$('body').on('click', '#save', function(e){
		var params = {
				number:$('#addNumber').find("option:selected").attr("tag"),
				userstart:userstart
		};
		alert(params.number);
		alert(params.userstart);
		AjaxPostUtil.request({url:path+"/post/UserManageController/insertAllUser",params:params,type:'json',callback:function(json){
			if (json.returnCode == 0){
				location.href = "userlist.html";
			}else{
				
				qiao.bs.msg({msg:json.returnMessage,type:'danger'});
			}
		}});
	});
	
}





