/**
 * 客户前端主管理JS
 * 模块：baseinfo
 * 业务对象：客户
 * 作者陈思颖
 */

$(function(){
	var roomno=0;
	var areano=0;
	var buildingtypeno=null;
	var housetypeno=0;
	var buildingno=0;
	var host="http://localhost:8100";
	//设置系统页面标题
	$("span#mainpagetille").html("房间管理");
	
	//显示客户列表
	$("table#RoomGrid").jqGrid({
		url: 'room/list/condition/page',
		datatype: "json",
		colModel: [
			{ label: '小区编号', name: 'area.areano', width: 50 },
			{ label: '建筑类型编号', name: 'buildingtype.typeno', width: 50 },
			{ label: '户型编号', name: 'housetype.typeno', width: 70 },
			{ label: '楼宇编号', name: 'building.buildingno', width: 70 },
			{ label: '单元', name: 'departmentcode', width: 70},
			{ label: '楼层', name: 'floor', width: 70 },
			{ label: '房间号', name: 'roomcode', width: 70 }
		],
		caption:"房间列表",
		viewrecords: true, 
		autowidth: true,
		height: 400,
		rowNum: 10,
		rowList:[10,20,30],
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "no"},
		pager: "#RoomGridPager",
		multiselect:false,
		onSelectRow:function(rno){
			roomno=rno;
			//alert(customerno);
		}
	});
	

	
	//取得小区列表，填充小区列表下拉框
	$.getJSON(host+"area/list/all",function(areaList){
		if(areaList){
			$.each(areaList,function(index,um){
				$("select#AreaNoSelection").append("<option value='"+um.no+"'>"+um.name+"</option>");
			});
		}
	});
	
	//取得建筑类型编号列表，填充建筑类型编号列表下拉框
	$.getJSON(host+"buildingtype/list/all",function(typeList){
		if(typeList){
			$.each(typeList,function(index,um){
				$("select#BuildingTypeNoSelection").append("<option value='"+um.no+"'>"+um.name+"</option>");
			});
		}
	});
	
	//取得户型编号列表，填充户型编号列表下拉框
	$.getJSON(host+"housetype/list/all",function(typeList){
		if(typeList){
			$.each(typeList,function(index,um){
				$("select#HouseTypeNoSelection").append("<option value='"+um.no+"'>"+um.name+"</option>");
			});
		}
	});
	
	//取得楼宇编号列表，填充楼宇编号列表下拉框
	$.getJSON(host+"building/list/all",function(typeList){
		if(typeList){
			$.each(typeList,function(index,um){
				$("select#BuildingNoSelection").append("<option value='"+um.no+"'>"+um.name+"</option>");
			});
		}
	});
	
	//更新jQGrid的列表显示
	function reloadRoomList()
	{
		$("table#RoomGrid").jqGrid('setGridParam',{postData:{areano:areano,buildingtypeno:buildingtypeno,
		housetypeno:housetypeno,buildingno:buildingno}}).trigger("reloadGrid");
		
	};
	
	//定义小区下拉框的更新事件的处理
	$("select#AreaNoSelection").off().on("change",function(){
		areano=$("select#AreaNoSelection").val();
		reloadRoomList();
	});
	
	//定义建筑类型编号下拉框的更新事件的处理
	$("select#BuildingTypeNoSelection").off().on("change",function(){
		buildingtypeno=$("select#BuildingTypeNoSelection").val();
		reloadRoomList();
	});
	
	//定义户型编号下拉框的更新事件的处理
	$("select#HouseTypeNoSelection").off().on("change",function(){
		housetypeno=$("select#HouseTypeNoSelection").val();
		reloadRoomList();
	});
	
	//定义建筑编号下拉框的更新事件的处理
	$("select#BuildingNoSelection").off().on("change",function(){
		buildingno=$("select#BuildingNoSelection").val();
		reloadRoomList();
	});	
	
	
	
	
	
	
	
	
	
	//点击检索事件处理
	$("a#RoomSearchButton").on("click",function(){
		typeno=$("input[name='typeno']:checked").val();
		cname=$("input#CnameSelection").val();
		ccode=$("input#CcodeSelection").val();
		

     	reloadRoomList();
		
	});
	
	
	
	//===========================增加房间处理================================================
	
	
	
	$("a#RoomAddLink").off().on("click",function(){
		$("div#RoomDialog").load("room/add.html",function(){
			
			//验证提交的数据
			$("form#RoomAddForm").validate({
				  rules: {
				  	  ccode:{
				  		  required: true,
				  		  ccode: true
				  	  },
					  cname:{
					      required: true
					  },
					  cardcode:{
					      required: true,
					      cardcode: true
					  },
					  mobile:{
					      required: true,
					      mobile: true
					  },
					  feestartdate:{
					      required: true
					  },
					  feeenddate:{
					      required: true
					  },
					  cstatus:{
					      required: true
					  },
				  },
				  messages:{
				      ccode:{
				    	  required: "客户编码为空",
				      },
					  cname:{
					      required: "客户姓名为空",
					  },
					  cardcode:{
					      required: "身份证号为空",
					  },
					  mobile:{
					      required: "手机号码为空",
					  },
					  feestartdate:{
					      required: "收费开始日期为空",
					  },
					  feeenddate:{
					      required: "收费截止日期为空",
					  },
					  cstatus:{
					      required: "客户状态为空",
					  },

				 }
			});
			
			
			//添加客户弹窗
			$("div#RoomDialog").dialog({
				title:"房间增加",
				width:950
			});
			
			//拦截增加提交表单
			$("form#RoomAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					reloadRoomList();  //更新房间列表
				}
				//alert(result.message);
				//BootstrapDialog.alert(result.message);
				BootstrapDialog.show({
		            title: '房间操作信息',
		            message:result.message,
		            buttons: [{
		                label: '确定',
		                action: function(dialog) {
		                    dialog.close();
		                }
		            }]
		        });
				$("div#RoomDialog").dialog( "close" );
				$("div#RoomDialog").dialog( "destroy" );
				$("div#RoomDialog").html("");
				
			});

			
			//点击取消按钮，管理弹出窗口
			$("input[value='取消']").off().on("click",function(){
				$("div#RoomDialog").dialog( "close" );
				$("div#RoomDialog").dialog( "destroy" );
				$("div#RoomDialog").html("");
			});
			
		});
	});

	//===============================修改房间处理===============================================================
	
	$("a#RoomModifyLink").off().on("click",function(){
		//alert(customerno);
		if(roomno==0){
			BootstrapDialog.show({
	            title: '房间信息',
	            message:"请选择要修改的房间",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			$("div#RoomDialog").load("room/modify.html",function(){
				
				//验证修改的数据
				$("form#RoomModifyForm").validate({
					  rules: {
					  	  ccode:{
					  		  required: true,
					  		  ccode: true
					  	  },
						  cname:{
						      required: true
						  },
						  cardcode:{
						      required: true,
						      cardcode: true
						  },
						  mobile:{
						      required: true,
						      mobile: true
						  },
						  feestartdate:{
						      required: true
						  },
						  feeenddate:{
						      required: true
						  },
						  cstatus:{
						      required: true
						  },
					  },
					  messages:{
					      ccode:{
					    	  required: "客户编码为空",
					      },
						  cname:{
						      required: "客户姓名为空",
						  },
						  cardcode:{
						      required: "身份证号为空",
						  },
						  mobile:{
						      required: "手机号码为空",
						  },
						  feestartdate:{
						      required: "收费开始日期为空",
						  },
						  feeenddate:{
						      required: "收费截止日期为空",
						  },
						  cstatus:{
						      required: "客户状态为空",
						  },

					 }
				});
				
				//取得指定的房间信息
				$.getJSON("room/get",{roomno:roomno},function(em){
					if(em){
						$("input[name='customerno']").val(customerno);
						$("input[name='typeno']").val(em.customertype.typeno);
						$("input[name='ccode']").val(em.ccode);
						$("input[name='cname']").val(em.cname);
						$("input[name='cardcode']").val(em.cardcode);
						$("input[name='mobile']").val(em.mobile);
						$("input[name='feestartdate']").val(em.feestartdate);
						$("input[name='feeenddate']").val(em.feeenddate);
						$("input[name='cstatus']").val(em.cstatus);
	
					}
				});
				
				
				
				
				//弹出Dialog
				$("div#RoomDialog" ).dialog({
					title:"房间信息修改",
					width:800
				});
				
				//拦截修改提交表单
				$("form#RoomModifyForm").ajaxForm(function(result){
					if(result.status=="OK"){
						reloadCustomerList();  //更新房间列表
					}
					//alert(result.message);
					//BootstrapDialog.alert(result.message);
					BootstrapDialog.show({
			            title: '房间操作信息',
			            message:result.message,
			            buttons: [{
			                label: '确定',
			                action: function(dialog) {
			                    dialog.close();
			                }
			            }]
			        });
					$("div#RoomDialog").dialog( "close" );
					$("div#RoomDialog").dialog( "destroy" );
					$("div#RoomDialog").html("");
					
				});
	
				
				//点击取消按钮，管理弹出窗口
				$("input[value='取消']").off().on("click",function(){
					$("div#RoomDialog").dialog("close");
					$("div#RoomDialog").dialog("destroy")
					$("div#RoomDialog").html("");
				});
				
				
			});
		}
	});	
	
	//===============================删除房间处理=====================================

	$("a#RoomDeleteLink").off().on("click",function(){
		
		if(roomno==0){
			BootstrapDialog.show({
	            title: '房间操作信息',
	            message:"请选择要删除的房间",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else {
			BootstrapDialog.confirm('确认删除此房间?', function(result){
	            if(result) {
		            $.post("room/delete",{roomno:roomno},function(result){
		            	if(result.status=="OK"){
		            		reloadRoomList(); 
						}
						BootstrapDialog.show({
				            title: '房间操作信息',
				            message:result.message,
				            buttons: [{
				                label: '确定',
				                action: function(dialog) {
				                    dialog.close();
				                }
				            }]
				        });
		            });
	            }
			});
				
		}
	
	});

	//================================查看房间详细信息===================================

	$("a#RoomViewLink").off().on("click",function(){
		
		if(roomno==0){
			BootstrapDialog.show({
	            title: '房间操作信息',
	            message:"请选择要查看的房间",
            	buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			$("div#RoomDialog").load("room/view.html",function(){
				//alert(customerno);
				//取得选择的房间
				$.getJSON("customer/get",{roomno:roomno},function(data){
					if(data){
						$("span#customerno").html(customerno);
						$("span#typename").html(data.customertype.typename);
						$("span#ccode").html(data.ccode);
						$("span#cname").html(data.cname);
						$("span#cardcode").html(data.cardcode);
						$("span#mobile").html(data.mobile);
						$("span#feestartdate").html(data.feestartdate);
						$("span#feeenddate").html(data.feeenddate);
						$("span#cstatus").html(data.cstatus);
					}
				});
				//弹出Dialog
				$("div#RoomDialog" ).dialog({
					title:"房间详细信息",
					width:800
				});
				//点击取消按钮处理
				$("input[value='关闭']").on("click",function(){
					$("div#RoomDialog" ).dialog( "close" );
					$("div#RoomDialog" ).dialog( "destroy" );
					$("div#RoomDialog").html("");
				});

			});
			
		}
	});
	
	
	
});