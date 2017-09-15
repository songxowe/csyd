<%--
  Created by IntelliJ IDEA.
  User: 鲁靖大大
  Date: 2017/8/16
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>供应商管理</title>
    <%@ include file="commons/meta.jsp"%>
</head>
<body>
<div style="margin: 10px 30px;">

    <!-- 供应商列表的工具栏设置 -->
    <div id="joinerAuditForm" style="padding: 10px;">
        <div style="padding: 0 0 0 6px;">
            代理商名称:
            <input type="text" id="joinerName" class="easyui-textbox"/>

            &nbsp;&nbsp;申请日期:
            <input type="text" id="beginDate" class="easyui-datebox">
            <input type="text" id="endDate" class="easyui-datebox">
            <a href="#" class="easyui-linkbutton" iconCls="icon-search"
               onclick=joiner_obj.search();>查询</a>
        </div>
    </div>

    <!-- 雇员列表显示 -->
    <div style="margin-top: 20px;">
        <table id="joinerAuditDataGrid">

        </table>

    </div>
    <div id="editJoinerAudit">

    </div>
</div>
<script type="text/javascript">
    $(function () {
        joiner_obj={
            search:function () {//查询
                //获得值
                var beginDate = $('#beginDate').combobox('getValue');
                var endDate = $('#endDate').combobox('getValue');
                $("#joinerAuditDataGrid").datagrid(
                    "load",
                    {
                        joinerName:$.trim($("#joinerName").val()),

                        beginDate:beginDate,
                        endDate:endDate
                       // joinerDate:$("#joinerDate").val()
                    }
                )
            },
            showJoiner : function(state){
                var url = "addJoiner.jsp";
                var info = "新增供应商信息";
                $("#editJoinerAudit").window({
                    title : info,
                    width : 640,
                    height : 550,
                    modal : true,
                    minimizable : false,

                    href : url,

                });
            }
        }
        $("#joinerAuditDataGrid").datagrid( {
            url : "joiner?&joinerStatus=0",
            method:"GET",
            title : "雇员列表",
            fitColumns : true,
            striped : true,
            rownumbers : true,
            columns : [ [ {
                field : "joinerName",
                title : "一级代理商名称",
                width : 100,
                sortable : true
            }, {
                field : "joinerLinkname",
                title : "代理商联系人",
                width : 100,
                sortable : true
            } , {
                field : "organ",
                title : "所属上级组织",
                width : 100,
                sortable : true
            } , {
                field : "joinerDate",
                title : "申请日期",
                width : 100,
                sortable : true
            } , {
                field : "joinerStatus",
                title : "状态",
                width : 100,
                sortable : true,
                formatter:function (value, rowData, rowIndex) {
                    var joinerStatus=rowData["joinerStatus"];
                    if(joinerStatus=='0'){
                        return "<span style='color: crimson'>未审核</span>";
                    }else if(joinerStatus=='1'){
                        return "已审核";
                    }else if(joinerStatus=='2'){
                        return "未通过审核";
                    }
                }
            } ,{
                field : "op1",
                title : "操作",
                width : 100,
                formatter : function(value, rowData, rowIndex){
                    var joinerId = rowData["joinerId"];
                    return "<a href='#' onclick=setJoiner("+joinerId+")>审核</a>&nbsp;&nbsp;<a href='#' onclick=getJoiner("+joinerId+")>查看</a>"
                }
            } ] ],
            toolbar : "#joinerAuditForm",
            pagination : true,
            pageSize : 5,
            pageList : [ 5, 10, 15, 20, 50 ],
            sortName : "joinerId",
            sortOrder : "asc",
        });
    })
    function getJoiner(joinerId){
        $("#editJoinerAudit").window({
            title : "查看供应商详情",
            width : 640,
            height : 550,
            modal : true,
            minimizable : false,
            href : "joiner/"+joinerId
        });
    }
    function setJoiner(joinerId){
        $("#editJoinerAudit").window({
            title : "审核供应商",
            width : 640,
            height : 550,
            modal : true,
            minimizable : false,
            href : "joinerSet/"+joinerId
        });
    }
</script>
</body>
</html>
