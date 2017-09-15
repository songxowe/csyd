<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>工作日志</title>
    <link rel="stylesheet" type="text/css"
          href="easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="bootstrap.min.css" />
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" href="css/style.default.css" type="text/css" />
    <script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
    <script type="text/javascript"
            src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
    <script type="text/javascript" src="js/plugins/jquery.validate.min.js"></script>
    <script type="text/javascript" src="js/plugins/jquery.tagsinput.min.js"></script>
    <script type="text/javascript" src="js/plugins/charCount.js"></script>
    <script type="text/javascript" src="js/plugins/ui.spinner.min.js"></script>
    <script type="text/javascript" src="js/plugins/chosen.jquery.min.js"></script>
    <script type="text/javascript" src="js/custom/general.js"></script>
    <script type="text/javascript" src="js/custom/forms.js"></script>

</head>
<body style="margin: 10px 30px;">



<div id="tt" class="easyui-tabs"
     style="width:98%;height:98%; margin:10px;"
     data-options="fit:'true',order:'true'">
    <div title="组织信息" style="padding:20px;display:none;"
         data-options="fit:'true',order:'true'">
        <iframe src="organlist.jsp" id="iframe" width="100%" height="400px;"
                frameborder="0"></iframe>
    </div>
    <div title="导入Excel" style="overflow:auto;padding:20px;display:none;"
         data-options="fit:'true',order:'true'">

        <iframe src="main.jsp" id="iframe1" width="1100px" height="450px;"
                frameborder="0"></iframe>
    </div>
</div>
</body>
</html>