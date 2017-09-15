<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<html>
<head>
    <title>业务办理</title>
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
<form action="" method="post" id="bussinessForm">
    <table width="500" height="198" id="bussinessTable"
           style="margin: 10px auto;">
        <tr>
            <td height="35">
                &nbsp;
            </td>
            <td>
                <div align="right">
                    开通业务号码：
                </div>
            </td>
            <td>
                <input type="hidden" id="userId" value="${sessionScope['NEWER_USER_LOGIN_INFO'].userId}">
                <input type="text" name="cusPhone" class="easyui-textbox" />
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
                    产品：
                </div>
            </td>
            <td>
                <select id="product" name="proName">
                    <option value="-1">请选择</option>
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
                    <input type="submit" value="开通" />
                </div>
            </td>
            <td height="20">
                &nbsp;
            </td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    $("#bussinessForm").form( {
        url : "businessController?userId="+$("#userId").val(),
        success : function(data) {
            if (data) {
                $.messager.show( {
                    title : "提示",
                    msg : "开通成功!"
                });
            }
        }
    });

    $.ajax({
        url:"businessController_findProName",
        type:"post",
        dataType:"json",
        success:function (data) {
            $.each(data,function (i) {
                //alert(data[i])
                var text = "<option value="+data[i]+">"+data[i]+"</option>"
                $("#product").append(text)
            })
        }
    })
</script>
</body>
</html>
