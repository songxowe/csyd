<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<html>
<head>
    <title>我的佣金</title>
</head>
<body>
<div style="margin: 10px 30px;">
    <div id="joinerSal" style="padding: 10px;">
        <div style="padding: 0 0 0 6px;">
            年份:
            <input type="text" id="year" value="" class="easyui-textbox">

            <a href="#" class="easyui-linkbutton" iconCls="icon-search"
               onclick=busRecord_obj.search();>查询</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-search"
               onclick=busRecord_obj.sal();>查看佣金明细</a>
        </div>
    </div>

    <div style="margin-top: 20px;">
        <table id="joinerSalDataGrid">

        </table>

    </div>

</div>
<script type="text/javascript">
    $(function () {
        busRecord_obj = {
            search:function () {
                $("#joinerSalDataGrid").datagrid(
                    "load",{
                        year:$.trim($("#year").val()),
                    }
                )
            },

            sal:function () {
                var flag = $("#divtabs").tabs("exists", "佣金明细");
                if (!flag) {//选项卡面板不存在
                    $("#divtabs").tabs("add", {
                        title : "佣金明细",
                        closable : true,
                        href : "joiner_sal.jsp"
                    });
                }
        }}

        $("#joinerSalDataGrid").datagrid({
            url:"salController_total",
            title:"我的佣金",
            fitColumns : true,
            striped : true,
            rownumbers : true,
            columns : [ [ {
                field : "month",
                title : "月份",
                width : 100,
                sortable : true
            }, {
                field : "sal",
                title : "本月佣金额",
                width : 100,
                sortable : true
            }  ,{
                field : "busStatus",
                title : "是否结算",
                width : 100,
                sortable : true,
                formatter:function (value,rowDate,rowIndex) {
                    var busStatus = rowDate["busStatus"];
                    if(busStatus==1){
                        return "是";
                    }else {
                        return "否"
                    }
                }
            }, {
                field : "busTime",
                title : "结算时间",
                width : 100,
                sortable : true
            } ] ],
            toolbar : "#joinerSal",
        })
    })


</script>
</body>
</html>
