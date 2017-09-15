<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="commons/taglib.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>直销员管理</title>
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
  <form action="" method="post" id="sellerForm" name="sellerForm">
      <table width="500" height="198" id="sellerTable" style="margin: 10px auto;">
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

                  <input name="sellerName" type="text"  data-options="min:0,precision:2" value="${seller.sellerName }" />
                  <input type="hidden" name="sellerId" value="${seller.sellerId }" />

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
                  手机号：
              </div>
          </td>
              <td>
                  <input class="easyui-validatebox" name="sellerPhone" value="${seller.sellerPhone }" />
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
                      <input name="joinerName" type="text"  data-options="min:0,precision:2" value="${joinerName }" readonly="readonly"  />
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
                      登录ID：
                  </div>
              </td>
              <td>
                  <input name="userName" type="text"  data-options="min:0,precision:2" value="${sysUser.userName }" />

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
              <c:if test="${empty seller}">
              <td>
                  <input name="userPassword" type="text"  data-options="min:0,precision:2" value="${seller.sysuser.userPassword }" />
              </td>
              </c:if>

              <c:if test="${!empty seller}">
                  <td>
                      <input name="userPassword" type="text"  data-options="min:0,precision:2" value="**********" readonly="readonly" />
                  </td>
              </c:if>
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
                  <input name="sellerSex" type="text"  data-options="min:0,precision:2" value="${seller.sellerSex }" />
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
                      证件类型：
                  </div>
              </td>
              <td>
                  <input name="sellerCard" type="text"  data-options="min:0,precision:2" value="身份证" />
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
                      证件号：
                  </div>
              </td>
              <td>
                  <input name="sellerCardnum" type="text" data-options="min:0,precision:2" value="${seller.sellerCardnum }" />
              </td>
              <td>
                  &nbsp;
              </td>

              <td>
                  <div align="right">
                      备注：
                  </div>
              </td>
              <td>
                  <input name="sellerRemark" type="text" data-options="min:0,precision:2" value="${seller.sellerRemark }" />
              </td>
              <td>
                  &nbsp;
              </td>
          </tr>
          <td colspan="2">
              <div align="center">
                  <input type="submit" value="保存" />
                  <input type="reset" value="重置" />
              </div>
          </td>
          <td height="20">
              &nbsp;
          </td>
          </tr>
	  </table>
   
  </form>
    <script type="text/javascript">



        $("#sellerForm").form( {
            url : "sellerController_save.html",
            success : function(data) {

                if (data) {
                    $.messager.show( {
                        title : "提示",
                        msg :  data
                    });
                    $("#editSeller").window("close",true);
                }
            }
        });

    </script>

  </body>
</html>