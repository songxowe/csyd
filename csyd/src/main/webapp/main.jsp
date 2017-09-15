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
<div class="easyui-layout" style="text-align: left; height: 270px;margin: 10px 30px;">
    <form method="POST"  enctype="multipart/form-data" id="form1" action="uploadExcel/upload">
        <table>
            <tr>
               <td> <span style=" font-family:'\'cb\'ce\'cc\'e5'; color:#000000; font-size:13px;">请选择要导入的文件：</span></td>

                <td> <input id="upfile" type="file"  name="upfile"></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交" onclick="return checkData()"></td>
               <!-- <td><input type="button" value="ajax方式提交" id="btn" name="btn" ></td>-->
            </tr>
        </table>
    </form>



</div>


    <script type="text/javascript">
        //ajax 方式上传文件操作
        $(document).ready(function(){
            $('#btn').click(function(){
                if(checkData()){
                    $('#form1').ajaxSubmit({
                        url:'uploadExcel/ajaxUpload.do',
                        dataType: 'text',
                        success: resutlMsg,
                        error: errorMsg
                    });
                    function resutlMsg(msg){
                        alert(msg);
                        $("#upfile").val("");
                    }
                    function errorMsg(){
                        alert("导入excel出错！");
                    }
                }
            });
        });

        //JS校验form表单信息
        function checkData(){
            var fileDir = $("#upfile").val();
            var suffix = fileDir.substr(fileDir.lastIndexOf("."));
            if("" == fileDir){
                alert("选择需要导入的Excel文件！");
                return false;
            }
            if(".xls" != suffix && ".xlsx" != suffix ){
                alert("选择Excel格式的文件导入！");
                return false;
            }
            return true;
        }
    </script>


</body>
</html>