/**
 * 客户前端主管理JS
 * 模块：baseinfo
 * 业务对象：客户
 * 作者陈思颖
 */

$(function(){
	var customerno=0;
	var typeno=0;
	var typename=null;
	//var customertype.typeno=0;
	var ccode=null;
	var cname=null;
	var cardcode=null;
	var mobile=null;
	var feestartdate=null;
	var feeenddate=null;
	var cstatus=null;
	var host="http://localhost:8100";
	//设置系统页面标题
	$("span#mainpagetille").html("客户档案管理");
	//设置日期的格式和选择
	
	//显示客户列表
	$("table#CustomerGrid").jqGrid({
		url: 'customer/list/condition/page',
		datatype: "json",
		colModel: [
			{ label: '客户类型', name: 'customertype.typename', width: 50 },
			{ label: '客户编码', name: 'ccode', width: 50 },
			{ label: '客户姓名', name: 'cname', width: 70 },
			{ label: '身份证号', name: 'cardcode', width: 70 },
			{ label: '手机号码', name: 'mobile', width: 70},
			{ label: '收费开始日期', name: 'feestartdate', width: 70 },
			{ label: '收费截止日期', name: 'feeenddate', width: 70 }  ,
			{ label: '客户状态', name: 'cstatus', width: 70 } 
		],
		caption:"客户列表",
		viewrecords: true, 
		autowidth: true,
		height: 300,
		rowNum: 10,
		rowList:[10,20,30],
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "customerno"},
		pager: "#CustomerGridPager",
		multiselect:false,
		onSelectRow:function(cno){
			customerno=cno;
		}
	});
	
	//更新jQGrid的列表显示
	function reloadCustomerList()
	{
		$("table#CustomerGrid").jqGrid('setGridParam',{postData:{typeno:typeno,ccode:ccode,cname:cname,cardcode:cardcode,
			mobile:mobile,feestartdate: feestartdate, feeenddate:feeenddate ,cstatus:cstatus}}).trigger("reloadGrid");
		
	}
	
	//定义选中客户类型单选按钮更新事件的处理
	$("input[name='typeno']").off().on("change",function(){
		typeno=$("input[name='typeno']:checked").val();
		reloadCustomerList();
	})
	
	//定义输入客户名称更新事件的处理
	$("input#CnameSelection").off().on("change",function(){
		cname=$("input#CnameSelection").val();
		reloadCustomerList();
	})
	
	//定义输入客户编码更新事件的处理
	$("input#CcodeSelection").off().on("change",function(){
		ccode=$("input#CcodeSelection").val();
		reloadCustomerList();
	})
	
	//点击检索事件处理
	$("a#CustomerSearchButton").on("click",function(){
		typeno=$("input[name='typeno']:checked").val();
		cname=$("input#CnameSelection").val();
		ccode=$("input#CcodeSelection").val();

     	reloadCustomerList();
		
	});
	
	
	
	//===========================增加客户处理================================================
	
	
	
	$("a#CustomerAddLink").off().on("click",function(){
		$("div#CustomerDialog").load("customer/add.html",function(){
			//取得客户类型列表，生成客户类型选择下拉框
//			$.getJSON(host+"customertype/list/all",function(typeList){
//				if(typeList){
//					$.each(typeList,function(index,ctypeno){
//						$("div#TypeSelection").append("<input type='checkbox' name='Customertypes' value='"+ctypeno.typeno+"' />"+ctypeno.typename);
//					});
//				}
//			});
//			dialogCustomer=$("div#CustomerDialog");
			
//			//验证员工提交数据
//			$("form#CustomerAddForm").validate({
//				  rules: {
//					  cname:{
//					      required: true
//					        },
//				  	  ccode:{
//				  		  required: true
//				  	  }
//				  },
//				  messages:{
//					  cname:{
//					      required: "请输入姓名",
//					      remote:"该客户已经存在"
//					  },
//				      ccode:{
//				    	  required: "客户编码为空",
//				      }
//				 }
//			});
			
			//拦截增加提交表单
			$("form#CustomerAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					reloadCustomerList();  //更新客户列表
				}
				//alert(result.message);
				//BootstrapDialog.alert(result.message);
				BootstrapDialog.show({
		            title: '客户操作信息',
		            message:result.message
		        });
				$("div#CustomerDialog").dialog( "close" );
				$("div#CustomerDialog").dialog( "destroy" );
				$("div#CustomerDialog").html("");
				
			});
			$("div#CustomerDialog").dialog({
				title:"客户增加",
				width:950
			});
			
			//点击取消按钮，管理弹出窗口
			$("input[value='取消']").off().on("click",function(){
				$("div#CustomerDialog").dialog( "close" );
				$("div#CustomerDialog").dialog( "destroy" );
				$("div#CustomerDialog").html("");
			});
			
		});
	});

	//===============================修改员工处理===============================================================
	
	$("a#CustomerModifyLink").off().on("click",function(){
		alert(customerno);
		if(customerno==null){
			BootstrapDialog.show({
	            title: '客户信息',
	            message:"请选择要修改的客户",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			$("div#CustomerDialog").load("customer/modify.html",function(){
				//取得指定的员工信息
				$.getJSON(host+"/customer/get",{customerno:customerno},function(em){
					if(em){
						$("input[name='typename']").html(em.customertype.typeno);
						$("input#cname").html(em.cname);
						$("input#cardcode").html(em.cardcode);
						$("input#mobile").html(em.mobile);
						$("input#feestartdate").html(em.feeStartDate);
						$("input#feeenddate").html(em.feeEndDate);
						$("input#cstatus").html(em.cstatus);
	
					}
				});
				$("div#CustomerDialog").dialog({
					title:"客户修改",
					width:800
				});
				//点击取消按钮，管理弹出窗口
				$("input[value='取消']").off().on("click",function(){
					$("div#CustomerDialog").dialog("close");
					$("div#CustomerDialog").dialog("destroy")
					$("div#CustomerDialog").html("");
				});
				
				
			});
		}
	});	
	
	
	
	
	
});