var videopath = null;
var courseId = null;
var finishstudy = null;
var videotime = null;
$(function(e){
	receiveData();
	dataInit();
});

function dataInit(){
	if (isNull(videopath)){
		videopath= $.req("path");
		$("#video-active").attr('src',"../../"+videopath);
		myVid=document.getElementById("video-active");
		if(isNull(courseId)){
			courseId= $.req("courseId");
			var params = {
					id:courseId
			}
			AjaxPostUtil.request({url:path+"/post/UploadController/selectCourseInfo",params:params,type:'json',callback:function(json){
				if(json.returnCode == 0){
					$("#courseName").html(json.bean.cname+"课程");
					$("#introduce").html(json.bean.introduce);
					//设置播放起点
					var params = {
					        cid:courseId,
					        userid:70
					}
					AjaxPostUtil.request({url:path+"/post/CourseManageController/selectTrain",params:params,type:'json',callback:function(json){
						if(json.returnCode == 0){
							setCurTime(json.bean.videotime)
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
	}
	eventInit();

}
function eventInit(){
	$(document).ready(function(){
		$("#video-active").on("timeupdate",function(event){
			onTrackedVideoFrame(this.currentTime, this.duration);
			});
		});
	function onTrackedVideoFrame(currentTime, duration){
/*		if(currentTime>15){//当视频播放进度大于15秒时暂停
			alert(1);
			myVid.pause();
		}
		$("#current").text(currentTime);
		$("#duration").text(duration);
		var a=currentTime/duration;
		var b=(a*100).toFixed(0)+"%";
		document.getElementById('hyTime').style.width=b;
		$("#hy").text(b);
		if(currentTime==duration){
			$("#pro").text("(已完成)");
			}*/
		finishstudy=(currentTime/duration*100).toFixed(0);
		videotime=currentTime;
		}
	
	
}
function getCurTime()
{ 
	//打印当前播放时间
  alert(myVid.currentTime);
} 
function setCurTime(videotime)
{ 
	//从videotime开始播放
  myVid.currentTime=videotime;
} 
function setPlay()
{ 
	//播放
	myVid.play();
} 
function setPause()
{ 
	//暂停
    myVid.pause();
} 
function setPlaySpeed()
{ 
	//设置播放速度
	myVid.defaultPlaybackRate=0.5;
	myVid.load();//1.0,0.5,2.0

} 
window.onbeforeunload=function(e){     
	var params = {
			finishstudy:finishstudy,
	        cid:courseId,
	        userid:70,
	        videotime:videotime
	}
	AjaxPostUtil.request({url:path+"/post/CourseManageController/updateVideoTime",params:params,type:'json',callback:function(json){
		if(json.returnCode == 0){
		}else{
			qiao.bs.msg({msg:json.returnMessage,type:'danger'});
		}
	}
	}); 
} 




