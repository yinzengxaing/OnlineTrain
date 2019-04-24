var path = null;
$(function(e){
	receiveData();
	dataInit();
});

function dataInit(){
	if (isNull(path)){
		path= $.req("path");
		$("#video-active").attr('src',"../../"+path);
		myVid=document.getElementById("video-active");
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
		if(currentTime>15){//当视频播放进度大于15秒时暂停
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
			}
		}
	
	
}
function getCurTime()
{ 
	//打印当前播放时间
  alert(myVid.currentTime);
} 
function setCurTime()
{ 
	//从五秒开始播放
  myVid.currentTime=5;
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




