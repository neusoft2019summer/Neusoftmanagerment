/**
 * 新闻管理前端主管理JS
 * 模块：办公
 * 业务对象：新闻管理
 * 作者:张梓琪
 * 
 */
$(function(){
	var officenewsId = null;
	
	//设置系统页面标题
	$("span#mainpagetille").html("新闻管理");
	//设置日期的格式和选择
	
	//显示员工列表
	$("table#NewsTable").jqGrid({
		url: 'news/list/all/page',
		datatype: "json",
		colModel: [
			{ label: '编号', name: 'newsno', width: 20 },
			{ label: '新闻类型', name: 'newstype', width: 50 },
			{ label: '新闻事件', name: 'newstime', width: 50 },
			{ label: '新闻内容', name: 'newscontent', width: 100 },
		],
		caption:"新闻列表",
		viewrecords: true, 
		autowidth: true,
		height: 400,
		rowNum: 20,
		rowList:[10,20,30],
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "newsno"},
		pager: "#Newspager",
		multiselect:false,
		//选中点击事件
		onSelectRow:function(newsId){
			officenewsId = newsId;
			alert(officenewsId);
			
		}
		
	});
	
	//取得类型列表，填充类型下拉框
	$.getJSON("news/tolist",function(NewsList){
		if(NewsList){
			$.each(NewsList,function(index,nm){
				$("select#NewsSelection").append("<option value='"+nm.newsno+"'>"+nm.newstype+"</option>");
			});
		}
	});
	
	
	
});