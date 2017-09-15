<%@ page language="java" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
<title>下级代理商信息</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/easyui/themes/icon.css" />
<script src="${pageContext.request.contextPath }/resources/easyui/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/easyui/jquery.easyui.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/easyui/locale/easyui-lang-zh_CN.js"></script>

</head>

<body>
	<div style="margin: 10px 30px">
	<div id="joinerList"></div>
		 <div  id="joinerListForm" style="padding: 10px">
			 <!-- step 4:操作按钮 -->
			<!-- plain="true" 显示简洁效果 -->
			 <div style="margin-bottom: 10px">
				 <a href="#" plain="true" class="easyui-linkbutton"
					iconCls="icon-add" onclick="product_obj.edit('add')">新增</a> <a
					href="#" plain="true" class="easyui-linkbutton" iconCls="icon-edit"
					onclick="product_obj.edit('edit')">修改</a> 
			</div>

			<!-- step 3:设置多条件查询 -->
			<div style="padding: 0 0 0 6px">
				<label>下级代理商名称:</label> <input id="id" class="easyui-textbox">
				<label>状态:</label>  <select id="name" class="easyui">
				   <option value="-1">所有</option>
				   <option value="1">正常</option>
				   <option value="0">已冻结</option>
				</select>
					
				 <a href="#" class="easyui-linkbutton" iconCls="icon-search"
					onclick="product_obj.search()">查询</a>
			</div>
			
			
		</div>
		

		<!-- step 1:产品列表 -->
		<div style="margin-top: 10px">
			<table id="joinerListDataGrid"></table>
		</div>
	</div>

	<script>
		$(function() {
			product_obj = {
				// 3.查询按钮
				search : function() {
					$("#joinerListDataGrid").datagrid('load', {
					
						joinerName :  $.trim($("#id").val()),
						userFlag : $("#name").val(),
						
					})
				},
		
				// 新增或修改
				edit : function(status) {
					var url = ''
					var info = ''
					if (status == 'add') {
						url = 'joinerEdit.jsp'
						info = '新增'
					} else {
						var rows = $("#joinerListDataGrid").datagrid('getSelections')
						if (rows.length == 1) {
						
							url = 'findByJoiner?joinerId=' + rows[0].joinerId
							info = '修改'
						}  else {
							$.messager.alert('警告', '修改且仅能修改一行数据!', 'warning')
							return
						}
					}
	
					// 显示窗口 
					$("#joinerList").window({
						title : info,
						width : 550,
						height : 630,
						modal : true,
						minimizable : false,
						href : url,
						onClose : function() {
							$('#joinerListDataGrid').datagrid("reload");
						}
					})
				}
			}
	
			// step 2: 查询 ----------------------------
			$("#joinerListDataGrid").datagrid({
				url : 'joinerList',
				title : '下级代理商',
				fitColumns : true, // 自动展开/伸缩列
				striped : true, // 显示斑马线效果
				rownumbers : true, // 行号
				columns : [ [ {
					field : 'joinerId', // 必需与 json 数据中的名一致
					title : '序号',
					width : 50,
					checkbox : true,
					sortable : true
				}, {
					field : 'joinerName',
					title : '下级代理商名称',
					width : 100,
					sortable : true
				}, {
					field : 'joinerPhone',
					title : '手机号码',
					width : 100,
					sortable : true
				}, {
					field : 'joinerLoc',
					title : '所属地区',
					width : 100,
					sortable : true
				}, {
					field : 'joinerDate',
					title : '创建时间',
					width : 100,
					sortable : true
				}, {
					field : 'userFlag',
					title : '状态',
					width : 100,
					sortable : true
				}, {
					field : "op1",
					title : "操作",
					width : 100,
					formatter : function(value, rowData, rowIndex){
						var id = rowData["joinerId"];
						return "<a href='#' onclick=getProduct("+id+")>查看</a>"
					}
				
					
				}
				] ],
				toolbar : '#joinerListForm',
				pagination : true, // 分页设置
				pageSize : 5, // 每页显示的记录条数
				pageList : [ 5, 10, 20, 50 ], // 设置每页条数的列表
				sortName : 'joinerLoc', // 默认排序字段
				sortOrder : 'asc' // 默认排序方式
			})
			// -- 结束查询 ----------------------------
	
		})
		function getProduct(id){
			$("#joinerList").window({
				title : "查看下级代理商详情",
				width : 550,
				height : 630,
				modal : true,
				minimizable : false,
				href : "findJoiner?joinerId="+id,
				onClose : function() {
					$("#joinerListDataGrid").datagrid('unselectAll')
				}
			})
		}

	</script>
</body>
</html>





