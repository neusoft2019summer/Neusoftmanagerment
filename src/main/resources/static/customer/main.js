/**
 * 部门的前端控制JS
 * 作者：吕海东
 * 
 */
$(function(){
	var rows=5;
	var page=1;
	var pageCount=0;
	var customerno=0; //选择的客户序号
	
	//设置系统页面标题
	$("span#mainpagetille").html("客户管理");
	//取得客户的列表，分页模式
	function getListInfo(){
		//调用后台取得客户列表REST API
		$.getJSON("customer/list/all/page",{page:page,rows:rows},function(data){
				//显示个数和页数
				$("span#count").html(data.count);
				$("span#pagecount").html(data.page+"/"+data.pageCount);
				pageCount=data.pageCount;
				//显示列表
				$("table#CustomerTable tbody").html("");
				for(var i=0;i<data.list.length;i++){
					var tr="<tr><td>"+data.list[i].customerno+
						   "</td><td>"+data.list[i].customertype.typeno+
						   "</td><td>"+data.list[i].ccode+
						   "</td><td>"+data.list[i].cname+
					       "</td><td>"+data.list[i].cardcode+
					       "</td><td>"+data.list[i].mobile+
					       "</td><td>"+data.list[i].feestartdate+
					       "</td><td>"+data.list[i].feeenddate+
					       "</td><td>"+data.list[i].cstatus+
					       "</td></tr>";
					$("table#CustomerTable tbody").append(tr);
				}
				//定义表格行的点击时间，取得选择的客户
				$("table#CustomerTable tbody tr").on("click",function(){
					customerno=$(this).attr("CustomerNo");
					$("table#CustomerTable tbody tr").css("background-color","#FFFFFF");
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
	//点击增加链接处理，嵌入add.html
	$("a#CustomerAddLink").off().on("click",function(event){
				
		$("div#CustomerDialogArea").load("customer/add.html",function(){
			$("div#CustomerDialogArea" ).dialog({
				title:"增加客户",
				width:600
			});
			
			$("form#CustomerAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					getListInfo(); 
				}
				//alert(result.message);
				//BootstrapDialog.alert(result.message);
				BootstrapDialog.show({
		            title: '客户操作信息',
		            message:result.message
		        });
				$("div#CustomerDialogArea" ).dialog( "close" );
				$("div#CustomerDialogArea" ).dialog( "destroy" );
				$("div#CustomerDialogArea").html("");
				
			});
			//点击取消按钮处理
			$("input[value='取消']").on("click",function(){
				$( "div#CustomerDialogArea" ).dialog( "close" );
				$( "div#CustomerDialogArea" ).dialog( "destroy" );
				$( "div#CustomerDialogArea").html("");
			});
		});
		
	});
	
	//点击修改按钮事件处理
	$("a#CustomerModifyLink").off().on("click",function(event){
		if(customerno==0){
			BootstrapDialog.show({
	            title: '客户操作信息',
	            message:"请选择要修改信息的客户"
	        });
		}
		else {
			$("div#CustomerDialogArea").load("customer/modify.html",function(){
				//取得选择的客户
				$.getJSON("Customer/get",{no:customerno},function(data){
					if(data.status=="OK"){
						$("input[name='customerno']").val(customerno);
						$("input[name='typeno']").val(data.model.typeno);
						$("input[name='ccode']").val(data.model.ccode);
						$("input[name='cname']").val(data.model.cname);
						$("input[name='cardcode']").val(data.model.cardcode);
						$("input[name='mobile']").val(data.model.mobile);
						$("input[name='feestartdate']").val(data.model.feestartdate);
						$("input[name='feeenddate']").val(data.model.feeenddate);
						$("input[name='cstatus']").val(data.model.cstatus);
						
					}
				});
				
				$("div#CustomerDialogArea" ).dialog({
					title:"修改客户信息",
					width:600
				});
				//拦截表单提交
				$("form#CustomerModifyForm").ajaxForm(function(result){
					if(result.status=="OK"){
						getListInfo(); 
					}
					//alert(result.message);
					//BootstrapDialog.alert(result.message);
					BootstrapDialog.show({
			            title: '客户操作信息',
			            message:result.message
			        });
					$("div#CustomerDialogArea" ).dialog( "close" );
					$("div#CustomerDialogArea" ).dialog( "destroy" );
					$("div#CustomerDialogArea").html("");

	});
				//点击取消按钮处理
				$("input[value='取消']").on("click",function(){
					$( "div#CustomerDialogArea" ).dialog( "close" );
					$( "div#CustomerDialogArea" ).dialog( "destroy" );
					$( "div#CustomerDialogArea").html("");
				});	
			});
			
		}
		
		
	});			
				
				
				
	
	//点击删除按钮事件处理
	$("a#CustomerDelteLink").off().on("click",function(event){
	
	});
	
	
	//点击查看详细按钮事件处理
	$("a#CustomerViewLink").off().on("click",function(event){
		
		if(customerNo==0){
			BootstrapDialog.show({
	            title: '客户操作信息',
	            message:"请选择要查看的客户"
	        });
		}
		else{
			$("div#CustomerDialogArea").load("customer/view.html",function(){
				//取得选择的部门
				$.getJSON("customer/get",{no:customerNo},function(data){
					if(data.status=="OK"){
						$("span#customerTypeNo").html(data.model.customerno);
						$("span#customerTypeNo").html(data.model.typeno);
						$("span#customerCcode").html(data.model.ccode);
						$("span#customerCname").html(data.model.cname);
						$("span#customerCardCode").html(data.model.cardcode);
						$("span#customerMobile").html(data.model.mobile);
						$("span#customerFeeStartDate").html(data.model.feestartdate);
						$("span#customerFeeEndDate").html(data.model.feeenddate);
						$("span#customerCstatus").html(data.model.cstatus);
						
					}
				});
				//弹出Dialog
				$("div#CustomerDialogArea" ).dialog({
					title:"部门详细",
					width:600
				});
				//点击取消按钮处理
				$("input[value='返回']").on("click",function(){
					$( "div#CustomerDialogArea" ).dialog( "close" );
					$( "div#CustomerDialogArea" ).dialog( "destroy" );
					$( "div#CustomerDialogArea").html("");
				});
			});
			
		}
	});
	

});