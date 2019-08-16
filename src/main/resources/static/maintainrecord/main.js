
$(function(){
	var rows=2;
	var page=1;
	var pageCount=0; 

	//嵌入列表页面
	$("div#maintainrecordcontent").load("maintainrecord/list.html",function(){
		//操作列表的方法 
		//取得保修单的列表，分页模式
		function getListInfo(){
			$.getJSON("maintainrecord/list/all/page",{page:page,rows:rows},function(data){
				//显示个数和页数
				$("span#count").html(data.count);
				$("span#pagecount").html(data.page+"/"+data.pageCount);
				pageCount=data.pageCount;
				//显示列表
				$("table#MaintainRecordTypeTable tbody").html("");
				for(var i=0;i<data.list.length;i++){
					var tr="<tr><td>"+data.list[i].recordno+"</td><td>"+data.list[i].mtype.mtypeno+"</td>" +
							"<td>"+data.list[i].room.roomno+"</td><td>"+data.list[i].contactname+"</td>" +
									"<td>"+data.list[i].mobile+"</td><td>"+data.list[i].tel+"</td>" +
											"<td>"+data.list[i].mdate+"</td><td>"+data.list[i].mdesc+"</td>" +
													"<td>"+data.list[i].wemp.wempid+"</td><td>"+data.list[i].wdate+"</td>" +
															"<td>"+data.list[i].wtask+"</td><td>"+data.list[i].wresult+"</td>" +
																	"<td>"+data.list[i].wstatus+"</td><td>"+data.list[i].wfee+"</td>" +
																			"<td>"+data.list[i].provider.providerno+"</td><td>"+data.list[i].clientfeeback+"</td></tr>";
					$("table#MaintainRecordTypeTable tbody").append(tr);
				}
		
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
	});
	
});