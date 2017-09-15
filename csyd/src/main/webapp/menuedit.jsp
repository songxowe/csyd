<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>菜单管理</title>
		<%@ include file="commons/meta.jsp"%>
	</head>

	<body>
		<style>
.input {
	width: 200px;
	height: 20px;
	border: 1px solid #95B8E7;
}

.btn {
	width: 100px;
	height: 20px;
	border: 1px solid #95B8E7;
}
</style>
		<form action="" method="post" id="menuForm">
			<table width="500" height="198" id="menuTable"
				style="margin: 10px auto;">
				<tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							菜单标题：
						</div>
					</td>
					<td>
						<input type="text" name="menuName" value="${menu.menuName }"
							class="easyui-textbox" />
						<input type="hidden" name="menuId" value="${menu.menuId }" />
						<input type="hidden" name="menuStatus" value="${menu.menuStatus==null?1:menu.menuStatus }" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>				
				<tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							转向地址：
						</div>
					</td>
					<td>
						<input class="easyui-textbox" name="menuLinkUrl" value="${menu.menuLinkUrl }" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
								
				<tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							优选顺序：
						</div>
					</td>
					<td>
						<input class="easyui-textbox" name="seq" value="${menu.seq }" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							父级菜单：
						</div>
					</td>
					<td>
						<input type="hidden" value="${menu.menuParentId}" id="parentMenu" name="menuParentId"/>
						<input type="text" id="menuSelect"/>
						<script type="text/javascript">
	$("#menuSelect").combotree( {
		url : "menuController_indexAllEdit.html",
		width : 200,
		onLoadSuccess : function(node, data) {			
			if (data) {
				$(data).each(function(index, value) {
					// alert(index + " "+value.text);
					if (this.state == "closed") {
						var menutree = $("#menuSelect").combotree("tree");
						menutree.tree("expandAll");
					}
				});
			}
		},
		onClick : function(node) {
			$("#parentMenu").val(node.id);
		}
	});
	$("#menuSelect").combotree("setValue", "${empty menu.menuParentId?'无父级菜单': parentMenu.menuName}");
</script>
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							菜单描述：
						</div>
					</td>
					<td>
						<input class="easyui-textbox" name="menuDescn" value="${menu.menuDescn }" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td colspan="2">
						<div align="center">
							<input type="submit" value="保存" />
							<input type="reset" value="重置" />
						</div>
					</td>
					<td height="20">
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
	$("#menuForm").form( {
		url : "menuController_save.html",
		success : function(data) {
			if (data) {
				$.messager.show( {
					title : "提示",
					msg : "菜单" + data + "成功!"
				});
				$("#editMenu").window("close",true);
			}
		}
	});
</script>
	</body>
</html>
