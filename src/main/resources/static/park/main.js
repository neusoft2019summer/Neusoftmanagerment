/**
 *  收费项目的前端控制JS
 * 作者：吕淑兰
 * 
 */
$(function(){
	var itemno=0;
	var unit=null;
	var feetypeNo=0;
	var cycle=null;
	var status=null;

	//设置系统页面标题
	$("span#mainpagetille").html("收费项目管理");
	//显示收费项目列表
	$("table#ParkGrid").jqGrid({
		url: 'park/list/condition/page',
		datatype: "json",
		colModel: [
			{ label: '收费项目编码', name: 'code', width: 50 },
			{ label: '收费项目名称', name: 'name', width: 50 },
			{ label: '收费单位', name: 'unit', width: 50 },
			{ label: '收费类型', name: 'feetype.no', width: 50 },
			{ label: '周期性', name: 'cycle', width: 50},
			{ label: '收费', name: 'status', width: 50 },
			{ label: '收费项目说明', name: 'desc', width: 50 } 
		],
		caption:"收费项目列表",
		viewrecords: true, //显示总记录数
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
		pager: "#ParkGridPager",
		multiselect:false,
		onSelectRow:function(ino){
			itemno=ino;
		}
		
	});
	//取得收费项目列表，填充收费单位下拉框
	$.getJSON("park/list/all",function(utilList){
		if(utilList){
			$.each(utilList,function(index,um){
				$("select#UtilSelection").append("<option value='"+um.util+"'>"+um.util+"</option>");
			});
		}
	});
	//取得收费项目列表，填充收费类型下拉框
	$.getJSON("parkType/list/all",function(List){
		if(List){
			$.each(List,function(index,dm){
				$("select#FeeTypeNoSelection").append("<option value='"+dm.no+"'>"+dm.name+"</option>");
			});
		}
	});
	//设置检索参数，更新jQGrid的列表显示
	function reloadParkList()
	{
		$("table#ParkGrid").jqGrid('setGridParam',{postData:{unit:unit,
			feetypeNo:feetypeNo,cycle:cycle,status:status}}).trigger("reloadGrid");
		
	}
	
	//定义收费项目下拉框的更新事件的处理
	$("select#UtilSelection").off().on("change",function(){
		util=$("select#UtilSelection").val();
		reloadParkList();
	});
	//定义收费类型下拉框的更新事件的处理
	$("select#FeeTypeNoSelection").off().on("change",function(){
		feetypeNo=$("select#FeeTypeNoSelection").val();
		reloadParkList();
	});
	
	//定义周期性的更新事件的处理
	$("input[name='cycle']").off().on("change",function(){
		cycle=$("input[name='cycle']").val();
		reloadParkList();
	});
	//定义收费的更新事件的处理
	$("input[name='status']").off().on("change",function(){
		status=$("input[name='status']").val();
		reloadParkList();
	});

	
	//点击检索事件处理
	$("a#ParkSearchButton").on("click",function(){
		util=$("select#UtilSelection").val();
		cycle=$("input[name='cycle']").val();
		cycle=$("input[name='cycle']").val();
		status=$("input[name='status']").val();
		reloadParkList();
	});
	
	
	//===========================增加收费项目处理================================================
	$("a#ParkAddLink").off().on("click",function(){
		$("div#ParkDialogPark").load("Park/add.html",function(){
			//验证提交数据
			$("form#ParkAddForm").validate({
				rules: {
					name: {
						required: true
					},
					address: {
						required: true
					},
					developer: {
						required: true
					},
					buildingPark: {
						required: true,
						min:0
					},
					usePark: {
						required: true,
						min:0
					},
					
					parkPark: {
						required: true,
						min:0
					},
					home: {
						required: true
					},
					house: {
						required: true
					},
					park: {
						required: true
					}
				},
				message:{
					name: {
						required: "收费项目名称为空"
					},
					address: {
						required: "收费项目地址为空"
					},
					developer: {
						required: "开发商为空"
					},
					buildingPark: {
						number: "总建筑面积必须是数值",
				    	range: "大于0"
					},
					usePark: {
						number: "总使用面积必须是数值",
				    	range: "小于总建筑面积"
					},
					
					parkPark: {
						number: "车位面积必须是数值",
				    	range: "小于总建筑面积"
					},
					home: {
						number: "总居民数必须是数值",
				    	range: "大于等于0"
					},
					house: {
						number: "总公建数必须是数值",
				    	range: "大于等于0"
					},
					park: {
						number: "车位数必须是数值",
				    	range: "大于等于0"
					}
				}
			});
			//增加收费项目的弹窗
			$("div#ParkDialogPark").dialog({
				title:"增加收费项目",
				width:900
			});
			
			//拦截增加提交表单
			$("form#ParkAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					reloadParkList(); //更新收费项目列表
				}
				//alert(result.message);
				//BootstrapDialog.alert(result.message);
				BootstrapDialog.show({
		            title: '收费项目操作信息',
		            message:result.message,
		            buttons: [{
		                label: '确定',
		                action: function(dialog) {
		                    dialog.close();
		                }
		            }]
		        });
				$("div#ParkDialogPark" ).dialog( "close" );
				$("div#ParkDialogPark" ).dialog( "destroy" );
				$("div#ParkDialogPark").html("");
				
			});
			
			//点击取消按钮处理
			$("input[value='取消']").on("click",function(){
				$("div#ParkDialogPark" ).dialog( "close" );
				$("div#ParkDialogPark" ).dialog( "destroy" );
				$("div#ParkDialogPark").html("");
			});
		});
	});
	
	
	//===============================修改收费项目处理=============================
	

	//===============================删除收费项目处理=====================================



	//================================查看收费项目处理====================================

	$("a#ParkViewLink").off().on("click",function(){
		
		if(Parkno==0){
			BootstrapDialog.show({
	            title: '收费项目操作信息',
	            message:"请选择要查看的收费项目",
            	buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			$("div#ParkDialogPark").load("Park/view.html",function(){
				//取得选择的收费项目
				$.getJSON("Park/get",{no:Parkno},function(Park){
					if(Park){
						$("input#no").val(Parkno);
						
						alert(Park.name);
						$("input#name").val(Park.name);
						$("input#address").val(Park.address);
						$("input#developer").val(Park.developer);
						$("input#buildingPark").val(Park.buildingPark);
						$("input#usePark").val(Park.usePark);
						$("input#parkPark").val(Park.parkPark);
						$("input#home").val(Park.home);
						$("input#house").val(Park.house);
						$("input#park").val(Park.park);
						
					}
				});
				//弹出Dialog
				$("div#ParkDialogArea" ).dialog({
					title:"收费项目详细",
					width:800
				});
				//点击取消按钮处理
				$("input[value='关闭']").on("click",function(){
					$("div#ParkDialogArea" ).dialog( "close" );
					$("div#ParkDialogArea" ).dialog( "destroy" );
					$("div#ParkDialogArea").html("");
				});

			});
			
		}
	});
	

});