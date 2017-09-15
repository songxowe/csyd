<%--
  Created by IntelliJ IDEA.
  User: S5VT
  Date: 2017/8/18
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="commons/taglib.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>产品管理</title>
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
      <form action="" method="post" id="productForm" name="productForm">
          <table width="500" height="198" id="productTable"
                 style="margin: 10px auto;">
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
                      <input class="easyui-validatebox" name="proName" value="${product.proName }"/>
                      <input type="hidden" name="proId" value="${product.proId }" />
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
                      <input name="proType" type="text" class="easyui-validatebox"  value="${product.proType }" />
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
                  <input name="proCost" type="text" class="easyui-validatebox"  value="${product.proCost }" />
              </td>
              <td>
                  &nbsp;
              </td>
          </tr><tr>
              <td height="35">
                  &nbsp;
              </td>
              <td>
                  <div align="right">
                      所属地区：
                  </div>
              </td>
              <td>
                  <input name="proLoc" type="text" class="easyui-validatebox"  value="${product.proLoc }" />
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
                      <c:if test="${empty product }">
                          <input type="file"  name="proImg"  />
                      </c:if>
                      <c:if test="${!empty product}">
                          <input type= "text" class= "easyui-validatebox" name="proImg" value="${product.proImg}" />
                      </c:if>
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
                      <input name="proFirst" type="text" class="easyui-numberbox" data-options="min:0,precision:2"  value="${product.proFirst }" />
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
                      <input name="proMonth" type="text" class="easyui-numberbox" data-options="min:0,precision:2"  value="${product.proMonth }" />
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
                              <input id="proLinkName" type="text"  name="proLink" value="${product.proLink }"/>&nbsp;&nbsp;
                              <a href="#"  iconCls="icon-add"
                                 onclick="product_abj.addProduct()"><span style="color: #00bbee">添加</span></a><br>
                              *请选择下面表单中的产品
                  </td>
                  <td>
                      &nbsp;<br>
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
                      <input id="proOutName" type="text"  name="proIOut" value="${product.proOut }"/>&nbsp;&nbsp;
                      <a href="#" iconCls="icon-add"
                         onclick="product_abj.outProduct()"><span style="color: #00bbee">添加</span></a><br>
                      *请选择下面表单中的产品
                  </td>
                  <td>
                      &nbsp;<br>
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
                      <c:if test="${empty product }">
                          <select id="proStatus" class="easyui-combobox" style="width: 100px" name="proStatus">
                              <option value="0">下线</option>
                              <option value="1">上线</option>
                          </select>
                      </c:if>
                      <c:if test="${!empty product }">
                          <select id="proStatus" class="easyui-combobox" name="proStatus" style="width: 100px" >
                              <c:if test="${product.proStatus=='0'}">
                                  <option value="0">下线</option>
                                  <option value="1">上线</option>
                              </c:if>
                              <c:if test="${product.proStatus=='1'}">
                                  <option value="1">上线</option>
                                  <option value="0">下线</option>
                              </c:if>
                          </select>
                      </c:if>

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
                          产品创建日期：
                      </div>
                  </td>
                  <td>
                      <c:if test="${empty product }">
                          <input type= "text" class= "easyui-datebox" name="proDate" />
                      </c:if>
                      <c:if test="${!empty product }">
                          <input type= "text" class= "easyui-datebox" name="proDate" value="<spring:eval expression="product.proDate"/>" />
                      </c:if>
                  </td>
                  <td>
                      &nbsp;
                  </td>
              </tr>
              <div >
                  <table id="productGrid" style="width:100%;align:center" >

                  </table>

              </div>
              <tr>
                  <td>
                      &nbsp;
                  </td>
                  <td colspan="2">
                      <div align="center">
                          <input id="btnSelect" type="submit" value="保存" />
                          <input type="reset" value="重置" />
                      </div>
                  </td>
                  <td height="20">
                      &nbsp;
                  </td>
              </tr>
          </table>
      </form>
      <script>
         $( function () {
             $("#productGrid").datagrid({
                 url: "productController_list",
                 title: "产品列表",
                 fitColumns: true,
                 striped: true,
                 multiple:true,
                 rownumbers: false,
                 columns: [[{
                     field: "proId",
                     title: "产品编号",
                     width: 100,
                     sortable: false,
                     hidden: true
                 }, {
                     field: "proName",
                     title: "产品名称",
                     width: 100,
                     sortable: false
                 }]],
                 toolbar: "",
                 pagination: true,
                 pageSize: 2,
                 pageList: [2, 5, 10, 15, 20],
                 sortName: "proId",
                 sortOrder: "asc",
             });
         })

      </script>

      <script>
          $(function () {
              product_abj = {
                  addProduct: function () {
                      var rows = $("#productGrid").datagrid("getSelections");
                      var ids=[];
                      if (rows.length > 0) {
                          for (var i = 0; i < rows.length; i++) {
                              ids.push(rows[i].proName);
                          }
                      }
                      ids.join(",");
                      $("#proLinkName").val(ids.toString());
                      $("#productGrid").datagrid("reload");
                  },
                  outProduct: function () {
                      var rows = $("#productGrid").datagrid("getSelections");
                      var ids=[];
                      if (rows.length > 0) {
                          for (var i = 0; i < rows.length; i++) {
                              ids.push(rows[i].proName);
                          }
                      }
                      ids.join(",");
                      $("#proOutName").val(ids.toString());
                      $("#productGrid").datagrid("reload");
                  }
              }


          });
      </script>
      <!--
      <script>
          $("#btnSelect").onclick=function () {
              var proStatusSelect=$('#proStatusSelect').combobox('getValue');
              if(proStatusSelect==1){
                  $("#proStatus").val(1);
              }
              if(proStatusSelect==0){
                  $("#proStatus").val(0);
              }
          }

      </script>
   -->
      <script type="text/javascript">
          $("#productForm").form( {
              url : "productController_save.html",
              success : function(data) {
                  if (data) {
                      $.messager.show( {
                          title : "提示",
                          msg : "产品" + data + "成功!"
                      });

                      $("#editProduct").window("close",true);
                  }
              }
          });
      </script>


</body>
</html>
