var id = null;
$(function(e){
	receiveData();
	//接收你回显部门的id值
	
	dataInit();
	
	//自己写一个方法用于回显数据
});

function dataInit(){
	if (isNull(id)){
		id=$.req("id");
	}
	eventInit();
}
function eventInit(){
	
}
function quit(){
	AjaxPostUtil.request({url:path+"/post/LoginController/clearSession",params:{},type:'json',callback:function(jsonSession){		
		if(jsonSession.returnCode==0){
			if(!isNull(jsonSession.bean)){
				location.href = 'login.html';
			}
		}else{
			
		}
	}});
}

