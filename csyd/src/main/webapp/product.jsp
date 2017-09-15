<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="commons/taglib.jsp"%>
<html>
<head>
    <title>产品管理</title>
    <%@ include file="commons/meta.jsp"%>
</head>
<body>
<div style="margin: 10px 30px;">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add"
       onclick="product_obj.showEdit('add')">添加</a>&nbsp;&nbsp;
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove"
       onclick="product_obj.remove()">删除</a>&nbsp;&nbsp;
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit"
       onclick="product_obj.showEdit('edit')">修改</a>
    <div id="editProduct">

    </div>
    <div id="searchProductForm" style="padding: 10px;">
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

    <!-- 菜单列表显示 -->
    <div style="margin-top: 20px;">
        <table id="productDataGrid">

        </table>

    </div>
</div>
<script>
    $(function () {
        $("#productDataGrid").datagrid({
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
            toolbar : "#searchProductForm",
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
               product_obj={
                   search:function () {
               var proStatus=$('#proStatus').combobox('getValue');
               $("#productDataGrid").datagrid(
                   "load",
                   {
                       proName : $.trim($("#proName").val()),
                       proStatus : proStatus
                   });
           },
           remove:function () {
               var rows = $("#productDataGrid").datagrid("getSelections");
               if(rows.length>0){
                   $.messager.confirm("消息","确认真的要删除所选的数据吗",function(flag){
                       if(flag){
                           var ids=[];
                           for(var i=0;i<rows.length;i++){
                               ids.push(rows[i].proId);
                           }
                           $.ajax({
                               type:"post",
                               url : "productController_remove.html",
                               data:{
                                   ids : ids.join(","),
                               },
                               beforeSend : function(){
                                   $("#productDataGrid").datagrid("loading");
                               },
                               success:function (data) {
                                   if(data){
                                       $("#productDataGrid").datagrid("loaded");
                                       $("#productDataGrid").datagrid("load");
                                       $("#productDataGrid").datagrid("unselectAll");
                                       $.messager.show({
                                           title : "提示",
                                           msg : data + "个产品被删除"
                                       });
                                       $('#proStatus').combobox('reload');
                                   }
                               }
                           });
                       }
                   });
               }else{
                   $.messager.alert("警告", "请选中要删除的数据","warning");
               }
           },
           showEdit : function(state){
               var url = "productController_findById";
               var info = "";
               var id = 0;
               if (state == 'add'){
                   info = "新增产品信息";
               }else{
                   info = "修改产品信息";
                   var rows = $("#productDataGrid").datagrid("getSelections");
                   if(rows.length==1){
                       id=rows[0].proId;
                       url+="?proId="+id;
                   }else{
                       $.messager.alert("警告", "必须选中一行", "warning");
                       return;
                   }
               }
               $("#editProduct").window({
                   title : info,
                   width : 550,
                   height : 480,
                   modal : true,
                   minimizable : false,
                   href : url,
                   onClose : function(){
                       $("#productDataGrid").datagrid(
                           "reload")
                   }
               });
           }
       }
    })
</script>

</body>
</html>
