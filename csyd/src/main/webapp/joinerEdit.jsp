<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>

<body>

	<h2>      
	<c:if test="${empty joiner}">新增下级代理商</c:if>
    <c:if test="${!empty joiner}">修改下级代理商</c:if>
    </h2>
	
	   
	<form method="post" name="f" id="form">
	
	
	  <c:if test="${empty joiner}">
      
		<label>员工ID:</label> <input class="easyui-textbox"
			name="userName" value=""><br>
		<br> 
		<label>登录密码:</label> <input class="easyui-textbox"
			name="userPassword" type="password" value=""><br>
		<br> 
	  </c:if>
		<c:if test="${!empty joiner}">
		<input type="hidden" value="${joiner.joinerId }" name="joinerId">
		<input type="hidden" value="${joiner.userId }" name="userId">
		
		</c:if>
		 
		<label>角色状态:</label> 
		<input type="radio" value="1" name="userFlag" checked="checked">开通
		<input type="radio" value="0" name="userFlag">锁定<br> <br> 
		<label>下级代理商名称:</label>  
		<input class="easyui-textbox" value="${joiner.joinerName }" name="joinerName"><br>
		<br>
		<label>所属地区:</label>  
		<input class="easyui-textbox" value="${joiner.joinerLoc }" name="joinerLoc"><br>
		<br>
        <label>开户银行:</label>  
		<input class="easyui-textbox" value="${joiner.joinerBank }" name="joinerBank"><br>
		<br>
		<label>银行账号:</label>  
		<input class="easyui-textbox" value="${joiner.joinerBanknum }" name="joinerBanknum"><br>
		<br>
		


		<button type="submit">保存</button>
	</form>
	<script>
	
		$(function() {
		
       $("#form").form(
       {
	    url:'save',
	    success:function(data){
	    $('#joinerListDataGrid').datagrid("reload");
	      if(data){
	     
	      $.messager.show({
	        title:'提示',
	        msg: '保存成功!'     
	      });      
	      $("#joinerList").window("close",true);
	      
	      
	      
	      }
	    
	    }
	   
	   
	   
	   })
	
	
		})
	</script>
</body>
</html>
