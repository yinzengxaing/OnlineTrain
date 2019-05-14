var userstart="";
$(function(e){
	dataInit();
});

function dataInit(){
	var oTable = new TableInit();
	oTable.Init();
	eventInit();
}
function eventInit(){
	
}
var TableInit = function (){
	var oTableInit = new Object();
	//初始化Table
	oTableInit.Init = function () {
		$('#massage').bootstrapTable({
			url: path+'/post/CourseManageController/selectAllCourseInfo',             //请求后台的URL（*） 
			method: 'post',                     //请求方式（*）
			toolbar: '#toolbar',                //工具按钮用哪个容器
			striped: true,                      //是否显示行间隔色
			cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,                   //是否显示分页（*）
			sortable: false,                    //是否启用排序
			sortOrder: "asc",                   //排序方式
			queryParams: oTableInit.queryParams,//传递参数（*）
			contentType: "application/x-www-form-urlencoded",         //发送到服务器的数据编码类型
			sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
			pageNumber:1,                       //初始化加载第一页，默认第一页
			pageSize: 10,                       //每页的记录行数（*）
			pageList: [10],        //可供选择的每页的行数（*）
			height:700,
			showColumns: true,                  //是否显示所有的列
			showRefresh: true,                  //是否显示刷新按钮
			minimumCountColumns: 2,             //最少允许的列数
			uniqueId: "id",                     //每一行的唯一标识，一般为主键列
			showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
			cardView: false,                    //是否显示详细视图
			detailView: false,                  //是否显示父子表
			columns: [ {
				field: 'Number',
				title: '序号',
				width: '50',
				align: 'center',
				formatter: function (value, row, index) {
					return index+1;
				}
			}, {
				field: 'cname',
				title: '课程名称',
				align: 'center',
				width: '150',
				formatter: function (value, row, index) {
					return '<a style="word-wrap:break-word;">'+value+'</a>';
				}
			},{
				field: 'cstart',
				title: '创建时间',
				align: 'center',
				width: '200',
				formatter: function (value, row, index) {
					return '<a style="word-wrap:break-word;">'+value+'</a>';
				}
			},{
				field :'cend',
				title: '截止时间',
				align: 'center',
        	  	width: '100',
        	  	formatter: function (value, row, index){
        	  		return '<a style="word-wrap:break-word;">'+value+'</a>';
        	  	}
			},{
				field :'departname',
				title: '部门',
				align: 'center',
        	  	width: '100',
        	  	formatter: function (value, row, index){
        	  		return '<a style="word-wrap:break-word;">'+value+'</a>';
        	  	}
			},{
				field :'publish',
				title: '是否发布',
				align: 'center',
        	  	width: '100',
        	  	formatter: function (value, row, index){
        	  		if(value==0){
        	  		return '<a style="word-wrap:break-word;">'+'未发布'+'</a>';
        	  		}
        	  		else{
        	  		return '<a style="word-wrap:break-word;">'+'已发布'+'</a>';
        	  		}
        	  	}
			},{
				field: 'operate',
	            title: '操作',
	            width: '300',
	            align: 'center',
	            events: EvenInit,
	            formatter: operateFormatter
			}],
			onLoadSuccess: function(){  //加载成功时执行
				console.log("加载成功");
          },
          	onLoadError: function(){  //加载失败时执行
          		console.log("加载数据失败", {time : 1500, icon : 2});
          	}
		});
	};
	  //得到查询的参数
	oTableInit.queryParams = function (params) {
		var temp={
				limit: params.limit,   // 页面大小
				offset: params.offset,  // 页码
				username:$('#username').val()
		};
		return temp;
	};
	return oTableInit;
}

//操作按钮点击事件
window.EvenInit = {
		'click .RoleOfA': function (e, value, row, index) {
			location.href = "course_add.html?courseId="+row.id+"&&videoId="+row.fileId;
			},
		'click .RoleOfB': function (e, value, row, index) { // 发布
			var params  = {
					id:row.id
			};
			//插入到train表
			AjaxPostUtil.request({url:path+"/post/CourseManageController/publishCourse",params:params,type:'json',callback:function(json){
				if(json.returnCode == 0){
					setTimeout(refreshTable,500);//半秒后刷新页面
				}else{
					qiao.bs.msg({msg:json.returnMessage,type:'danger'});
				}
			}
			});
		    },
		  'click .RoleOfC': function (e, value, row, index) { // 取消发布
				var params  = {
						id:row.id
				};
				//插入到train表
				AjaxPostUtil.request({url:path+"/post/CourseManageController/cancelPublishCourse",params:params,type:'json',callback:function(json){
					if(json.returnCode == 0){
						setTimeout(refreshTable,500);//半秒后刷新页面
					}else{
						qiao.bs.msg({msg:json.returnMessage,type:'danger'});
					}
				}
				});
		  }
			
		};
function operateFormatter(value, row, index) {
	    if(row.publish==0){
		return [
		        '<button type="button" class="RoleOfA btn btn-default  btn-sm" style="margin-right:15px;">编辑</button>',
				'<button type="button" id="publish" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;">发布</button>'
		        ].join('');
	    }else{
	    return [
	    	 '<button type="button" class="RoleOfA btn btn-default  btn-sm" style="margin-right:15px;">编辑</button>',
			 '<button type="button" id="publish" class="RoleOfC btn btn-default  btn-sm" style="margin-right:15px;">取消发布</button>'
		        ].join('');
	    }
};
//刷新表格
function refreshTable(){
	$('#massage').bootstrapTable('refresh',{url:path+'/post/CourseManageController/selectAllCourseInfo'});
}
