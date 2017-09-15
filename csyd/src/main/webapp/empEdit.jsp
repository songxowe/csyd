<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>

<body>

<h2>
	<c:if test="${empty employee}">新增员工</c:if>
	<c:if test="${!empty employee}">修改员工</c:if>
</h2>


<form method="post" name="f" id="form">
	<label>组织部门:</label>
	<select id="org" name="organId">
		<option value="-1">请选择</option>
	</select><br>

	<input type="hidden" name="id" value="${employee.id }">
	<input type="hidden" id="orgaId" value="${employee.organId }">

	<c:if test="${!empty employee}">
		<input type="hidden" name="userId" value="${employee.userId }">
	</c:if>

	<input type="hidden" id="jobID" value="${sysRole.roleId }">  <br>
	<label>职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位:</label>
	<select name="job" id="jobId">
		<option value="-1">请选择</option>
	</select><br> <br>

	<label>员工姓名:</label> <input class="easyui-textbox" value="${employee.name }" name="name"><br> <br>


	<c:if test="${empty employee}">

		<label>员工ID:</label> <input class="easyui-textbox"
									name="userName" value=""><br>
		<br>
		<label>登录密码:</label> <input class="easyui-textbox"
									name="userPassword" value=""><br>
		<br>
	</c:if>


	<label>角色状态:</label>
	<input type="radio" value="1" name="userFlag" checked="checked">开通
	<input type="radio" value="0" name="userFlag">锁定<br> <br>

	<c:if test="${empty employee}">
		<label>性别:</label>
		<input type="radio" value="男" name="sex">男 <input
			type="radio" value="女" name="sex">女<br> <br>
	</c:if>

	<label>手机号码:</label> <input class="easyui-textbox"
								value="${employee.phone }" name="phone"><br> <br>
	<label>证件类型:</label> <input class="easyui-textbox"
								value="${employee.docType }" name="docType"><br>
	<br> <label>证件号:</label> <input class="easyui-textbox"
									value="${employee.docNumber }" name="docNumber"><br>
	<br> <label>代办员姓名:</label> <input class="easyui-textbox"
									  value="${employee.agentName }" name="agentName"><br>
	<br> <label>所在地区:</label> <input class="easyui-textbox"
									 value="${employee.loc }" name="loc"><br> <br>
	<label>开户银行:</label> <input class="easyui-textbox"
								value="${employee.bankName }" name="bankName"><br>
	<br> <label>银行账号:</label> <input class="easyui-textbox"
									 value="${employee.bankNumber }" name="bankNumber"><br>
	<br>

	<label>角色设置:</label>
	<select name="roleId" id="sel">
		<option value="-1">请选择</option>
	</select><br> <br>
	<div id="d"></div><br>


	<button type="submit">保存</button>
</form>
<script>

    $(function() {
        $.ajax({
        type : 'post',
        url : 'findOrgan',
        dataType : 'json',
        success : function(data) {
            $.each(data, function(i) {
                if($("#orgaId").val()==data[i].organId){
                    var sel="selected";
                }
                var text = "<option value=" + data[i].organId + " "+sel+">" + data[i].organName + "</optin>";

                $("#org").append(text);
            })


        }
    })


    $.ajax({
        type : 'post',
        url : 'findRole',
        dataType : 'json',
        success : function(data) {
            $.each(data, function(i) {
                if($("#jobID").val()==data[i].roleId){
                    var sel="selected";
                }
                if($("#jobID").val()==data[i].roleId){
                    var se="selected";
                }
                var text = "<option value=" + data[i].roleId + " "+sel+">" + data[i].roleName + "</optin>";


                var text1 = "<option value=" + data[i].roleName + " "+se+">" + data[i].roleName + "</optin>";
                $("#sel").append(text);
                $("#jobId").append(text1);


            })


        }
    })
    $("#sel").change(function() {
        $("#d").empty();
        $.ajax({
            type : 'post',
            url : 'findRight',
            data : {
                roleId : $("#sel").val()
            },
            dataType : 'json',
            success : function(data) {
                $.each(data, function(i) {
                    var text = "<input name='menuId' type='checkbox' value='" + data[i].menuId + "'>" + data[i].menuName + ""
                    $("#d").append(text);

                })


            }
        })



    })
    $("#form").form(
        {
            url:'addEmp',
            success:function(data){
                $('#empDataGrid').datagrid("reload");
                if(data){
                    $.messager.show({
                        title:'提示',
                        msg: '保存成功!'
                    });
                    $("#editEmp").window("close",true);



                }

            }



        })


    })
</script>
</body>
</html>
