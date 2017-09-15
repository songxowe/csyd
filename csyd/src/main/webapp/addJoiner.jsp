<%--
  Created by IntelliJ IDEA.
  User: 鲁靖大大
  Date: 2017/8/17
  Time: 15:01
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
<c:if test="!empty joiner"></c:if>
<form action="" method="post" id="joinerForm">
    <table width="600" height="198" id="joinerTable"
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
            <td width="350">
                <input class="easyui-validatebox" name="joinerName" value="${joiner.joinerName}">
                <input type="hidden" name="joinerId" value="${joiner.joinerId}">
                <span style="color: #761c19">公司名称或您的姓名，只能是中文</span>
            </td>
            <td width="30">
                &nbsp;
            </td>
        </tr>
        <c:if test="${empty joiner}">
        <tr>
            <td width="25" height="35" style="">
                &nbsp;
            </td>
            <td width="117">
                <div align="right">
                    账户：
                </div>
            </td>
            <td width="350">
                <input class="easyui-validatebox" name="userName" value="" >
            </td>
            <td width="30">
                &nbsp;
            </td>
        </tr>

        <tr>
            <td width="25" height="35" style="">
                &nbsp;
            </td>
            <td width="117">
                <div align="right">
                    密码：
                </div>
            </td>
            <td width="350">
                <input class="easyui-validatebox" name="userPassword" type="password" value="">
            </td>
            <td width="30">
                &nbsp;
            </td>
        </tr>
        </c:if>
        <tr>
            <td width="25" height="35" style="">
                &nbsp;
            </td>
            <td width="117">
                <div align="right">
                    角色：
                </div>
            </td>
            <td width="350">
                <input id="role" class="easyui-combobox" name="roleId" value=""
                       data-options="editable:false,valueField:'roleId',textField:'roleName',url:'findRole'" />
            </td>
            <td width="30">
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
                <input id="organId" class="easyui-combobox" name="organ.organId" value="${organ.organId}"
                       data-options="editable:false,valueField:'organId',textField:'organName',url:'findOrgan.html'" />
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
                <input class="easyui-validatebox" name="joinerLoc" value="${joiner.joinerLoc}">
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
                <input class="easyui-validatebox" name="joinerLinkname" value="${joiner.joinerLinkname}">
                <span style="color: #761c19">请填写真实的联系人姓名</span>

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
                <input class="easyui-validatebox" name="joinerPhone" value="${joiner.joinerPhone}" >
                <span style="color: #761c19">请填移动手机号码</span>
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
                <input class="easyui-validatebox" name="joinerEmail" value="${joiner.joinerEmail}">

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
                <input class="easyui-validatebox" name="joinerAddress" value="${joiner.joinerAddress}">

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
                <input class="easyui-validatebox" name="joinerBank" value="${joiner.joinerBank}">
                <span style="color: #761c19">用于佣金结算,请填写真实的开户银行。</span>

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
                <input class="easyui-validatebox" name="joinerHolder" value="${joiner.joinerHolder}">
                <span style="color: #761c19">用于佣金结算,请填写真实的开户名。</span>

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
                <input class="easyui-validatebox" name="joinerBanknum" value="${joiner.joinerBanknum}">
                <span style="color: #761c19">用于佣金结算,请填写真实的银行帐号。</span>

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
                <input class="easyui-validatebox" name="joinerExplain" value="${joiner.joinerExplain}">

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
                    <a href='javascript:closeWindowOfJoinerView()' class="easyui-linkbutton">取消</a>
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

    $("#joinerForm").form( {
        url : "joinerEdit",
        success : function(data) {
            if (data) {
                $.messager.show( {
                        title : "提示",
                        msg : "供应商" + data + "成功!"
                });
                $("#editJoiner").window("close",true);
                $("#joinerDataGrid").datagrid(
                    "load");
            }
        }
    })

</script>
</body>
</html>
