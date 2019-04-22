//问题：获取目前登陆用户的id
var id = 70;//用户id
$(function(e){
	receiveData();
	//接收你回显用户的id值
	dataInit();
	//自己写一个方法用于回显数据
	
});

function dataInit(){
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
			newpassword: {
				validators: {
					notEmpty: {
						message: '新密码不能为空！'
					},
					stringLength: {
						min: 6,
						max: 20,
						message: '新密码长度必须大于六个字符小于20字符！'
					},
					regexp: {
						regexp: /^[a-zA-Z0-9_\.]+$/,
						message: '只接受数字和字母 '
					}
				}
			},
			secondpassword: {
				validators: {
					notEmpty: {
						message: '确认密码不能为空！'
					},
					stringLength: {
						min: 6,
						max: 20,
						message: '确认密码长度必须大于六个字符小于20字符！'
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
					newpassword:$('#newpassword').val(),
					secondpassword: $('#secondpassword').val()
			};
			//进行部门的添加
			AjaxPostUtil.request({url:path+"/post/UserManageController/updatePassword",params:params,type:'json',callback:function(json){
				if(json.returnCode == 0){
					qiao.bs.msg({msg:json.returnMessage,type:'success'});
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
}






