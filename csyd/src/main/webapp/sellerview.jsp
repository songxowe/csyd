<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="commons/taglib.jsp"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>组织信息</title>
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

<from action="" method="post" id="sellerForm" name="sellerForm">
    <table width="500" height="198" id="sellerTable" style="margin: 10px auto;">
        <tr>
            <td height="35">
                &nbsp;
            </td>
            <td>
                <div align="right">
                    直销员编号：
                </div>
            </td>
            <td>
                ${seller.sellerId }
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
                    直销员姓名：
                </div>
            </td>
            <td>
               ${seller.sellerName }
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
                    手机号码：
                </div>
            </td>
            <td>
               ${seller.sellerPhone }
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
                    所属代理商：
                </div>
            </td>
            <td>
               ${seller.joiner.joinerName }
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
                    登录Id：
                </div>
            </td>
            <td>
                ${sysUser.userName }
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
                    登录密码：
                </div>
            </td>
            <td>
               **********
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
                    加入时间：
                </div>
            </td>
            <td>
               <fmt:formatDate value="${seller.sellerDate }" pattern="yyyy-MM-dd"/>
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
                    性别：
                </div>
            </td>
            <td>
               ${seller.sellerSex }
            </td>
            <td>
                &nbsp;
            </td>

            <td>
                <div align="right">
                    证件类型：
                </div>
            </td>
            <td>
                ${seller.sellerCard }
            </td>
            <td>
                &nbsp;
            </td>

            <td>
                <div align="right">
                    证件号码：
                </div>
            </td>
            <td>
                ${seller.sellerCardnum }
            </td>
            <td>
                &nbsp;
            </td>
        </tr>
        <td colspan="2">
            <div align="center">
                <a href='javascript:closeWindowOfOrganView()' class="easyui-linkbutton">返回</a>
            </div>
        </td>
        <td height="20">
            &nbsp;
        </td>
        </tr>
    </table>

</from>
<script type="text/javascript">
    function closeWindowOfOrganView(){
        $("#editSeller").window("close",true);
    }
</script>
</body>
</html>