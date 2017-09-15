<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<html>
<head>
    <title>修改个人资料</title>
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
<form action="" method="post" id="sellerInfoForm">
    <table width="500" height="198" id="sellerInfoTable"
           style="margin: 10px auto;">
        <tr>
            <td height="35">
                &nbsp;
            </td>
            <td>
                <div align="right">
                    姓名：
                </div>
            </td>
            <td>
                <input type="hidden" name="sellerId" value="${seller.sellerId}" class="easyui-text">
                <input type="text" name="sellerName" value="${seller.sellerName}" class="easyui-textbox" />
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
                <input type="text" name="sellerPhone" value="${seller.sellerPhone}" class="easyui-textbox" />
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
                <input type="text" name="sellerSex" value="${seller.sellerSex}" class="easyui-textbox" />
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
                <input type="text" name="sellerCard" value="${seller.sellerCard}" class="easyui-textbox" />
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
                <input type="text" name="sellerCardnum" value="${seller.sellerCardnum}" class="easyui-textbox" />
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
                    地址：
                </div>
            </td>
            <td>
                <input type="text" name="sellerLoc" value="${seller.sellerLoc}" class="easyui-textbox" />
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
                <input type="text" name="sellerRemark" value="${seller.sellerRemark}" class="easyui-textbox" />
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
                    <input type="submit" value="修改个人资料" />
                </div>
            </td>
            <td height="20">
                &nbsp;
            </td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    $("#sellerInfoForm").form( {
        url : "sellerInfoController_modify",
        success : function(data) {
            if (data) {
                $.messager.show( {
                    title : "提示",
                    msg : "修改成功!"
                });
            }
        }
    });
</script>
</body>
</html>
