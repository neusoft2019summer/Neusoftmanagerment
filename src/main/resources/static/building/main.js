/**
 *  楼宇的前端控制JS
 * 作者：吕淑兰
 * 
 */
$(function(){
	var rows=10;
	var page=1;
	var pageCount=0;
	var buildingNo=0;//选择的楼宇编号
	
	//设置系统页面标题
	$("span#mainpagetille").html("楼宇管理");
	//操作列表的方法
	//取得楼宇的列表，分页模式
	function getListInfo(){
		$.getJSON("building/list/all/page",{page:page,rows:rows},function(data){
			//显示个数和页数
			$("span#count").html(data.count);
			$("span#pagecount").html(data.page+"/"+data.pageCount);
			pageCount=data.pageCount;
			//显示列表
			$("table#BuildingTable tbody").html("");
			for(var i=0;i<data.list.length;i++){
				var tr="<tr id='"+data.list[i].no+"'><td>"+data.list[i].area.no
				+"</td><td>"+data.list[i].code
				+"</td><td>"+data.list[i].address
				+"</td><td>"+data.list[i].buildingtype.no
				+"</td><td>"+data.list[i].direction
				+"</td><td>"+data.list[i].home
				+"</td><td>"+data.list[i].house+"</td></tr>";
				$("table#BuildingTable tbody").append(tr);
			}
			//定义表格行的点击时间，取得选择的楼宇编号
			$("table#BuildingTable tbody tr").on("click",function(){
				buildingNo=$(this).attr("id");
				$("table#BuildingTable tbody tr").css("background-color","#FFFFFF");
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
	
	//点击楼宇增加链接处理，嵌入add.html
	$("a#BuildingAddLink").off().on("click",function(event){
				
		$("div#BuildingDialogArea").load("building/add.html",function(){
			$("div#BuildingDialogArea" ).dialog({
				title:"增加楼宇",
				width:600
			});
			
			$("form#BuildingAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					getListInfo(); 
				}
				//alert(result.message);
				//BootstrapDialog.alert(result.message);
				BootstrapDialog.show({
		            title: '楼宇操作信息',
		            message:result.message
		        });
				$("div#BuildingDialogArea" ).dialog( "close" );
				$("div#BuildingDialogArea" ).dialog( "destroy" );
				$("div#BuildingDialogArea").html("");
				
			});
			
			//点击取消按钮处理
			$("input[value='取消']").on("click",function(){
				$("div#BuildingDialogArea" ).dialog( "close" );
				$("div#BuildingDialogArea" ).dialog( "destroy" );
				$("div#BuildingDialogArea").html("");
			});
			
			
		});
			
		
	});	
	
	//点击修改按钮事件处理
	$("a#BuildingModifyLink").off().on("click",function(event){
		if(buildingNo==0){
			BootstrapDialog.show({
	            title: '楼宇操作信息',
	            message:"请选择要修改的楼宇"
	        });
		}
		else {
			$("div#BuildingDialogArea").load("building/modify.html",function(){
				//取得选择的楼宇
				$.getJSON("building/get",{no:buildingNo},function(data){
					if(data.status=="OK"){
						$("input[name='no']").val(buildingNo);
						$("input[name='areaNo']").val(data.model.area.no);
						$("input[name='code']").val(data.model.code);
						$("input[name='address']").val(data.model.address);
						$("input[name='buildingTypeNo']").val(data.model.buildingtype.no);
						$("input[name='direction']").val(data.model.direction);
						$("input[name='home']").val(data.model.home);
						$("input[name='house']").val(data.model.house);
					}
				});
				
				$("div#BuildingDialogArea" ).dialog({
					title:"楼宇修改",
					width:600
				});
				//拦截表单提交
				$("form#BuildingModifyForm").ajaxForm(function(result){
					if(result.status=="OK"){
						getListInfo(); 
					}
					//alert(result.message);
					//BootstrapDialog.alert(result.message);
					BootstrapDialog.show({
			            title: '楼宇操作信息',
			            message:result.message
			        });
					$("div#BuildingDialogArea" ).dialog( "close" );
					$("div#BuildingDialogArea" ).dialog( "destroy" );
					$("div#BuildingDialogArea").html("");
					
				});
				
				
				//点击取消按钮处理
				$("input[value='取消']").on("click",function(){
					$( "div#BuildingDialogArea" ).dialog( "close" );
					$( "div#BuildingDialogArea" ).dialog( "destroy" );
					$("div#BuildingDialogArea").html("");
				});
			});
			
		}
		
		
	});
	
	//点击删除按钮事件处理
	$("a#BuildingDeleteLink").off().on("click",function(event){
		
		if(buildingNo==0){
			BootstrapDialog.show({
	            title: '楼宇操作信息',
	            message:"请选择要删除的楼宇"
	        });
		}
		else {
			BootstrapDialog.confirm('确认删除此楼宇么?', function(result){
	            if(result) {
		            $.post("building/delete",{no:buildingNo},function(result){
		            	if(result.status=="OK"){
							getListInfo(); 
						}
						BootstrapDialog.show({
				            title: '楼宇操作信息',
				            message:result.message
				        });
		            });
	            }
			});
				
		}
	
	});
	
	//点击查看详细按钮事件处理
	$("a#BuildingViewLink").off().on("click",function(event){
		
		if(buildingNo==0){
			BootstrapDialog.show({
	            title: '楼宇操作信息',
	            message:"请选择要查看的楼宇"
	        });
		}
		else{
			$("div#BuildingDialogArea").load("building/view.html",function(){
				//取得选择的楼宇
				$.getJSON("building/get",{no:buildingNo},function(data){
					if(data.status=="OK"){
						$("span#no").html(data.model.no);
						$("span#areaNo").html(data.model.area.no);
						$("span#code").html(data.model.code);
						$("span#address").html(data.model.address);
						$("span#buildingTypeNo").html(data.model.buildingtype.no);
						$("span#direction").html(data.model.direction);
						$("span#home").html(data.model.home);
						$("span#house").html(data.model.house);	
					}
				});
				//弹出Dialog
				$("div#BuildingDialogArea" ).dialog({
					title:"楼宇详细",
					width:600
				});
				//点击取消按钮处理
				$("input[value='返回']").on("click",function(){
					$( "div#BuildingDialogArea" ).dialog( "close" );
					$( "div#BuildingDialogArea" ).dialog( "destroy" );
					$("div#BuildingDialogArea").html("");
				});
			});
			
		}
	});
	
});