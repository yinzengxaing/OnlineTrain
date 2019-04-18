$(function(e){
	receiveData();
	dataInit();
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
					developmentName : $('#developmentName').val(),
			};
			//进行部门的添加
			AjaxPostUtil.request({url:path+"",params:params,type:'json',callback:function(json){
				if(json.returnCode == 0){
					location.href = "pdevelopment_list.html";
				}else{
					$("#saveMenu").removeAttr("disabled");
					qiao.bs.msg({msg:json.returnMessage,type:'danger'});
				}
			}
			});
		
		return false; //一点要加!!!!
	});
	//取消按钮相应事件
	$('body').on('click', '#cancleBean', function(e){
		location.href = "development_list.html";
	});
	
}





