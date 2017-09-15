<%--
  Created by IntelliJ IDEA.
  User: 鲁靖大大
  Date: 2017/8/17
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>供应商管理</title>
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
<form action="" method="post" id="joinerForm">
    <table width="500" height="198" id="joinerTable"
           style="margin: 10px auto;">
        <tr>
            <td width="25" height="35" style="">
                &nbsp;
            </td>
            <td width="117">
                <div align="right">
                    代理商名称：
                </div>
            </td>
            <td width="269">
                ${joiner.joinerName }
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
                    上级组织：
                </div>
            </td>
            <td>
                ${organ.organName }
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
                    所属地区：
                </div>
            </td>
            <td>
                ${joiner.joinerLoc }
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
                    联系人姓名：
                </div>
            </td>
            <td>
                ${joiner.joinerLinkname }
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
                    联系人手机号码：
                </div>
            </td>
            <td>
                ${joiner.joinerPhone }
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
                    E-mail：
                </div>
            </td>
            <td>
                ${joiner.joinerEmail }
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
                    联系地址：
                </div>
            </td>
            <td>
                ${joiner.joinerAddress }
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
                    开户银行：
                </div>
            </td>
            <td>
                ${joiner.joinerBank }
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
                    开户名：
                </div>
            </td>
            <td>
                ${joiner.joinerHolder }
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
                    银行账号：
                </div>
            </td>
            <td>
                ${joiner.joinerBanknum }
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
                    代理商描述：
                </div>
            </td>
            <td>
                ${joiner.joinerExplain }
            </td>
            <td>
                &nbsp;
            </td>
        </tr>

        <c:if test="${joiner.joinerStatus != '0' }">
            <tr>
                <td height="35">
                    &nbsp;
                </td>
                <td>
                    <div align="right" style="color: #00ee00">
                        审核
                    </div>
                </td>
                <td>
                    <div style="color: #00ee00">结果</div>
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
                        审核结果：
                    </div>
                </td>
                <td>
                    <c:if test="${joiner.joinerStatus =='1'}">通过审核</c:if>
                    <c:if test="${joiner.joinerStatus =='2'}">未通过审核</c:if>
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
                        备注：
                    </div>
                </td>
                <td>
                        ${joiner.joinerRemark}
                </td>
                <td>
                    &nbsp;
                </td>
            </tr>
        </c:if>

        <tr>
            <td>
                &nbsp;
            </td>
            <td colspan="2">
                <div align="center">
                    <a href='javascript:closeWindowOfJoinerView()' class="easyui-linkbutton">返回</a>
                </div>
            </td>
            <td height="20">
                &nbsp;
            </td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    function closeWindowOfJoinerView(){
        $("#editJoiner").window("close",true);
    }
</script>
</body>
</html>
