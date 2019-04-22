
$(function(e){
	receiveData();
	dataInit();
});

function dataInit(){
	 
	eventInit();

}

function eventInit(){
	
	
	
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
			imgId = data.result.bean.id;
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



