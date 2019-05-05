var videoId=null;//视频的Id
var courseId=null//课程Id
var depid=null//部门Id
var userid=70//创建人id
$(function(e){
	receiveData();
	dataInit();
});

function dataInit(){
	if (isNull(courseId)){
		courseId= $.req("courseId");
		if (isNull(videoId)){
			videoId= $.req("videoId");
		}
	}
	//回显部门
	AjaxPostUtil.request({url:path+"/post/DepartmentController/getAllDepartment",params:"",type:'json',callback:function(json){
		if(json.returnCode == 0){
			var source = $("#departId").html();
		    var template = Handlebars.compile(source);
		    $("#departnameList").html(template(json));
		    //若课程id值不为空则回显课程信息（说明是创建试题的上一步）
		    if(!isNull(courseId)){
		    	var params  = {
						id:courseId
				};
		    	AjaxPostUtil.request({url:path+"/post/UploadController/selectCourseInfo",params:params,type:'json',callback:function(json){
					if(json.returnCode == 0){
						$("#cname").val(json.bean.cname);
						$("#cend").val(json.bean.cend);
						$("#introduce").val(json.bean.introduce);
						$('#departnameList').val(json.bean.did);
					}else{
						qiao.bs.msg({msg:json.returnMessage,type:'danger'});
					}
				}
				});
		    	
		    }
		}else{
			qiao.bs.msg({msg:json.returnMessage,type:'danger'});
		}
	}
	}); 
	eventInit();

}

