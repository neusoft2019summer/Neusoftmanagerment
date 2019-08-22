/**
 *  收费项目的前端控制JS
 * 作者：吕淑兰
 * 
 */
$(function(){
	var itemNo=0;
	var minunitprice=null;
	var maxunitprice=null;
	var startDate=null;
	var endDate=null;
	var feeyear=null;

	//设置系统页面标题
	$("span#mainpagetille").html("年度价格管理");
	//显示收费项目列表
	$("table#YearPriceGrid").jqGrid({
		url: host+'yearPrice/list/condition/page',
		datatype: "json",
		colModel: [
			{ label: '收费年度', name: 'feeyear', width: 50 },
			{ label: '收费项目', name: 'item', width: 50 },
			{ label: '单价', name: 'unitprice', width: 50 },
			{ label: '开始日期', name: 'startDate', width: 50 },
			{ label: '结束日期', name: 'endDate', width: 50},
			{ label: '描述', name: 'pricedesc', width: 50 }
		],
		caption:"收费项目列表",
		viewrecords: true, //显示总记录数
		autowidth: true,
		height: 400,
		rowNum: 10,
		rowList:[5,6,7,8,9,10],
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "feeyear"},
		pager: "#YearPriceGridPager",
		multiselect:false,
		onSelectRow:function(fno){
			feeyear=fno;
		}
		
	});
	//取得年度价格列表，填充收费项目下拉框
	$.getJSON("feeItem/list/condition/page",function(List){
		if(List){
			$.each(List,function(index,um){
				$("select#FeeitemSelection").append("<option value='"+um.no+"'>"+um.name+"</option>");
			});
		}
	});
	//设置检索参数，更新jQGrid的列表显示
	function reloadYearPriceList()
	{
		$("table#YearPriceGrid").jqGrid('setGridParam',{postData:{itemNo:itemNo,
			minunitprice:minunitprice,maxunitprice:maxunitprice,startDate:startDate,endDate:endDate}}).trigger("reloadGrid");
		
	}
	
	//定义收费项目下拉框的更新事件的处理
	$("select#FeeitemSelection").off().on("change",function(){
		itemNo=$("select#FeeitemSelection").val();
		reloadYearPriceList();
	});
	
	//定义的更新事件的处理
	$("input#minunitprice").off().on("change",function(){
		minunitprice=$("input#minunitprice").val();
		reloadYearPriceList();
	});
	$("input#maxunitprice").off().on("change",function(){
		maxunitprice=$("input#maxunitprice").val();
		reloadYearPriceList();
	});

	//定义的更新事件的处理
	$("input#startDate").off().on("change",function(){
		startDate=$("input#startDate").val();
		reloadYearPriceList();
	});
	$("input#endDate").off().on("change",function(){
		endDate=$("input#endDate").val();
		reloadYearPriceList();
	});

	
/*	//点击检索事件处理
	$("a#YearPriceSearchButton").on("click",function(){
		util=$("select#UtilSelection").val();
		feetypeNo=$("select#FeeTypeNoSelection").val();
		cycle=$("input[name='cycle']:checked").val();
		status=$("input[name='itemStatus']:checked").val();
		reloadYearPriceList();
	});*/
	
/*	
	//===========================增加收费项目处理================================================
	$("a#YearPriceAddLink").off().on("click",function(){
		//取得收费项目列表，填充收费类型下拉框
		$.getJSON(host+"feeType/list/all",function(List){
			if(List){
				$.each(List,function(index,feetype){
					$("select#FeeTypeNoSelection").append("<option value='"+feetype.no+"'>"+feetype.name+"</option>");
				});
			}
		});
		$("div#YearPriceDialogArea").load("feeItem/add.html",function(){
			//验证提交数据
			$("form#YearPriceAddForm").validate({
				rules: {
					code: {
						required: true
					},
					name: {
						required: true
					},
					unit: {
						required: true
					},
					feetype: {
						required: true
					},
					cycle: {
						required: true
					},
					status: {
						required: true
					}
				},
				message:{
					code: {
						required: "收费项目编码为空"
					},
					name: {
						required: "收费项目名称为空"
					},
					unit: {
						required: "收费单位为空"
					},
					feetype: {
						required: "收费类型为空"
					},
					cycle: {
						required: "周 期性为空"
					},
					status: {
						required: "收费为空"
					}
				}
			});
			//增加收费项目的弹窗
			$("div#YearPriceDialogArea").dialog({
				title:"增加收费项目",
				width:600
			});
			
			//拦截增加提交表单
			$("form#YearPriceAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					reloadYearPriceList(); //更新收费项目列表
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
				$("div#YearPriceDialogArea" ).dialog( "close" );
				$("div#YearPriceDialogArea" ).dialog( "destroy" );
				$("div#YearPriceDialogArea").html("");
				
			});
			
			//点击取消按钮处理
			$("input[value='取消']").on("click",function(){
				$("div#YearPriceDialogArea" ).dialog( "close" );
				$("div#YearPriceDialogArea" ).dialog( "destroy" );
				$("div#YearPriceDialogArea").html("");
			});
		});
	});
	
	
	//===============================修改收费项目处理=============================
	$("a#YearPriceModifyLink").off().on("click",function(){
		//取得收费项目列表，填充收费类型下拉框
		$.getJSON(host+"feeType/list/all",function(List){
			if(List){
				$.each(List,function(index,feetype){
					$("select#FeeTypeNoSelection").append("<option value='"+feetype.no+"'>"+feetype.name+"</option>");
				});
			}
		});
		if(itemno==0){
			BootstrapDialog.show({
	            title: '收费项目操作信息',
	            message:"请选择要修改的收费项目",
            	buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			$("div#YearPriceDialogArea").load("feeItem/modify.html",function(){
				//取得选择的收费项目
				$.getJSON(host+"feeItem/get",{no:itemno},function(YearPrice){
					
					if(YearPrice){
						//alert(itemno);
						$("input[name='no']").val(itemno);
						$("input[name='code']").val(YearPrice.code);
						$("input[name='name']").val(YearPrice.name);
						$("input[name='unit']:checked").val(YearPrice.unit);
						$("select[name='feetype.no']").val(YearPrice.feetype.no);
						$("input[name='cycle']:checked").val(YearPrice.cycle);
						$("input[name='status']:checked").val(YearPrice.status);
						$("input[name='desc']").val(YearPrice.desc);
						
					}
				});
				//弹出Dialog
				$("div#YearPriceDialogArea").dialog({
					title:"收费项目修改",
					width:600
				});
				$("form#YearPriceModifyForm").ajaxForm(function(result){
					if(result.status=="OK"){
						reloadYearPriceList(); //更新收费项目列表
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
					$("div#YearPriceDialogArea" ).dialog( "close" );
					$("div#YearPriceDialogArea" ).dialog( "destroy" );
					$("div#YearPriceDialogArea").html("");
					
				});
				
				
				//点击取消按钮处理
				$("input[value='取消']").on("click",function(){
					$("div#YearPriceDialogArea" ).dialog( "close" );
					$("div#YearPriceDialogArea" ).dialog( "destroy" );
					$("div#YearPriceDialogArea").html("");
				});

			});
			
		}
	});


	//===============================删除收费项目处理=====================================

	$("a#YearPriceDeleteLink").off().on("click",function(){
		
		if(itemno==0){
			BootstrapDialog.show({
	            title: '收费项目操作信息',
	            message:"请选择要删除的收费项目",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else {
			BootstrapDialog.confirm('确认删除此收费项目么?', function(result){
	            if(result) {
		            $.post("feeItem/delete",{no:itemno},function(result){
		            	if(result.status=="OK"){
		            		reloadYearPriceList(); //更新收费项目列表
						}
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
		            });
	            }
			});
				
		}
	
	});



	//================================查看收费项目处理====================================

	$("a#YearPriceViewLink").off().on("click",function(){
		
		if(itemno==0){
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
			$("div#YearPriceDialogArea").load("feeItem/view.html",function(){
				//取得选择的收费项目
				$.getJSON(host+"feeItem/get",{no:itemno},function(YearPrice){
					
					if(YearPrice){
						//alert(itemno);
						$("span#code").html(YearPrice.code);
						$("span#name").html(YearPrice.name);
						$("span#unit").html(YearPrice.unit);
						$("span#feetype").html(YearPrice.feetype.no+"("+YearPrice.feetype.name+")");
						$("span#cycle").html(YearPrice.cycle);
						$("span#status").html(YearPrice.status);
						$("span#desc").html(YearPrice.desc);
						
					}
				});
				//弹出Dialog
				$("div#YearPriceDialogArea").dialog({
					title:"收费项目详细",
					width:600
				});
				//点击取消按钮处理
				$("input[value='关闭']").on("click",function(){
					$("div#YearPriceDialogArea").dialog( "close" );
					$("div#YearPriceDialogArea").dialog( "destroy" );
					$("div#YearPriceDialogArea").html("");
				});

			});
			
		}
	});
	
*/
});