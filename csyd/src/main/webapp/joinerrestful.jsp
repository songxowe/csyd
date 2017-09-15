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
    <div id="searchJoinerForm" style="padding: 10px;">
        <div style="padding: 0 0 0 6px;">
            代理商名称:
            <input type="text" id="joinerName" class="easyui-textbox"/>
            &nbsp;&nbsp;状态:
            <select  class="easyui-combobox" id="joinerStatus" style="width:200px;">
                <option value="">不限</option>
                <option value="0">未审核</option>
                <option value="1">已审核</option>
                <option value="2">未通过审核</option>
            </select>
            &nbsp;&nbsp;申请日期:
            <input type="text" id="beginDate" class="easyui-datebox">
            <input type="text" id="endDate" class="easyui-datebox">
            <a href="#" class="easyui-linkbutton" iconCls="icon-search"
               onclick=joiner_obj.search();>查询</a>&nbsp;&nbsp;
            <a href="#" class="easyui-linkbutton" iconCls="icon-add"
               onclick="joiner_obj.showJoiner('add')">添加</a>&nbsp;&nbsp;
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove"
               onclick="joiner_obj.remove()">删除</a>&nbsp;&nbsp;
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit"
               onclick="joiner_obj.showJoiner('edit')">修改</a>
        </div>
    </div>

    <!-- 雇员列表显示 -->
    <div style="margin-top: 20px;">
        <table id="joinerDataGrid">

        </table>

    </div>
    <div id="editJoiner">

    </div>
</div>
<script type="text/javascript">
    $(function () {
        joiner_obj={
            search:function () {//查询
                //获得值
                var joinerStatus = $('#joinerStatus').combobox('getValue');
                var beginDate = $('#beginDate').combobox('getValue');
                var endDate = $('#endDate').combobox('getValue');
                $("#joinerDataGrid").datagrid(
                    "load",
                    {
                        joinerName:$.trim($("#joinerName").val()),
                        joinerStatus:joinerStatus,
                        beginDate:beginDate,
                        endDate:endDate
                        //joinerStatus:$("#joinerStatus").val(),这样拿不到值
                       // joinerDate:$("#joinerDate").val()
                    }
                )
            },
            showJoiner : function(state){
                var url = "joinerFindId";
                var info = "";
                var id=0;
                if(state=="add"){
                    info="新增代理商"
                }else{
                    info="修改雇员信息"
                    var rows=$("#joinerDataGrid").datagrid("getSelections");
                    if(rows.length==1){
                        id=rows[0].joinerId;
                        url+="?joinerId="+id;
                    }else{
                        $.messager.alert("警告", "必须选中一行", "warning");
                        return;
                    }
                }
                $("#editJoiner").window({
                    title : info,
                    width : 640,
                    height : 550,
                    modal : true,
                    minimizable : false,
                    href : url,
                    onClose : function(){
                        $("#joinerDataGrid").datagrid(
                            "reload");
                        //$('#dept').combobox('reload');
                    }
                });
            },remove : function(){
                var rows = $("#joinerDataGrid").datagrid("getSelections");
                if(rows.length > 0) {
                    $.messager.confirm("消息","确认真的要删除所选的数据吗",function(flag){
                        if(flag){
                            var ids = [];
                            for(var i=0;i<rows.length;i++){
                                ids.push(rows[i].joinerId);
                            }
                            $.ajax({
                                type : "GET",
                                url : "joinerRemove",
                                data : {
                                    ids : ids.join(","),
                                },
                                beforeSend : function(){
                                    $("#empDataGrid").datagrid("loading");
                                },
                                success : function(data){
                                    if(data) {
                                        $("#joinerDataGrid").datagrid("loaded");
                                        $("#joinerDataGrid").datagrid("load");
                                        $("#joinerDataGrid").datagrid("unselectAll");
                                        $.messager.show({
                                            title : "提示",
                                            msg : data + "个代理商被删除"
                                        });
                                       // $('#dept').combobox('reload');
                                    }
                                }
                            });
                        }
                    });
                }else {
                    $.messager.alert("警告", "请选中要删除的数据","warning");
                }
            },
        }
        $("#joinerDataGrid").datagrid( {
            url : "joiner",
            method:"GET",
            title : "雇员列表",
            fitColumns : true,
            striped : true,
            rownumbers : true,
            columns : [ [{
                field:'joinerId',
                title:'编号',
                checkbox:true
            }, {
                field : "joinerName",
                title : "一级代理商名称",
                width : 100,
                sortable : true,
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
                    return "<a href='#' onclick=getJoiner("+joinerId+")>查看</a>"
                }
            } ] ],
            toolbar : "#searchJoinerForm",
            pagination : true,
            pageSize : 5,
            pageList : [ 5, 10, 15, 20, 50 ],
            sortName : "joinerId",
            sortOrder : "asc",
        });
    })
    function getJoiner(joinerId){
        $("#editJoiner").window({
            title : "查看供应商详情",
            width : 640,
            height : 550,
            modal : true,
            minimizable : false,
            href : "joiner/"+joinerId
        });
    }
</script>
</body>
</html>
