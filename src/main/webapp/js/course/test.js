var courseId=null//课程Id
var userid=70//创建人id
var time=null;
var numb=null;
$(function(e){
	receiveData();
	dataInit();
});

function dataInit(){
	if (isNull(courseId)){
		courseId= $.req("courseId");
		var params = {
				id:courseId
		}
		AjaxPostUtil.request({url:path+"/post/CourseManageController/selectCourseForTest",params:params,type:'json',callback:function(json){
			if(json.returnCode == 0){
			    if(json.bean.time==0.5){
			    	time=30*60;
			    }
			    else if(json.bean.time==1){
			    	time = 60*60;
			    }
			    else if(json.bean.time=1.5){
			    	time = 90*60;
			    }
			    else{
			    	time = 120*60;
			    }
			    $("#courseName").html(json.bean.cname); 
			    var params = {
						id:courseId
				}
				AjaxPostUtil.request({url:path+"/post/CourseManageController/selectTestList",params:params,type:'json',callback:function(json){
					if(json.returnCode == 0){
						var source = $("#testId").html();
					    var template = Handlebars.compile(source);
					    $("#testList").html(template(json));
					    numb = json.rows[0].id;
					    eventInit();
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

function eventInit(){
	resetTime(time);
	$('#saveMenu').click(function () {  
		
		
        var result = "";
        var flag =0;
        var s = undefined;
        $("ol").each(function(){
        	var id =$(this).attr("id");
        	var valnumb =$('input:radio[name="'+id+'"]:checked').val();
       	if( valnumb != s){
       		result =result+id+"-"+valnumb+"===="
        	}else{
        		flag = 1;
        		qiao.bs.msg({msg:"您还有题目没有完成",type:'danger'});
        		return false ;
        	}
        });
        if (flag == 1){
        	return ;
        }
       // alert(result)
      /*  for(var i = 0; i < 20; i++){
        	var sumnumb = i+numb; //这个是题目id
        	var valnumb=$('input:radio[name="'+sumnumb+'"]:checked').val(); //这个是题目答题人员写的答案 我这么理解没有错把
        	  include = include +  sumnumb+':'+valnumb+',';
        }*/
        var params ={
        		numb:numb,
        		include	:result,
        		id:courseId,
        		userid:userid
        };
       // console.log(params);
        AjaxPostUtil.request({url:path+"/post/CourseManageController/submitTest",params:params,type:'json',callback:function(json){
			if(json.returnCode == 0){
				$('#gradeModel').modal('show');
				$('#grade').html(json.bean.grade);
			}else{
				qiao.bs.msg({msg:json.returnMessage,type:'danger'});
			}
		}
		});
        
    })

}

//倒计时器
function resetTime(time){
	  var timer=null;
	  var t=time;
	  var m=0;
	  var s=0;
	  h=Math.floor(t/3600)
	  h<10&&(h='0'+m);
	  m=Math.floor(t/60%60);
	  m<10&&(m='0'+m);
	  s=Math.floor(t%60);
	  function countDown(){
	   s--;
	   s<10&&(s='0'+s);
	   if(s.length>=3){
	    s=59;
	   if(m<10){
		 m="0"+(Number(m)-1); 
	   }else{
		 m=(Number(m)-1);
	   }
	   if(m.length>=3){
		 m=59;
		 if(h<10){
			 h="0"+(Number(h)-1); 
		 }else{
			 h=(Number(h)-1);
		 }
	   }
	   
	   }
	   if(h.length>=3){
		h='00'
	    m='00';
	    s='00';
	    clearInterval(timer);
	   }
	  // console.log(m+"分钟"+s+"秒");
	   $("#t_h").html(h + "时"); 
	   $("#t_m").html(m + "分"); 
	   $("#t_s").html(s + "秒"); 
	  }
	  timer=setInterval(countDown,1000);
}

window.onbeforeunload=function(e){     
	var e = window.event||e;  
	　　e.returnValue=("正在进行考试，确定离开考试页面吗？");
} 