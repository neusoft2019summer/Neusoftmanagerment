
$(function(){
	var rows=5;
	var page=1;
	var pageCount=0; 
	var newsno=0;
	//设置系统页面标题
	
	
	function getListInfo(){
	//嵌入列表页面
		
		//操作列表的方法 
		//取得新闻的列表，分页模式
		
			$.getJSON("news/list/all/page",{page:page,rows:rows},function(data){
				//显示个数和页数
				$("span#count").html(data.count);
				$("span#pagecount").html(data.page+"/"+data.pageCount);
				pageCount=data.pageCount;
				//显示列表
				$("table#NewsTable tbody").html("");
				for(var i=0;i<data.list.length;i++){
					var tr="<tr id='"+data.list[i].newsno+"'><td>"+data.list[i].newstype+"</td><td>"+data.list[i].newscontent+"</td><td>"+data.list[i].newstime+"</td></tr>";
					$("table#NewsTable tbody").append(tr);
				}
				//定义表格行的点击事件，取得选择的新闻编号
				$("table#NewsTable tbody tr").on("click",function(){
					newsno=$(this).attr("id");
					/*alert(newsno);*/
					$("table#NewsTable tbody tr").css("background-color","#FFFFFF");
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
		
		//增加点击链接处理 弹出对话框
		$("a#NewsAddLink").off().on("click",function(event){
			
			$("div#NewsDailogArea").load("office/add.html",function(){
				$("div#NewsDailogArea").dialog({
					title:"增加新闻",
					width:600
				});
				//提交按钮
				$("form#NewsAddForm").ajaxForm(function(result){
					if(result.status=="ok"){
						getListInfo();
					}
					//alert(result.message);
					//弹出提示增加成功
					BootstrapDialog.show({
			            title: '新闻管理操作信息',
			            message:result.message
			        });
					$( "div#NewsDailogArea" ).dialog( "close" );
					$( "div#NewsDailogArea" ).dialog( "destroy" );
					$( "div#NewsDailogArea" ).html("");
					
					getListInfo();
				});
				
			    //取消按钮
				$("input[value='取消']").on("click",function(){
					$( "div#NewsDailogArea" ).dialog( "close" );
					$( "div#NewsDailogArea" ).dialog( "destroy" );
					$( "div#NewsDailogArea" ).html("");
					
				});
				
				
			});
			
			
		});
		
		//修改点击链接处理 弹出对话框
		
		$("a#NewsModifyLink").off().on("click",function(event){
		if(newsno==0){
				//弹出提示没有选中要修改的新闻
				BootstrapDialog.show({
		            title: '新闻管理操作信息',
		            message:"请选择要修改的新闻"
		        });
				
			}
			else{
				$("div#NewsDailogArea").load("office/modify.html",function(){
					//取得选择的部门
					//回添
					$.getJSON("news/get",{newsno:newsno},function(data){
						if(data.status=="ok"){
							$("input[name='newsno']").val(newsno);
							$("input[name='newstype']").val(data.model.newstype);
							$("input[name='newstime']").val(data.model.newstime);
							$("input[name='newscontent']").val(data.model.newscontent);
							
						}
					});
						
					$("div#NewsDailogArea").dialog({
						title:"修改新闻",
						width:600
					});
					//提交表单
					$("form#NewsModifyForm").ajaxForm(function(result){
						if(result.status=="ok"){
							getListInfo();
						}else{
							alert("失败")
						}
						//alert(result.message);
						//弹出提示增加成功
						BootstrapDialog.show({
				            title: '新闻管理操作信息',
				            message:result.message
				        });
						$( "div#NewsDailogArea" ).dialog( "close" );
						$( "div#NewsDailogArea" ).dialog( "destroy" );
						$( "div#NewsDailogArea" ).html("");
						
						getListInfo();
					});
					
				    //取消按钮
					$("input[value='取消']").on("click",function(){
						$( "div#NewsDailogArea" ).dialog( "close" );
						$( "div#NewsDailogArea" ).dialog( "destroy" );
						$( "div#NewsDailogArea" ).html("");
						
					});
				});
				
			}
			
			
			
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
	
});