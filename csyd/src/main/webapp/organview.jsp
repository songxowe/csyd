<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="commons/taglib.jsp"%>
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

<from action="" method="post" id="organForm" name="organForm">
    <table width="500" height="198" id="organTable" style="margin: 10px auto;">
        <tr>
            <td height="35">
                &nbsp;
            </td>
            <td>
                <div align="right">
                    组织名：
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
                    上级组织：
                </div>
            </td>
            <td>
               ${organ.organHeigh }
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
                    组织类型：
                </div>
            </td>
            <td>
               ${organ.organType }
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
               ${organ.organLoc }
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
                    组织主管：
                </div>
            </td>
            <td>
                ${organ.organDir }
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
                    联系人：
                </div>
            </td>
            <td>
               ${organ.organLinkman }
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
                    联系人手机：
                </div>
            </td>
            <td>
               ${organ.organPhone }
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
                    组织说明：
                </div>
            </td>
            <td>
               ${organ.organExplain }
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
        $("#editOrgan").window("close",true);
    }
</script>
</body>
</html>