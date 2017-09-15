<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>
<html>
<head>
    <title>我的佣金</title>
    <%@ include file="commons/meta.jsp"%>
</head>
<body>
<div style="margin: 10px 30px;">
    <div id="sellerSal" style="padding: 10px;">
        <div style="padding: 0 0 0 6px;">
            业务办理时间:
            <input type="date" id="beginDate" value="" class="easyui-datebox">
            至
            <input type="date" id="endDate" value="" class="easyui-datebox">
            业务名称：
            <input type="text" id="proName" value="" class="easyui-textbox"/>
            是否结算：
            <select id="busStatus">
                <option value="-1">请选择</option>
                <option value="1">是</option>
                <option value="0">否</option>
            </select>
            <a href="#" class="easyui-linkbutton" iconCls="icon-search"
               onclick=busRecord_obj.search();>查询</a>
        </div>
    </div>

    <div style="margin-top: 20px;">
        <table id="sellerSalDataGrid">

        </table>

    </div>
</div>
<script type="text/javascript">
    $(function () {
        busRecord_obj = {
            search:function () {
                $("#sellerSalDataGrid").datagrid(
                    "load",{
                        proName:$.trim($("#proName").val()),
                        beginDate:$("#beginDate").datebox('getValue'),
                        endDate:$("#endDate").datebox('getValue'),
                        busStatus:$("#busStatus").val()
                    }
                )
            }
        }

        $("#sellerSalDataGrid").datagrid({
            url:"SellerSalController",
            title:"我的佣金",
            fitColumns : true,
            striped : true,
            rownumbers : true,
            columns : [ [ {
                field : "busOpen",
                title : "时间",
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
                field : "proMonth",
                title : "所得佣金",
                width : 100,
                sortable : true
            },{
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
            } ] ],
            toolbar : "#sellerSal",
            pagination : true,
            pageSize : 5,
            pageList : [5, 10, 15, 20 ],
            sortName : "busOpen",
            sortOrder : "asc",
        })
    })


</script>
</body>
</html>
