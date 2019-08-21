//员工管理js
$(function(){
	var departmentNo=0;
	var id=0;
	var sex="";
	var mobile="";
	var startJoinDate=null;
	var endJoinDate=null;
	var minSal=0;
	var maxSal=0;
	$("span#mainpagetille").html("员工信息管理");
	
	//取得员工列表，分页模式
	$("table#EmployeesGrid").jqGrid({
		url:host+'employees/list/condition/page',
		datatype:"json",
		colModel:[
			{label:'员工编号',name:'id',width:20},
			{label:'部门名称',name:'departments.deptname',width:30},
			{label:'员工姓名',name:'empname',width:40},
			{label:'入职日期',name:'joindate',width:40},
			{label:'性别',name:'sex',width:20},
			{label:'年龄',name:'age',width:20},
			{label:'手机号码',name:'mobile',width:40},
			{label:'微信',name:'wx',width:40},
			{label:'邮箱',name:'mail',width:40},
			{label:'薪资',name:'salary',width:20}
		],
		caption:"员工信息列表",
		viewrecords:true,
		autowidth:true,
		height:200,
		rowNum:5,
		rowList:[5,10,15],
		jsonReader:{
			root:"list",//返回格式
			page:"page",//页号
			total:"pageCount",//页数
			records:"count",//总个数
			id:"id"},//主属性名，model
		pager:"#EmployeesGridPager",
		multiselect:false,
		onSelectRow:function(empid){
			id=empid;
		}
	});
	
	//取得部门列表下拉框
	$.getJSON(host+"departments/list/all",function(departmentsList){
		if(departmentsList){
			$.each(departmentsList,function(index,dm){
				$("select#DeptnoSelection").append("<option value='"+dm.deptno+"'>"+dm.deptname+"</option>");
			});
		}
	});
	//取得员工名称下拉框
	$.getJSON(host+"employees/list/all",function(empList){
		if(empList){
			$.each(empList,function(index,em){
				$("select#EmpSelection").append("<option value='"+em.id+"'>"+em.empname+"</option>");
			});
		}
	});
	
	//更新JQGrid的列表显示
	function reloadEmpList(){
		
		$("table#EmployeesGrid").jqGrid('setGridParam',{postData:{departmentNo:departmentNo,
			id:id,sex:sex,mobile:mobile,startJoinDate:startJoinDate,endJoinDate:endJoinDate,
			minSal:minSal,maxSal:maxSal}}).trigger("reloadGrid");
	}
	//部门下拉框的更新事件
	$("select#DeptnoSelection").off().on("change",function(){
		departmentNo=$("select#DeptnoSelection").val();
		alert(departmentNo);
		reloadEmpList();
	});
	//员工下拉框的更新事件
	$("select#EmpSelection").off().on("change",function(){
		id=$("select#EmpSelection").val();
		reloadEmpList();
	});
	//定义性别单选按钮更改事件
	$("input[name='sex']").off().on("change",function(){
		sex=$("input[name='sex']:checked").val();
		reloadEmpList();
	});
	//点击检索事件处理
	$("a#EmpSearchButton").on("click",function(){
		departmentNo=$("select#DeptnoSelection").val();
		id=$("select#EmpSelection").val();
		sex=$("input[name='sex']:checked").val();
		mobile=$("input#mobile").val();
		startJoinDate=$("input#startJoinDate").val();
		endJoinDate=$("input#endJoinDate").val();
		minSal=$("input#minSal").val();
		maxSal=$("input#maxSal").val();
		if(startJoinDate==""){
			startJoinDate=null;
		}
		if(endJoinDate==""){
			endJoinDate=null;
		}
		reloadEmpList();
	});
	
	
	
	
	
	
	
});