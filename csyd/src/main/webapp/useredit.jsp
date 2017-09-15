<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>用户管理</title>
		<%@ include file="commons/meta.jsp"%>
	</head>

	<body>
		<style>
.input {
	width: 200px;
	height: 20px;
	border: 1px solid #95B8E7;
}

</style>
		<form action="" method="post" id="userForm">
			<table width="500" height="192" id="userTable"
				style="margin: 10px auto;">
				<tr>
					<td width="25" height="35" style="">
						&nbsp;
					</td>
					<td width="117">
						<div align="right">
							用户名称：
						</div>
					</td>
					<td width="269">
						<input type="text" name="userName" class="easyui-textbox"
							value="${user.userName }"/>
						<input type="hidden" name="userId" value="${user.userId }"/>
					</td>
					<td width="69">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							用户密码：
						</div>
					</td>
					<td>
						<input type="password" name="userPassword" class="easyui-textbox"
							value="${user.userPassword }" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<%-- <tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							用户图像：
						</div>
					</td>
					<td>
						<input class="easyui-filebox" name="photoPath" value="${user.photoPath }" data-options="width:200,buttonText:'选择文件'" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>--%>
				<tr>
					<td height="35">
						&nbsp;
					</td>
					<td>
						<div align="right">
							用户状态：
						</div>
					</td>
					<td>
						<select class="input" name="userFlag">
							<option value="">
								--请选择--
							</option>
							<option value="0" ${user.userFlag=='0'?'selected':'' }>冻结</option>
              <option value="1" ${user.userFlag=='1'?'selected':'' }>正常</option>
						</select>
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
							<input type="submit" value="保存"/>
							<input type="reset" value="重置"/>
						</div>
					</td>
					<td height="20">
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
		$("#userForm").form({
			url : "userController_save.html",
			success : function(data){
				if(data) {
					$.messager.show({
						title : "提示",
						msg : "操作用户" + data + "成功!"
					});
					$("#editUser").window("close",true);
				}
			}
		});
</script>
	</body>
</html>
