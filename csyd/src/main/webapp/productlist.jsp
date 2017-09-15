<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="commons/taglib.jsp"%>
<html>
<head>
    <title>产品查看</title>
    <%@ include file="commons/meta.jsp"%>
</head>
<body>

<div id="searchProductForm1" style="padding: 10px;">
    <div id="editProduct">

    </div>
    <div style="padding: 0 0 0 6px;">
        产品名称：
        <input type="text" id="proName" class="easyui-textbox"/>
        状态：
        <select id="proStatus" class="easyui-combobox" name="proStatus" style="width: 100px">
            <option value="0">已下线</option>
            <option value="1">已上线</option>
        </select>
        &nbsp; &nbsp; &nbsp;
        <a href="#" class="easyui-linkbutton" iconCls="icon-search"
           onclick=product_obj.search();>查询</a>
    </div>
</div>
<div style="margin-top: 20px;">
    <table id="productDataGrid1">

    </table>
</div>
<script>
    $(function () {
        $("#productDataGrid1").datagrid({
            url:"productController_list",
            title:"产品列表",
            fitColumns : true,
            striped : true,
            rownumbers : true,
            columns:[[{
                field : "proId",
                title : "产品编号",
                width : 100,
                sortable : true,
                hidden:true
            },{
                field : "proName",
                title : "产品名称",
                width : 100,
                sortable : true
            },{
                field : "proType",
                title : "产品类型",
                width : 100,
                sortable : true
            },{
                field : "proCost",
                title : "产品资费",
                width : 100,
                sortable : true
            },{
                field : "proImg",
                title : "产品图片",
                width : 100,
                sortable : false,
                formatter:function (value,rowData,rowIndex) {
                    var proImg=rowData["proImg"];
                    if(proImg==null){
                        return "无";
                    }
                }
            },{
                field : "proStatus",
                title : "产品状态",
                width : 100,
                sortable : true,
                formatter:function (value,rowData,rowIndex) {
                    var count=rowData["proStatus"];
                    if(count==1){
                        return "已上线";
                    }
                    if(count==0){
                        return "已下线";
                    }
                },
                styler:function(value,rowData,index){
                    var count=rowData["proStatus"];
                    if (count ==1){
                        return 'color:blue;';
                    }else{
                        return 'color:red;';
                    }
                }
            },{
                field : "opl",
                title : "操作",
                width : 100,
                formatter:function (value,rowData,rowIndex) {
                    var proId =rowData["proId"];
                    return "<a href='#' onclick=getProduct("+proId+")>查看</a>"
                }
            }]],
            toolbar : "#searchProductForm1",
            pagination : true,
            pageSize : 2,
            pageList : [ 2, 5, 10, 15, 20 ],
            sortName : "proId",
            sortOrder : "asc",
        });
    });

    function getProduct(proId) {
        $("#editProduct").window({
            title : "查看产品详情",
            width : 550,
            height : 480,
            modal : true,
            minimizable : false,
            href : "productController_view.html?proId="+proId
        });
    }
</script>

<script>
    $(function () {
        product_obj = {
            search: function () {
                var proStatus = $('#proStatus').combobox('getValue');
                $("#productDataGrid1").datagrid(
                    "load",
                    {
                        proName: $.trim($("#proName").val()),
                        proStatus: proStatus
                    });
            }
        }
    })
</script>
</body>
</html>
