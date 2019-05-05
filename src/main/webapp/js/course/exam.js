var courseId=null//课程Id
var videoId=null//视频id
var examId=null;//试题id
var sumcount=null;
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
	if(isNull(examId)){//若examid是空
		//回显课程名
		var params = {
				id:courseId
		}
		AjaxPostUtil.request({url:path+"/post/UploadController/selectCourseInfo",params:params,type:'json',callback:function(json){
			if(json.returnCode == 0){
			    $("#cname").val(json.bean.cname);
			    $('#cname').attr('disabled',true);
			    
			}else{
				qiao.bs.msg({msg:json.returnMessage,type:'danger'});
			}
		}
		}); 
		
	}else{//不为空，则说明是从试题中回到这一步，应将内容回显
		//回显课程名
		var params = {
				id:courseId
		}
		AjaxPostUtil.request({url:path+"/post/UploadController/selectCourseInfo",params:params,type:'json',callback:function(json){
			if(json.returnCode == 0){
			    $("#cname").val(json.bean.cname);
			    $('#cname').attr('disabled',true);
			  //回显考试信息
				var params = {
						id:examId
				}
				AjaxPostUtil.request({url:path+"/post/UploadController/selectExamById",params:params,type:'json',callback:function(json){
					if(json.returnCode == 0){
					    $("#time").val(json.bean.time);
					    $("#count").val(json.bean.count);
					    $("#score").val(json.bean.score);  
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
		
	}
	eventInit();

}

function eventInit(){
	//下一步按钮相应事件
	$('body').on('click', '#save', function(e){
		if(isNull(examId)){//若为空则插入试题
			var params = {
				courseId:courseId,
				time:$('#time').find("option:selected").attr("tag"),
				count:$('#count').find("option:selected").attr("tag"),
				score:$('#score').find("option:selected").attr("tag")
			}
			AjaxPostUtil.request({url:path+"/post/UploadController/insertExam",params:params,type:'json',callback:function(json){
			if(json.returnCode == 0){
				examId=json.bean.id;
				sumcount=$('#count').find("option:selected").attr("tag");
				location.href = "testAdd.html?examId="+examId+"&&courseId="+courseId+"&&videoId="+videoId+"&&sumcount="+sumcount;
			}else{
				$("#save").removeAttr("disabled");
				qiao.bs.msg({msg:json.returnMessage,type:'danger'});
			}
			}
			}); 
		}
		else{//否则修改试题
			var params = {
					id:examId,
					courseId:courseId,
					time:$('#time').find("option:selected").attr("tag"),
					count:$('#count').find("option:selected").attr("tag"),
					score:$('#score').find("option:selected").attr("tag")
				}
				AjaxPostUtil.request({url:path+"/post/UploadController/updateExam",params:params,type:'json',callback:function(json){
				if(json.returnCode == 0){
					sumcount=$('#count').find("option:selected").attr("tag");
					location.href = "testAdd.html?examId="+examId+"&&courseId="+courseId+"&&videoId="+videoId+"&&sumcount="+sumcount;
				}else{
					$("#save").removeAttr("disabled");
					qiao.bs.msg({msg:json.returnMessage,type:'danger'});
				}
				}
				}); 
			
		}
		
		
	});
	//上一步按钮相应事件
	$('body').on('click', '#cancle', function(e){
		if(!isNull(examId)){
			var params = {
					id:examId
				}
				AjaxPostUtil.request({url:path+"/post/UploadController/deleteExam",params:params,type:'json',callback:function(json){
				if(json.returnCode == 0){	
					location.href = "course_add.html?courseId="+courseId+"&&videoId="+videoId;
				}else{
					$("#save").removeAttr("disabled");
					qiao.bs.msg({msg:json.returnMessage,type:'danger'});
				}
				}
				}); 
		}else{
			location.href = "course_add.html?courseId="+courseId+"&&videoId="+videoId;
		}
		
	});
	
}
//下拉框触发事件
function countChange(){
	$('#count').attr('disabled',false);
	if($('#count').find("option:selected").attr("tag")==20){
		$('#score').val(5);
	}
	else if($('#count').find("option:selected").attr("tag")==25){
		$('#score').val(4);
	}
	else{
		$('#score').val(2);
	}
	$('#score').attr('disabled',true);
}
function scoreChange(){
	$('#score').attr('disabled',false);
	if($('#score').find("option:selected").attr("tag")==5){
		$('#count').val(20);
	}
	else if($('#score').find("option:selected").attr("tag")==4){
		$('#count').val(25);
	}
	else{
		$('#count').val(50);
	}
	$('#count').attr('disabled',true);
	
}



