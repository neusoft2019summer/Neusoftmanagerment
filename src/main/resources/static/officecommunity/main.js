/**
 * 社区活动前端主管理JS
 * 模块：办公
 * 业务对象：社区活动
 * 作者:张梓琪
 * 
 */
$(function(){
	var officecommunityId = null;
	var activeno = 0;
	var activeplace = null;
	var startActiveDate = null;
	var endActiveDate = null;
	var activetype = null;
	var activecontent = null;
	
	//设置系统页面标题
	$("span#mainpagetille").html("社区活动管理");
	//设置日期的格式和选择
	
	//显示员工列表
	$("table#CommunityTable").jqGrid({
		url: 'community/list/condition/page',
		datatype: "json",
		colModel: [
			{ label: '编号', name: 'activeno', width: 20 },
			{ label: '活动时间', name: 'activetime', width: 50 },
			{ label: '活动地点', name: 'activeplace', width: 50 },
			{ label: '活动内容', name: 'activecontent', width: 100 },
			{ label: '活动类型', name: 'activetype', width: 50},
			
		],
		caption:"社区活动列表",
		viewrecords: true, 
		autowidth: true,
		height: 400,
		rowNum: 5,
		rowList:[10,20,30],
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "activeno"},
		pager: "#CommunityGridPager",
		multiselect:false,
		
		//选中点击事件
		onSelectRow:function(communityId){
			officecommunityId = communityId;
			alert(officecommunityId);
			
		}
	});
	
	
	//取得类型列表，填充类型下拉框
	$.getJSON("community/tolist",function(CommunityList){
		if(CommunityList){
			$.each(CommunityList,function(index,tm){
				$("select#TypeSelection").append("<option value='"+tm.activeno+"'>"+tm.activetype+"</option>");
			});
		}
	});
	//取得地点列表，填充类型下拉框
	$.getJSON("community/tolist",function(CommunityList){
		if(CommunityList){
			$.each(CommunityList,function(index,pm){
				$("select#PlaceSelection").append("<option value='"+pm.activeno+"'>"+pm.activeplace+"</option>");
			});
		}
	});
	
	//设置检索参数，更新jQGrid的列表显示
	function reloadCommunityList()
	{
		
		$("table#CommunityTable").jqGrid('setGridParam',{postData:{activeno:activeno,activeplace:activeplace,
			                                                       activetype:activetype,activecontent:activecontent,
			                                                       startActiveDate:startActiveDate,endActiveDate:endActiveDate}}).trigger("reloadGrid");
		
		
	}
	
	//定义部门下拉框的更新事件的处理
	$("select#TypeSelection").off().on("change",function(){
		activetype=$("select#TypeSelection").val();
		
		reloadCommunityList();
	});
	
	//定义部门下拉框的更新事件的处理
	$("select#PlaceSelection").off().on("change",function(){
		activeplace=$("select#PlaceSelection").val;
		
		reloadCommunityList();
	});
	
	
	
	
});