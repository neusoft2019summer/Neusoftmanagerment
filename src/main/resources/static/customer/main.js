/**
 * 客户前端主管理JS
 * 模块：baseinfo
 * 业务对象：客户
 * 作者陈思颖
 */

$(function(){
	var customerno=0;
	var typeno=0;
	var ccode=null;
	var cname=null;
	var cardcode=null;
	var mobile=null;
	var feestartdate=null;
	var feeenddate=null;
	var cstatus=null;
	//设置系统页面标题
	$("span#mainpagetille").html("客户档案管理");
	//设置日期的格式和选择
	
	//显示客户列表
	$("table#CustomerGrid").jqGrid({
		url: 'customer/list/all/page',
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
	
	//取得客户列表，填充部门下拉框
	$.getJSON("customer/list/all",function(customerList){
		if(customerList){
			$.each(customerList,function(index,dm){
				$("select#CustomerSelection").append("<option value='"+dm.no+"'>"+dm.name+"</option>");
			});
		}
	});
	
	//取得客户列表，填充客户类型下拉框
	$.getJSON("customer/list/all",function(customerList){
		if(customerList){
			$.each(customerList,function(index,cm){
				$("select#TypeNameSelection").append("<option value='"+cm.no+"'>"+cm.typename+"</option>");
			});
		}
	});
	
	//更新jQGrid的列表显示
	function reloadCustomerList()
	{
		$("table#CustomerGrid").jqGrid('setGridParam',{postData:{typeno:typeno,ccode:ccode,cname:cname,cardcode:cardcode,
			mobile:mobile,feestartdate: feestartdate, feeenddate:feeenddate ,cstatus:cstatus}}).trigger("reloadGrid");
		
	}
	
	//点击检索事件处理
	$("a#CustomerSearchButton").on("click",function(){
		typeno=$("input[name='typename']:checked").val();
		cname=$("input#CnameSelection").val();
		cardcode=$("input#CcodeSelection").val();
		
	reloadCustomerList();
	});
	
	
});