<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>员工信息</title>
<%@ include file="commons/meta.jsp"%>
</head>

<body>
	<div style="margin: 10px 30px">
		<div id="editEmp"></div>
		<div id="serachEmpForm" style="padding: 10px">
			<!-- step 4:操作按钮 -->
			<!-- plain="true" 显示简洁效果 -->
			<div style="margin-bottom: 10px">
				<a href="#" plain="true" class="easyui-linkbutton"
					iconCls="icon-add" onclick="product_obj.edit('add')">新增员工</a> <a
					href="#" plain="true" class="easyui-linkbutton" iconCls="icon-edit"
					onclick="product_obj.edit('edit')">修改员工</a> <a href="#" plain="true"
					class="easyui-linkbutton" iconCls="icon-remove"
					onclick="product_obj.remove()">删除员工</a>
			</div>

			<!-- step 3:设置多条件查询 -->
			<div style="padding: 0 0 0 6px">
				<label>员工ID:</label> <input id="id" class="easyui-textbox">
				<label>员工姓名:</label> <input id="name" class="easyui-textbox">
				<label>员工手机:</label> <input id="phone" class="easyui-textbox">
				 <a href="#" class="easyui-linkbutton" iconCls="icon-search"
					onclick="product_obj.search()">查询</a>
			</div>

		</div>

		<!-- step 1:产品列表 -->
		<div style="margin-top: 10px">
			<table id="empDataGrid"></table>
		</div>
	</div>

	<script>
		$(function () {
			product_obj = {
				// 3.查询按钮
				search : function() {
					$("#empDataGrid").datagrid('load', {

						agentName :  $.trim($("#id").val()),
						name : $("#name").val(),
						phone : $("#phone").val()
					})
				},
				// 删除
				remove : function() {
					// 返回所有被选中的行;当没有选中时则提示信息
					var rows = $("#empDataGrid").datagrid('getSelections')
					// alert(rows.length);
					if (rows.length > 0) {
                        $.messager.confirm('消息', '确认真的要删除所选的数据.', function (flag) {
                            if (flag) {
                                var ids = [];
                                for (var i = 0; i < rows.length; i++) {
                                    // 1 2 7 10 14 => [1 2 3 10 14]
                                    ids.push(rows[i].id)
                                }
                                $.ajax({
                                    type: 'post',
                                    url: 'removeEmp',
                                    // [1 2 3 10 14] = 1,2,3,10,14
                                    data: {
                                        ids: ids.join(",")
                                    },
                                    beforeSend: function () {
                                        // 显示载入状态
                                        $("#empDataGrid").datagrid('loading')
                                    },
                                    success: function (data) {
                                        if (data) {
                                            // 隐藏载入状态
                                            $("#empDataGrid").datagrid('loaded')
                                            // 加载和显示第一页的所有行
                                            $("#empDataGrid").datagrid('load')
                                            // 取消当前页选中的所有的行
                                            $("#empDataGrid").datagrid('unselectAll')
                                            $.messager.show({
                                                title: "提示",
                                                msg: data + "删除成功"
                                            });
                                        }
                                    }
                                })
                            }
                        });
                    } else {
						$.messager.alert('警告', '请至少选中一行,然后删除!', 'warning')
					}},

				// 新增或修改
				edit: function(status) {
					var url = ''
					var info = ''
					if (status == 'add') {
						url = 'empEdit.jsp'
						info = '新增'
					} else {
						var rows = $("#empDataGrid").datagrid('getSelections')
						if (rows.length == 1) {
							url = 'findById?id=' + rows[0].id
							info = '修改'
						}  else {
							$.messager.alert('警告', '修改且仅能修改一行数据!', 'warning')
							return
						}
					}


					// 显示窗口
					$("#editEmp").window({
						title : info,
						width : 550,
						height : 630,
						modal : true,
						minimizable : false,
						href : url,
						onClose : function() {
							$('#empDataGrid').datagrid("reload");
						}
					})
				}
			}

			// step 2: 查询 ----------------------------
			$("#empDataGrid").datagrid({
				url : 'empList',
				title : '员工列表',
				fitColumns : true, // 自动展开/伸缩列
				striped : true, // 显示斑马线效果
				rownumbers : true, // 行号
				columns : [ [ {
					field : 'id', // 必需与 json 数据中的名一致
					title : '序号',
					width : 50,
					checkbox : true,
					sortable : true
				}, {
					field : 'agentName',
					title : '员工Id',
					width : 100,
					sortable : true
				},{
					field : 'name',
					title : '姓名',
					width : 100,
					sortable : true
				}, {
					field : 'phone',
					title : '手机号',
					width : 100,
					sortable : true
				}, {
					field : 'job',
					title : '职位',
					width : 100,
					sortable : true
				}, {
					field : 'bankName',
					title : '状态',
					width : 100,
					sortable : true
				}
				] ],
				toolbar : '#serachEmpForm',
				pagination : true, // 分页设置
				pageSize : 5, // 每页显示的记录条数
				pageList : [ 5, 10, 20, 50 ], // 设置每页条数的列表
				sortName : 'userId', // 默认排序字段
				sortOrder : 'asc' // 默认排序方式
			})
			// -- 结束查询 ----------------------------

		})

		function getProduct(id){
			$("#editEmp").window({
				title : "查看商品详情",
				width : 550,
				height : 630,
				modal : true,
				minimizable : false,
				href : "productAction_view?product.id="+id,
				onClose : function() {
					$("#productDataGrid").datagrid('unselectAll')
				}
			})
		}
	</script>
</body>
</html>





