<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML>
<html>
<head>
<title>下级代理商</title>
</head>

<body>
	<h2>下级代理商信息</h2>

	
      <h3>下级代理商的基本资料</h3> 
        <label>代理商编号:</label>  
      <input id="joinerId" value="${joiner.joinerId }" style="border-style: none" readonly="readonly"><br>

        <label>代理商名称:</label> 
      <input  value="${joiner.joinerName }" style="border-style: none" readonly="readonly"><br>
      
      
       <label>代理商级别:</label> 
      <input  value="<c:if test="${joiner.joLevelId==1 }">一级代理商</c:if><c:if test="${joiner.joLevelId==2 }">二级代理商</c:if><c:if test="${joiner.joLevelId==3 }">三级代理商</c:if><c:if test="${joiner.joLevelId==4 }">四级代理商</c:if>" style="border-style: none" readonly="readonly"><br>
  
     <label>所属地区:</label> 
      <input  value="${joiner.joinerLoc }" style="border-style: none" readonly="readonly"><br>
         
    <label>联系人姓名:</label> 
      <input  value="${joiner.joinerLinkname }" style="border-style: none" readonly="readonly"><br>
      
         <label>联系人手机号码:</label> 
      <input  value="${joiner.joinerPhone}" style="border-style: none" readonly="readonly"><br>
         <label>E-mail:</label> 
      <input  value="${joiner.joinerEmail }" style="border-style: none" readonly="readonly"><br>
         <label>联系地址:</label> 
      <input  value="${joiner.joinerAddress }" style="border-style: none" readonly="readonly"><br>
         <label>加入日期:</label> 
      <input  value="<format:formatDate value="${joiner.joinerDate }" pattern="yyyy-MM-dd"/>" style="border-style: none" readonly="readonly"><br>
  
         <label>代理商描述:</label> 
      <input  value="${joiner.joinerExplain }" style="border-style: none" readonly="readonly"><br>
         <hr>
         
         
         <h3>下级代理商的结算信息</h3>  
         <label>开户银行:</label> 
      <input  value="${joiner.joinerBank }" style="border-style: none" readonly="readonly"><br>
      <label>开户人:</label> 
      <input  value="${joiner.joinerHolder }" style="border-style: none" readonly="readonly"><br>
<label>银行账号:</label> 
      <input  value="${joiner.joinerBanknum }" style="border-style: none" readonly="readonly"><br>


<hr>
          <h3>下级代理商的业务信息</h3>
          
  <label>发展下级代理商:</label> 
      <input id="count"  value="" style="border-style: none" readonly="readonly"><br>
      
      <label>业务发展总数:</label> 
      <input   value="" style="border-style: none" readonly="readonly"><br>
      <label>用户发展总数:</label> 
      <input   value="" style="border-style: none" readonly="readonly"><br>
      <label>累计获得佣金:</label> 
      <input   value="" style="border-style: none" readonly="readonly"><br>
  


  

	   
	
	 <script type="text/javascript">
	 	$(function() {
	 		$.ajax({
	 			url : 'count',
	 			dataType : 'json',
	 			data : 'joinerId='+$("#joinerId").val(),
	 			success : function(data) {
	 			$("#count").val(data);
	 			}
	 		})
	 
	 
	 	})
	 </script>
</body>
</html>
