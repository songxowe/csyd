<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="commons/taglib.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>查看产品详情</title>
    <%@ include file="commons/meta.jsp"%>
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
</head>
<body>

  <form action="" method="post" id="productForm">
    <table width="500" height="198" id="productTable"
           style="margin: 10px auto;">
        <tr>
            <td width="25" height="35" style="">
                &nbsp;
            </td>
            <td width="117">
                <div align="right">
                    产品编号：
                </div>
            </td>
            <td width="269">
                ${product.proId}
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
                    产品名称：
                </div>
            </td>
            <td>
                ${product.proName }
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
                    产品类型：
                </div>
            </td>
            <td>
                ${product.proType }
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
                    产品资费：
                </div>
            </td>
            <td>
                ${product.proCost }
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
                ${product.proLoc}
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
                    产品图片：
                </div>
            </td>
            <td>
                ${product.proImg }
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
                    首月佣金：
                </div>
            </td>
            <td>
                ${product.proFirst }
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
                    每月佣金：
                </div>
            </td>
            <td>
                ${product.proMonth}
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
                    关联产品：
                </div>
            </td>
            <td>
                ${product.proLink }
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
                    互斥产品：
                </div>
            </td>
            <td>
                ${product.proOut }
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
                    产品状态：
                </div>
            </td>
            <td>
                <c:if test="${product.proStatus=='0'}">已下线</c:if>
                <c:if test="${product.proStatus=='1'}">已上线</c:if>
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
                    产品创建时间：
                </div>
            </td>
            <td>
                <spring:eval expression="product.proDate"/>
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
                    <a href='javascript:closeWindowOfProductView()' class="easyui-linkbutton">返回</a>
                </div>
            </td>
            <td height="20">
                &nbsp;
            </td>
        </tr>
    </table>
  </form>
  <script type="text/javascript">
      function closeWindowOfProductView(){
          $("#editProduct").window("close",true);
      }
  </script>
</body>
</html>