function eventInit(){
	//表单验证
	$('#addCourseForm').bootstrapValidator({
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			//产品名称
			cname: {
				validators: {
					notEmpty: {
						message: '课程名不能为空！'
					},
					stringLength: {
						 max: 20,
						message: '课程名长度必须小于20字符！'
					}
				}
			},
			introduce: {
				validators: {
					notEmpty: {
						message: '课程介绍不能为空'
					},
					stringLength: {
						min: 0,
						max: 500,
						message: '课程介绍长度不能大于50'
					}
				}
			}
		}
	}).on('success.form.bv', function(e) {
		//若课程id不为空，则下一步操作为修改课程信息
		if(!isNull(courseId)){
			//设置参数
			var params  = {
				    id:courseId,
					cname:$('#cname').val(),
					cend:$('#cend').val(),
					introduce:$('#introduce').val(),
					did:$('#departnameList').find("option:selected").attr("tag"),
					userid:userid
			};
			AjaxPostUtil.request({url:path+"/post/UploadController/updateCourseInfo",params:params,type:'json',callback:function(json){
				if(json.returnCode == 0){
					location.href = "exam.html?courseId="+courseId+"&&videoId="+videoId;
				}else{
					$("#save").removeAttr("disabled");
					qiao.bs.msg({msg:json.returnMessage,type:'danger'});
				}
			}
			});
		}
		else{//为空则添加课程
			//设置参数
			if(isNull(videoId)){
				$("#save").removeAttr("disabled");
				qiao.bs.msg({msg:"未上传视频，请上传",type:'danger'});
			}
			else{
				var params  = {
					cname:$('#cname').val(),
					cend:$('#cend').val(),
					introduce:$('#introduce').val(),
					did:$('#departnameList').find("option:selected").attr("tag"),
					userid:userid
			};
			//插入课程信息
			AjaxPostUtil.request({url:path+"/post/UploadController/insertCourse",params:params,type:'json',callback:function(json){
				if(json.returnCode == 0){
					courseId=json.bean.id;
					//设置参数
					var params  = {
							fileId:videoId,
							courseId:courseId
					};
					//设置视频对应课程
					AjaxPostUtil.request({url:path+"/post/UploadController/updateVideoCourseId",params:params,type:'json',callback:function(json){
						if(json.returnCode == 0){
							location.href = "exam.html?courseId="+courseId+"&&videoId="+videoId;
						}else{
							$("#save").removeAttr("disabled");
							qiao.bs.msg({msg:json.returnMessage,type:'danger'});
						}
					}
					});
					
				}else{
					$("#save").removeAttr("disabled");
					qiao.bs.msg({msg:json.returnMessage,type:'danger'});
				}
			}
			});
			}
			
		}	
		
		return false; //一点要加!!!!
	});
	//取消按钮相应事件
	$('body').on('click', '#cancle', function(e){
		if(!isNull(videoId)){//如果视频id不为空则删除
			var params  = {
					id:videoId
			};
			//设置视频对应课程
			AjaxPostUtil.request({url:path+"/post/UploadController/deleteVideo",params:params,type:'json',callback:function(json){
				if(json.returnCode == 0){
					if(!isNull(courseId)){//若课程id不为空则删除
						var params  = {
								id:courseId
						};
						//设置视频对应课程
						AjaxPostUtil.request({url:path+"/post/UploadController/deleteCourse",params:params,type:'json',callback:function(json){
							if(json.returnCode == 0){
								//所有内容置空
								$('#cname').val("");
								$('#cend').val("2019-04-26");
								$('#introduce').val("");
								$('#departnameList').val(7);	
							}else{
								qiao.bs.msg({msg:json.returnMessage,type:'danger'});
							}
						}
						});
						
					}
					else{
						//所有内容置空
						$('#cname').val("");
						$('#cend').val("2019-04-26");
						$('#introduce').val("");
						$('#departnameList').val(7);
					}
				}else{
					qiao.bs.msg({msg:json.returnMessage,type:'danger'});
				}
			}
			});
		}
		else{
			//所有内容置空
			$('#cname').val("");
			$('#cend').val("2019-04-26");
			$('#introduce').val("");
			$('#departnameList').val(7);
		}
		
	});
	
	
	//上传视频
	$("#videoFiles").fileupload({
		url : path + "/post/UploadController/insertVideoFile",
		disableImageResize: /Android(?!.*Chrome)|Opera/.test(window.navigator.userAgent),
        autoUpload: true,//是否自动上传
        maxFileSize: 500 * 1024 * 1024,
        minFileSize: 5,
        dataType:'json',
        acceptFileTypes: /(\.|\/)(3gp|flv|rmvb|mp4|wmv|avi|mkv|mp3|wav)$/i,
	}).on('fileuploadadd', function (e, data) {
		//进行文件添加的操作
		var uploadFile = data.files[0];
		fileName = uploadFile.name;
		var reg = ".(3gp|flv|rmvb|mp4|wmv|avi|mkv|mp3|wav)$";
		var re = new RegExp(reg);
		if (fileName.length > 50) {
			qiao.bs.msg({msg:"文件名长度不能大于50",type:'danger'});
			return false;
		} else if (!re.test(fileName.toLowerCase())) {
			qiao.bs.msg({msg:"文件必须为jpg/jpeg/png格式",type:'danger'});
			return false;
		} else if (uploadFile.size > 500000000) { // 2mb
			qiao.bs.msg({msg:"文件不能大于500M",type:'danger'})
			return false;
			
		}
	}).on('fileuploaddone', function (e, data) {
		//进行文件上传的操作
		if(isNull(data.result.bean)){
			qiao.bs.msg({msg:data.result.returnMessage,type:'danger'});
		}else{
			qiao.bs.msg({msg:"上传成功",type:'success'});
			videoId = data.result.bean.fileId;
		}
	}).on('fileuploadfail', function (e, data) {
		//上传失败的
		qiao.bs.msg({msg:"上传失败，视频格式不正确",type:'danger'});
	});
}


//multiselect转换字符串
function returnSelStr(str){
	if(isNull(str)){
		return null;
	}else{
		return str.toString(",");
	}
}
//下拉框触发事件
function gradeChangedepart(){
	depid=$('#departnameList').find("option:selected").attr("tag");
}



