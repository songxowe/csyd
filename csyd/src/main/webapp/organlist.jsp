<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="commons/taglib.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>组织信息</title>
<%@ include file="commons/meta.jsp"%>
</head>
<body>
	<div style="margin: 10px 30px;">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add"
			onclick="organ_obj.showEdit('add')">添加</a>&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove"onclick="organ_obj.remove()">删除</a>&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit"   onclick="organ_obj.showEdit('edit')">修改</a>
		<!-- 新增组织信息窗口 -->
		<div id="editOrgan"></div>
		<div id="searchOrganForm" style="padding: 10px;">
			<div style="padding: 0 0 0 6px;">
				组织名: <input type="text" id="organName" class="easyui-textbox" /> <a
					href="#" class="easyui-linkbutton" iconCls="icon-search"
					onclick=organ_obj.search();>查询</a>
			</div>
		</div>
		<!-- 组织列表显示 -->
		<div style="margin-top: 20px;">
			<table id="organDataGrid">

			</table>

		</div>
	</div>
	<script type="text/javascript">
		$(function() {
	
			organ_obj = {
                search : function() {//查询
                    $("#organDataGrid").datagrid(
                        "load",
                        {
                            organName : $.trim($("#organName").val()),
                        });
                },
				remove : function() {
                    var rows = $("#organDataGrid").datagrid("getSelections");
                    if(rows.length > 0) {
                        $.messager.confirm("消息","确认真的要删除所选的数据吗",function(flag){
                            if(flag){
                                var ids = [];
                                for(var i=0;i<rows.length;i++){
                                    ids.push(rows[i].organId);
                                }
                                $.ajax({
                                    type : "post",
                                    url : "organController_remove.html",
                                    data : {
                                        ids : ids.join(","),
                                    },
                                    beforeSend : function(){
                                        $("#organDataGrid").datagrid("loading");
                                    },
                                    success : function(data){
                                        if(data) {
                                            $("#organDataGrid").datagrid("loaded");
                                            $("#organDataGrid").datagrid("load");
                                            $("#organDataGrid").datagrid("unselectAll");
                                            $.messager.show({
                                                title : "提示",
                                                msg : data + "个组织被删除"
                                            });
	
										}
									}
								});
							}
						});
					} else {
						$.messager.alert("警告", "请选中要删除的数据", "warning");
					}
	
				},
				showEdit : function(state) {
					var url = "organController_findById";
					var info = "";
					var id = 0;
					if (state == 'add') { //新增
						info = "新增组织信息";
					} else { //修改
						info = "修改组织信息";
						var rows = $("#organDataGrid").datagrid("getSelections");
						if (rows.length == 1) {
							id = rows[0].organId;
							url += "?organId=" + id;
						} else {
							$.messager.alert("警告", "必须选中一行", "warning");
							return;
						}
					}
					$("#editOrgan").window({
						title : info,
						width : 550,
						height : 480,
						modal : true,
						minimizable : false,
						href : url,
						onClose : function() {
							$("#organDataGrid").datagrid("reload");
						}
					});
				}
			}
	
	
	
			$("#organDataGrid").datagrid({

				url : "organController",
				title : "组织列表",
				fitColumns : true,
				striped : true,
				rownumbers : true,
				columns : [ [ {
					field : "organId",
					title : "序号",
					width : 100,
					sortable : true
				}, {
					field : "organHeigh",
					title : "上级组织",
					width : 100,
					sortable : true
				}, {
					field : "organName",
					title : "组织名称",
					width : 100,
					sortable : true
				}, {
					field : "organType",
					title : "组织类型",
					width : 100,
					sortable : true
				}, {
					field : "organLoc",
					title : "所属地区",
					width : 100,
					sortable : true
				}, {
					field : "organDir",
					title : "组织主管",
					width : 100,
					sortable : true
				}, {
					field : "organLinkman",
					title : "联系人",
					width : 100,
					sortable : true
				},{
						field : "organPhone",
						title : "联系人电话",
						width : 100,
						sortable : true
					},{
						field : "organExplain",
						title : "组织说明",
						width : 100,
						sortable : true
					}, {
						field : "op1",
						title : "操作",
						width : 100,
						formatter : function(value, rowData, rowIndex) {
							var organId = rowData["organId"];
							return "<a href='#' onclick=getOrgan(" + organId + ")>查看</a>"
						}
					} ] ],
				toolbar : "#searchOrganForm",
				pagination : true,
				pageSize : 5,
				pageList : [ 5, 10, 15, 20, 50 ],
				sortName : "organId",
				sortOrder : "asc",
			});
		});
		//查看指定菜单
		function getOrgan(organId) {

			$("#editOrgan").window({
				title : "查看组织详情",
				width : 550,
				height : 480,
				modal : true,
				minimizable : false,
				href : "organController_view.html?organId="+organId
			});
		}
	</script>
</body>
</html>