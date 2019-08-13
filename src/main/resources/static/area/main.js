/**
 *  小区的前端控制JS
 * 作者：吕淑兰
 * 
 */
$(function(){
	var no=0;
	var name=null;
	var developer=null;
	var minbuildingarea=0;
	var maxbuildingarea=0;
	var minhome=0;
	var maxhome=0;
	var minhouse=0;
	var maxhouse=0;
	//var areaNo=0;//选择的小区编号
	
	//设置系统页面标题
	$("span#mainpagetille").html("小区管理");
	//显示小区列表
	$("table#AreaGrid").jqGrid({
		url: 'area/list/condition/page',
		datatype: "json",
		colModel: [
			{ label: '小区名称', name: 'name', width: 60 },
			{ label: '小区地址', name: 'address', width: 60 },
			{ label: '开发商', name: 'developer', width: 60 },
			{ label: '总建筑面积', name: 'buildingarea', width: 60 },
			{ label: '总使用面积', name: 'usearea', width: 60},
			{ label: '车位面积', name: 'parkarea', width: 60 },
			{ label: '总居民数', name: 'home', width: 60 },  
			{ label: '总公建数', name: 'house', width: 60 },
			{ label: '车位数', name: 'park', width: 60 } 
		],
		caption:"小区列表",
		viewrecords: true, 
		autowidth: true,
		height: 300,
		rowNum: 5,
		rowList:[5,6,7,8,9,10],
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "no"},
		pager: "#AreaGridPager",
		multiselect:false,
		onSelectRow:function(ano){
			no=aid;
		}
		
	});
	//取得小区列表，填充小区下拉框
	$.getJSON("area/list/all",function(areaList){
		if(areaList){
			$.each(areaList,function(index,am){
				$("select#AreaSelection").append("<option value='"+am.no+"'>"+am.name+"</option>");
			});
		}
	});
	//取得开发商列表，填充开发商下拉框
	$.getJSON("area/list/all",function(developerList){
		if(developerList){
			$.each(developerList,function(index,dm){
				$("select#DeveloperSelection").append("<option value='"+dm.no+"'>"+dm.developer+"</option>");
			});
		}
	});
	//设置检索参数，更新jQGrid的列表显示
	function reloadAreaList()
	{
		$("table#AreaGrid").jqGrid('setGridParam',{postData:{name:name,developer:developer,minbuildingarea:minbuildingarea,maxbuildingarea:maxbuildingarea,minhome:minhome,maxhome:maxhome,minhouse:minhouse,maxhouse:maxhouse}}).trigger("reloadGrid");
		
	}
	
	//定义小区下拉框的更新事件的处理
	$("select#AreaSelection").off().on("change",function(){
		name=$("select#AreaSelection").val();
		reloadAreaList();
	});
	
	//点击检索事件处理
	$("a#AreaSearchButton").on("click",function(){
		name=$("select#AreaSelection").val();
		developer=$("select#DeveloperSelection").val();
		minbuildingarea=$("input#minbuildingarea").val();
		maxbuildingarea=$("input#maxbuildingarea").val();
		minhome=$("input#minhome").val();
		maxhome=$("input#maxhome").val();
		minhouse=$("input#minhouse").val();
		maxhouse=$("input#maxhouse").val();
		
		reloadAreaList();
	});
	
	
});

/*
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
				var tr="<tr id='"+data.list[i].no+"'><td>"+data.list[i].name+
				"</td><td>"+data.list[i].address+
				"</td><td>"+data.list[i].developer+
				"</td><td>"+data.list[i].buildingarea+
				"</td><td>"+data.list[i].usearea+
				"</td><td>"+data.list[i].parkarea+
				"</td><td>"+data.list[i].home+
				"</td><td>"+data.list[i].house+
				"</td><td>"+data.list[i].park+"</td></tr>";
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
*/