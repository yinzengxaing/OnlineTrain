var videoId=null;//视频的Id
var courseId=null//课程Id
var examId=null
var count=1;
var sumcount=null;
//var testId=null;
var testId=new Array(51);
var maxcount=1;
var flag=true;
$(function(e){
	receiveData();
	dataInit();
});

function dataInit(){
	if (isNull(courseId)){
		courseId= $.req("courseId");
		if (isNull(videoId)){
			videoId= $.req("videoId");
			if(isNull(examId)){
				examId= $.req("examId");
				if(isNull(sumcount)){
					sumcount= $.req("sumcount");
				}
			}
		}
	}
	if(count==1){
		$("#last").hide();
		$("#finish").hide();
	}
	else{
		$("#cancle").hide();
	}
	$('#testNumber').html("第"+count+"题");
	eventInit();

}

function eventInit(){
	//表单验证
	$('#addTestForm').bootstrapValidator({
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			//题目
			include: {
				validators: {
					notEmpty: {
						message: '题目不能为空！'
					}
				}
			},
			option1: {
				validators: {
					notEmpty: {
						message: '选项一不能为空'
					}
				}
			},
			option2: {
				validators: {
					notEmpty: {
						message: '选项二不能为空'
					}
				}
			},
			option3: {
				validators: {
					notEmpty: {
						message: '选项三不能为空'
					}
				}
			},
			option4: {
				validators: {
					notEmpty: {
						message: '选项四不能为空'
					}
				}
			},
			answer: {
				validators: {
					notEmpty: {
						message: '答案不能为空'
					}
				}
			}
		}
	}).on('success.form.bv', function(e) {
		    if(flag){
		    	//设置参数
			var params  = {
					include:$('#include').val(),
					option1:$('#option1').val(),
					option2:$('#option2').val(),
					option3:$('#option3').val(),
					option4:$('#option4').val(),
					answer:$('#answer').val(),
					examid:examId
					
			};
			//插入课程信息
			AjaxPostUtil.request({url:path+"/post/UploadController/insertTest",params:params,type:'json',callback:function(json){
				if(json.returnCode == 0){
					testId[count]=json.bean.id;
					if(maxcount<count){
						maxcount=count;
					}
					count++;
					$('#testNumber').html("第"+count+"题");
					if(count==sumcount){
						$("#finish").show();
						$("#save").hide();
					}
					$("#last").show();
					$("#cancle").hide();
					$('#include').val(null);
					$('#option1').val(null);
					$('#option2').val(null);
					$('#option3').val(null);
					$('#option4').val(null);
					$('#answer').val(null);
					
				}else{
					qiao.bs.msg({msg:json.returnMessage,type:'danger'});
				}
			}
			});
		    }else{
		    	//设置参数
				var params  = {
						id:testId[count],
						include:$('#include').val(),
						option1:$('#option1').val(),
						option2:$('#option2').val(),
						option3:$('#option3').val(),
						option4:$('#option4').val(),
						answer:$('#answer').val(),
						
				};
				//插入课程信息
				AjaxPostUtil.request({url:path+"/post/UploadController/updateTest",params:params,type:'json',callback:function(json){
					if(json.returnCode == 0){
						count++;
						if(count-1==maxcount){
							flag=true;
							}
						else{//回显试题信息
							$("#save").removeAttr("disabled");
							var params  = {
									id:testId[count]
							};
							AjaxPostUtil.request({url:path+"/post/UploadController/selectTestById",params:params,type:'json',callback:function(json){
								if(json.returnCode == 0){
									$('#include').val(json.bean.include);
									$('#option1').val(json.bean.option1);
									$('#option2').val(json.bean.option2);
									$('#option3').val(json.bean.option3);
									$('#option4').val(json.bean.option4);
									$('#answer').val(json.bean.answer);
								}else{
									qiao.bs.msg({msg:json.returnMessage,type:'danger'});
								}
							}
							});
								
							}
						if(count==sumcount){
							$("#finish").show();
							$("#save").hide();
						}
						$('#testNumber').html("第"+count+"题");
						$("#last").show();
						$("#cancle").hide();
						
					}else{
						qiao.bs.msg({msg:json.returnMessage,type:'danger'});
					}
				}
				});
		    	
		    }
			
		
		return false; //一点要加!!!!
	});
	//上一部按钮相应事件
	$('body').on('click', '#cancle', function(e){
		var params  = {
				examid:examId
		};
		//查找试题信息
		AjaxPostUtil.request({url:path+"/post/UploadController/deleteTestByExamid",params:params,type:'json',callback:function(json){
			if(json.returnCode == 0){
				location.href = "exam.html?examId="+examId+"&&courseId="+courseId+"&&videoId="+videoId+"&&sumcount="+sumcount;
			}else{
				qiao.bs.msg({msg:json.returnMessage,type:'danger'});
			}
		}
		});
	});
	//上一题
	$('body').on('click', '#last', function(e){
		flag = false;
		count--;
		if(count==1){//若回到第一题则按钮显示为上一步和下一题
			$('#last').hide();
			$('#cancle').show();	
		}else if(count==sumcount-1){
			$('#finish').hide();
			$('#save').show();
		}
		$('#testNumber').html("第"+count+"题");
		$("#save").removeAttr("disabled");
		var params  = {
				id:testId[count]
		};
		//查找试题信息
		AjaxPostUtil.request({url:path+"/post/UploadController/selectTestById",params:params,type:'json',callback:function(json){
			if(json.returnCode == 0){
				$('#include').val(json.bean.include);
				$('#option1').val(json.bean.option1);
				$('#option2').val(json.bean.option2);
				$('#option3').val(json.bean.option3);
				$('#option4').val(json.bean.option4);
				$('#answer').val(json.bean.answer);
			}else{
				qiao.bs.msg({msg:json.returnMessage,type:'danger'});
			}
		}
		});
		
	});
	//完成按钮相应事件
	$('body').on('click', '#finish', function(e){
		//设置参数
		var params  = {
				include:$('#include').val(),
				option1:$('#option1').val(),
				option2:$('#option2').val(),
				option3:$('#option3').val(),
				option4:$('#option4').val(),
				answer:$('#answer').val(),
				examid:examId
				
		};
		//插入课程信息
		AjaxPostUtil.request({url:path+"/post/UploadController/insertTest",params:params,type:'json',callback:function(json){
			if(json.returnCode == 0){
				
			}else{
				qiao.bs.msg({msg:json.returnMessage,type:'danger'});
			}
		}
		});
	});
}



