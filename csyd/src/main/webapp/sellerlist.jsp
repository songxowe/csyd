<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="commons/taglib.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>我的直销员信息</title>
<%@ include file="commons/meta.jsp"%>
</head>
<body>
	<div style="margin: 10px 30px;">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add"
			onclick="seller_obj.showEdit('add')">添加</a>&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove"onclick="seller_obj.remove()">删除</a>&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit"   onclick="seller_obj.showEdit('edit')">修改</a>
		<!-- 新增组织信息窗口 -->
		<div id="editSeller"></div>
		<div id="searchSellerForm" style="padding: 10px;">
			<div style="padding: 0 0 0 6px;">
				直销员姓名: <input type="text" id="sellerName" class="easyui-textbox" />
				手机号码: <input type="text" id="sellerPhone" class="easyui-textbox" />
				状态: <select id="userFlag" class="easyui-combobox">
				<option value="">不限</option>
				<option value="1">正常</option>
				<option value="0">冻结</option>
			</select>

				<a	href="#" class="easyui-linkbutton" iconCls="icon-search"
					onclick=seller_obj.search();>查询</a>
			</div>
		</div>
		<!-- 组织列表显示 -->
		<div style="margin-top: 20px;">
			<table id="sellerDataGrid">

			</table>

		</div>
	</div>
	<script type="text/javascript">
		$(function() {
	
			seller_obj = {
                search : function() {//查询
                    $("#sellerDataGrid").datagrid(
                        "load",
                        {
                            sellerName : $.trim($("#sellerName").val()),
                            sellerPhone : $.trim($("#sellerPhone").val()),
                            userFlag : $.trim($("#userFlag").val()),
                        });
                },
				remove : function() {
                    var rows = $("#sellerDataGrid").datagrid("getSelections");
                    if(rows.length > 0) {
                        $.messager.confirm("消息","确认真的要删除所选的数据吗",function(flag){
                            if(flag){
                                var ids = [];
                                for(var i=0;i<rows.length;i++){
                                    ids.push(rows[i].userId);
                                }
                                $.ajax({
                                    type : "post",
                                    url : "sellerController_remove.html",
                                    data : {
                                        ids : ids.join(","),
                                    },
                                    beforeSend : function(){
                                        $("#sellerDataGrid").datagrid("loading");
                                    },
                                    success : function(data){
                                        if(data) {
                                            $("#sellerDataGrid").datagrid("loaded");
                                            $("#sellerDataGrid").datagrid("load");
                                            $("#sellerDataGrid").datagrid("unselectAll");
                                            $.messager.show({
                                                title : "提示",
                                                msg : data + "个直销员被删除"
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
					var url = "sellerController_findById.html";
					var info = "";
					var id = 0;
					if (state == 'add') { //新增
						info = "新增直销员信息";
					} else { //修改
						info = "修改直销员信息";
						var rows = $("#sellerDataGrid").datagrid("getSelections");
						if (rows.length == 1) {
							id = rows[0].sellerId;
							url += "?sellerId=" + id;
						} else {
							$.messager.alert("警告", "必须选中一行", "warning");
							return;
						}
					}
					$("#editSeller").window({
						title : info,
						width : 650,
						height : 580,
						modal : true,
						minimizable : false,
						href : url,
						onClose : function() {
							$("#sellerDataGrid").datagrid("reload");
						}
					});
				}
			}
	
	
	
			$("#sellerDataGrid").datagrid({

				url : "sellerController",
				title : "直销员列表",
				fitColumns : true,
				striped : true,
				rownumbers : true,
				columns : [ [ {
					field : "sellerId",
					title : "序号",
					width : 100,
					sortable : true
				}, {
					field : "sellerName",
					title : "直销员姓名",
					width : 100,
					sortable : true
				}, {
					field : "sellerPhone",
					title : "手机号",
					width : 100,
					sortable : true
				}, {
					field : "joiner",
					title : "所属代理商",
					width : 100,
					sortable : true
				}, {
					field : "sellerDate",
					title : "加入时间",
					width : 100,
					sortable : true
				}, {
					field : "sysUser",
					title : "状态",
					width : 100,
					sortable : true,
					formatter:function (value,rowDate,rowIndex) {
						var userFalg = rowDate["sysUser"]
						if(userFalg=='0'){
						    return("<span style='color:crimson'>冻结</span>");
						}else if(userFalg=='1'){
						    return '正常'
						}
                    }

				}, {
						field : "op1",
						title : "操作",
						width : 100,
						formatter : function(value, rowData, rowIndex) {
							var sellerId = rowData["sellerId"];
							return "<a href='#' onclick=getSeller(" + sellerId + ")>查看</a>"
						}
					} ] ],
				toolbar : "#searchSellerForm",
				pagination : true,
				pageSize : 5,
				pageList : [ 5, 10, 15, 20, 50 ],
				sortName : "sellerId",
				sortOrder : "asc",
			});
		});
		//查看指定菜单
		function getSeller(sellerId) {

			$("#editSeller").window({
				title : "查看直销员详情",
				width : 550,
				height : 480,
				modal : true,
				minimizable : false,
				href : "sellerController_view.html?sellerId="+sellerId
			});
		}
	</script>
</body>
</html>