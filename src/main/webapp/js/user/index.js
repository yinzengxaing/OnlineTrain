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
	$("ul#userManagement").on("click","li#personal",function(){
	     alert(1);
	 });
	$("ul#userManagement").on("click","li#secure",function(){
	     alecrt(2);
	 });
	
}
