/**
 *  小区的前端控制JS
 * 作者：吕淑兰
 * 
 */
$(function(){
	var rows=5;
	var page=1;
	var pageCount=0;
	var areaNo=0;//选择的小区编号
	
	//设置系统页面标题
	$("span#mainpagetille").html("小区管理");
	function getListInfo(){
		
		//操作列表的方法
		//取得小区的列表，分页模式
		//调用后台取得小区列表REST API
		$.getJSON("area/list/all/page",{page:page,rows:rows},function(data){
			//显示个数和页数
			$("span#count").html(data.count);
			$("span#pagecount").html(data.page+"/"+data.pageCount);
			pageCount=data.pageCount;
			//显示列表
			$("table#AreaTable tbody").html("");
			for(var i=0;i<data.list.length;i++){
				var tr="<tr id='"+data.list[i].no+"'><td>"data.list[i].name+"</td><td>"+data.list[i].address+
				"</td><td>"+data.list[i].developer+"</td><td>"+data.list[i].buildingarea+"</td><td>"+data.list[i].usearea+
				"</td><td>"+data.list[i].parkarea+"</td><td>"+data.list[i].home+"</td><td>"+data.list[i].house+"</td><td>"+data.list[i].park+"</td></tr>";
				$("table#AreaTable tbody").append(tr);
			}
			//定义表格行的点击时间，取得选择的小区编号
			$("table#AreaTable tbody tr").on("click",function(){
				areaNo=$(this).attr("id");
				$("table#AreaTable tbody tr").css("background-color","#FFFFFF");
				$(this).css("background-color","#CDCD9A");
			});
	
		});
	}
		
	//定义分页导航链接处理事件
	$("div#page_nav a").on("click",function(event){
		  var action=$(this).attr("href");
		  event.preventDefault();
		  switch(action){
		  	case "top":
		  		page=1;
		  		getListInfo();
		  		break;
		  	case "pre":
		  		if(page>1){
		  			page=page-1;
		  			getListInfo();
		  		}
		  		break;
		  	case "next":
		  		if(page<pageCount){
		  			page=page+1;
		  			getListInfo();
		  		}
		  		break;
		  	case "last":
		  		page=pageCount;
		  		getListInfo();
		  		break;
		  }
		  
			
	});

	//初始调用取得分页列表数据
	getListInfo();
	
	//点击小区增加链接处理，嵌入add.html
	$("a#AreaAddLink").off().on("click",function(event){
				
		$("div#AreaDialogArea").load("area/add.html",function(){
			$("div#AreaDialogArea" ).dialog({
				title:"增加小区",
				width:600
			});
			
			$("form#AreaAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					getListInfo(); 
				}
				//alert(result.message);
				//BootstrapDialog.alert(result.message);
				BootstrapDialog.show({
		            title: '小区操作信息',
		            message:result.message
		        });
				$("div#AreaDialogArea" ).dialog( "close" );
				$("div#AreaDialogArea" ).dialog( "destroy" );
				$("div#AreaDialogArea").html("");
				
			});
			
			//点击取消按钮处理
			$("input[value='取消']").on("click",function(){
				$("div#AreaDialogArea" ).dialog( "close" );
				$("div#AreaDialogArea" ).dialog( "destroy" );
				$("div#AreaDialogArea").html("");
			});
			
			
		});
			
		
	});	
	
	//点击修改按钮事件处理
	$("a#AreaModifyLink").off().on("click",function(event){
		if(areaNo==0){
			BootstrapDialog.show({
	            title: '小区操作信息',
	            message:"请选择要修改的小区"
	        });
		}
		else {
			$("div#AreaDialogArea").load("area/modify.html",function(){
				//取得选择的小区
				$.getJSON("area/get",{no:areaNo},function(data){
					if(data.status=="OK"){
						$("input[name='no']").val(areaNo);
						$("input[name='name']").val(data.model.name);
						$("input[name='address']").val(data.model.address);
						$("input[name='developer']").val(data.model.developer);
						$("input[name='buildingarea']").val(data.model.buildingarea);
						$("input[name='usearea']").val(data.model.usearea);
						$("input[name='parkarea']").val(data.model.parkarea);
						$("input[name='home']").val(data.model.home);
						$("input[name='house']").val(data.model.house);
						$("input[name='park']").val(data.model.park);
						
						
					}
				});
				
				$("div#AreaDialogArea" ).dialog({
					title:"小区修改",
					width:600
				});
				//拦截表单提交
				$("form#AreaModifyForm").ajaxForm(function(result){
					if(result.status=="OK"){
						getListInfo(); 
					}
					//alert(result.message);
					//BootstrapDialog.alert(result.message);
					BootstrapDialog.show({
			            title: '小区操作信息',
			            message:result.message
			        });
					$("div#AreaDialogArea" ).dialog( "close" );
					$("div#AreaDialogArea" ).dialog( "destroy" );
					$("div#AreaDialogArea").html("");
					
				});
				
				
				//点击取消按钮处理
				$("input[value='取消']").on("click",function(){
					$( "div#AreaDialogArea" ).dialog( "close" );
					$( "div#AreaDialogArea" ).dialog( "destroy" );
					$("div#AreaDialogArea").html("");
				});
			});
			
		}
		
		
	});
	
	//点击删除按钮事件处理
	$("a#AreaDeleteLink").off().on("click",function(event){
		
		if(areaNo==0){
			BootstrapDialog.show({
	            title: '小区操作信息',
	            message:"请选择要删除的小区"
	        });
		}
		else {
			BootstrapDialog.confirm('确认删除此小区么?', function(result){
	            if(result) {
		            $.post("area/delete",{no:areaNo},function(result){
		            	if(result.status=="OK"){
							getListInfo(); 
						}
						BootstrapDialog.show({
				            title: '小区操作信息',
				            message:result.message
				        });
		            });
	            }
			});
				
		}
	
	});
	
	//点击查看详细按钮事件处理
	$("a#AreaViewLink").off().on("click",function(event){
		
		if(areaNo==0){
			BootstrapDialog.show({
	            title: '小区操作信息',
	            message:"请选择要查看的小区"
	        });
		}
		else{
			$("div#AreaDialogArea").load("area/view.html",function(){
				//取得选择的小区
				$.getJSON("area/get",{no:areaNo},function(data){
					if(data.status=="OK"){
						$("span#no").html(data.model.no);
						$("span#name").html(data.model.name);
						$("span#address").html(data.model.address);
						$("span#developer").html(data.model.developer);
						$("span#buildingarea").html(data.model.buildingarea);
						$("span#usearea").html(data.model.usearea);
						$("span#parkarea").html(data.model.parkarea);
						$("span#home").html(data.model.home);
						$("span#house").html(data.model.house);
						$("span#park").html(data.model.park);
						
					}
				});
				//弹出Dialog
				$("div#AreaDialogArea" ).dialog({
					title:"小区详细",
					width:600
				});
				//点击取消按钮处理
				$("input[value='返回']").on("click",function(){
					$( "div#AreaDialogArea" ).dialog( "close" );
					$( "div#AreaDialogArea" ).dialog( "destroy" );
					$("div#AreaDialogArea").html("");
				});
			});
			
		}
	});
	
});