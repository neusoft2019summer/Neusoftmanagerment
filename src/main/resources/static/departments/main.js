/*
 * 部门管理js
 * 
 */

$(function(){
	var departmentNo=0; //选择的部门编号
	var departmentName="";
	//设置系统页面标题
	$("span#mainpagetille").html("部门管理");
	//取得部门的列表，分页模式
	$("table#DepartmentsGrid").jqGrid({
		url:'departments/list/condition/page',
		datatype:"json",
		colModel:[
			{label:'部门编号',name:'deptno',width:80},
			{label:'部门名称',name:'deptname',width:100},
			{label:'部门职责',name:'ddesc',width:120}
		],
		caption:"部门列表",
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
			id:"deptno"},//主属性名，model
		pager:"#DepartmentsGridPager",
		multiselect:false,
		onSelectRow:function(deptno){
			departmentNo=deptno;
			alert(deptno);
		}

	});
			
	
	//取得部门列表，填充部门下拉框
	$.getJSON("departments/list/all",function(departmentsList){
		if(departmentsList){
			$.each(departmentsList,function(index,dm){
				$("select#DeptnoSelection").append("<option value='"+dm.deptno+"'>"+dm.deptno+"</option>");
			});
		}
	});
	
	//取得下拉框
	$.getJSON(host+"departments/list/all",function(departmentsList){
		if(departmentsList){
			$.each(departmentsList,function(index,rm){
				$("select#DeptnameSelection").append("<option value='"+rm.deptname+"'>"+rm.deptname+"</option>");
			});
		}
	});
	
	//设置检索参数，更新jQGrid的列表显示
	function reloadDepList()
	{
		$("table#DepartmentsGrid").jqGrid('setGridParam',{
			postData:{departmentNo:departmentNo,
			departmentName:departmentName}}).trigger("reloadGrid");
	}
	
	//定义部门下拉框的更新事件的处理
	$("select#DeptnoSelection").off().on("change",function(){
		departmentNo=$("select#DeptnoSelection").val();
		reloadDepList();
	});
	
	//定义部门下拉框的更新事件的处理
	$("select#DeptnameSelection").off().on("change",function(){
		departmentName=$("select#DeptnameSelection").val();
		reloadDepList();
	});
	
	//点击检索事件处理
	$("a#DeptSearchButton").on("click",function(){
		departmentNo=$("select#DeptnoSelection").val();
		departmentName=$("select#DeptnameSelection").val();
		reloadDepList();
	});

/*//===========================增加处理================================================
	$("a#DepartmentsAddLink").off().on("click",function(){
		$("div#DepartmentDialogArea").load("departments/add.html",function(){
			//取得部门列表，并填充部门下拉框
			
			//取得角色列表，生成角色选择下拉框
			
			//验证提交数据
			$("form#DepartmentsAddForm").validate({
				  rules: {
				    no: {
				      required: true,
				      //remote: host+"departments/checkidexist"
				      
				    },
				    name:{
				    	required: true
				    },
				    desc:{
				    	required: true
				    }
				    	
				    }
				  },
				  messages:{
					id: {
					      required: "部门号为空",
					      //remote:"账号已经存在"
					    },
					name:{
					    	required:"部门名称为空"
					},
					desc:{
				    	required:"部门职责为空"
				}
				 }
			});
			//拦截增加提交表单
			$("form#DepartmentsAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					reloadDepList();//更新列表
				}
				//alert(result.message);
				//BootstrapDialog.alert(result.message);
				BootstrapDialog.show({
		            title: '部门操作信息',
		            message:result.message
		        });
				$("div#DepartmentDialogArea" ).dialog( "close" );
				$("div#DepartmentDialogArea" ).dialog( "destroy" );
				$("div#DepartmentDialogArea").html("");
				
			});
			
			
			$("div#DepartmentDialogArea").dialog({
				title:"部门增加",
				width:950
			});
			//点击取消按钮，管理弹出窗口
			$("input[value='取消']").off().on("click",function(){
				$("div#DepartmentDialogArea").dialog("close");
				$("div#DepartmentDialogArea").dialog("destroy")
				$("div#DepartmentDialogArea").html("");
			});
			
		});
	});	*/
});	
/*	//===============================修改处理===============================================================
	
	
	
	//===============================删除处理==============================================================
	
	
	
	//================================查看处理=============================================================
	$("a#DepartmentsViewLink").off().on("click",function(){
		if(deptNo==null){
			BootstrapDialog.show({
	            title: '部门操作信息',
	            message:"请选择要查看的部门",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			$("div#DepartmentDialogArea").load("departments/view.html",function(){
				//取得指定的部门信息
				$.getJSON("/departments/get",{id:departmentsId},function(em){
					if(em){
						$("span#deptNo").html(deptNo);
						$("span#deptName").html(em.name);
						$("span#deptDesc").html(em.desc);
					}
				});
				
				
				$("div#DepartmentDialogArea").dialog({
					title:"部门详细",
					width:800
				});
				//点击取消按钮，管理弹出窗口
				$("input[value='关闭']").off().on("click",function(){
					$("div#DepartmentDialogArea").dialog("close");
					$("div#DepartmentDialogArea").dialog("destroy")
					$("div#DepartmentDialogArea").html("");
				});
				
				
			});
		}
		
		
		
	});
	
	
	
	
});*/
