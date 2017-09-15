<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="commons/taglib.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>组织管理</title>
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
  <form action="" method="post" id="organForm" name="organForm">
      <table width="500" height="198" id="organTable" style="margin: 10px auto;">
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
                  <c:if test="${!empty organ}">
                  <input name="organHeigh" type="text"  data-options="min:0,precision:2" value="${organ.organHeigh }" readonly="readonly" />
                  <input type="hidden" name="organId" value="${organ.organId }" />
              </c:if>
                  <c:if test="${empty organ}">
                      <input name="organHeigh" type="text"  data-options="min:0,precision:2" value="${organ.organHeigh }"  list="itemHeigh" />
                      <input type="hidden" name="organId" value="${organ.organId }" />


                  <datalist id="itemHeigh">
                      <option>请选择</option>
                  </datalist>
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
                  组织名称：
              </div>
          </td>
              <td>
                  <input class="easyui-validatebox" name="organName" value="${organ.organName }" />
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
                  <input name="organType" type="text"  data-options="min:0,precision:2" value="${organ.organType } "list="itemlist" />
                  <datalist id="itemlist">
                      <option>请选择</option>
                  </datalist>
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
                  <input name="organLoc" type="text"  data-options="min:0,precision:2" value="${organ.organLoc }" list="itemLoc" />
                  <datalist id="itemLoc">
                      <option>请选择</option>
                  </datalist>
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
                  <input name="organDir" type="text"  data-options="min:0,precision:2" value="${organ.organDir }" />
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
                  <input name="organLinkman" type="text"  data-options="min:0,precision:2" value="${organ.organLinkman }" />
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
                  <input name="organPhone" type="text"  data-options="min:0,precision:2" value="${organ.organPhone }" />
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
                  <input name="organExplain" type="text" data-options="min:0,precision:2" value="${organ.organExplain }" />
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
        $(function () {
            loadorganType();
            loadorganLoc();
            loadorganHeigh();
        })
   function loadorganType() {
       $.ajax({
           url:"organController_find.html",
           dataType:'json',
           type:"GET",
           success:function (data) {
               $.each(data,function () {
                   var op = $("<option>"+this.organType+"</option>");
                   $("#itemlist").append(op);
               })
           }
       })
   }
        function loadorganLoc() {
            $.ajax({
                url:"organController_findLoc.html",
                dataType:'json',
                type:"GET",
                success:function (data) {
                    $.each(data,function () {
                        var op = $("<option>"+this.organLoc+"</option>");
                        $("#itemLoc").append(op);
                    })
                }
            })
        }

        function loadorganHeigh() {
            $.ajax({
                url:"organController_findHeigh.html",
                dataType:'json',
                type:"GET",
                success:function (data) {
                    $.each(data,function () {
                        var op = $("<option>"+this.organName+"</option>");
                        $("#itemHeigh").append(op);
                    })
                }
            })
        }

        $("#organForm").form( {
            url : "organController_save.html",
            success : function(data) {

                if (data) {
                    $.messager.show( {
                        title : "提示",
                        msg :  data
                    });
                    $("#editOrgan").window("close",true);
                }
            }
        });

    </script>

  </body>
</html>