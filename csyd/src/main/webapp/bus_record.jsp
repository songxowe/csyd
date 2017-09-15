<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<html>
<head>
    <title>业务营销记录</title>
    <%@ include file="commons/meta.jsp"%>
</head>
<body>
<div style="margin: 10px 30px;">
    <div id="busRecord" style="padding: 10px;">
        <div style="padding: 0 0 0 6px;">
            营销对象：
            <input type="text" id="cusPhone" value="" class="easyui-textbox"/>
            业务名称：
            <input type="text" id="proName" value="" class="easyui-textbox"/>
            统计日期：
            <input type="date" id="beginDate" value="" class="easyui-datebox">
            至
            <input type="date" id="endDate" value="" class="easyui-datebox">
            <a href="#" class="easyui-linkbutton" iconCls="icon-search"
               onclick=busRecord_obj.search();>查询</a>
        </div>
    </div>

    <div style="margin-top: 20px;">
        <table id="busRecordDataGrid">

        </table>

    </div>
</div>
<script type="text/javascript">
    $(function () {
        busRecord_obj = {
            search:function () {
                $("#busRecordDataGrid").datagrid(
                    "load",{
                        cusPhone:$.trim($("#cusPhone").val()),
                        proName:$.trim($("#proName").val()),
                        beginDate:$("#beginDate").datebox('getValue'),
                        endDate:$("#endDate").datebox('getValue')
                    }
                )
            }
        }

        $("#busRecordDataGrid").datagrid({
            url:"busRecordController",
            title:"业务营销记录",
            fitColumns : true,
            striped : true,
            rownumbers : true,
            columns : [ [ {
                field : "id",
                title : "序号",
                width : 100,
                sortable : true
            }, {
                field : "cusPhone",
                title : "营销对象",
                width : 100,
                sortable : true
            } , {
                field : "proName",
                title : "营销业务名称",
                width : 100,
                sortable : true
            } , {
                field : "busType",
                title : "营销方式",
                width : 100,
                sortable : true
            } , {
                field : "busOpen",
                title : "营销时间",
                width : 100,
                sortable : true
            },{
                field : "busClose",
                title : "营销结果",
                width : 100,
                sortable : true,
                formatter:function (value,rowDate,rowIndex) {
                    var busClose = rowDate["busClose"];
                    if(busClose==null||busClose==""){
                        return "营销成功";
                    }else {
                        return "营销失败"
                    }
                }
            } ] ],
            toolbar : "#busRecord",
            pagination : true,
            pageSize : 5,
            pageList : [5, 10, 15, 20 ],
            sortName : "id",
            sortOrder : "asc",
        })
    })


</script>
</body>
</html>
