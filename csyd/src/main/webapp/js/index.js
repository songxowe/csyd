$(function() {
	// 树控件读取URL。子节点的加载依赖于父节点的状态。
	// 当展开一个封闭的节点，如果节点没有加载子节点，
	// 它将会把节点id的值作为http请求参数并命名为'id'，
	// 通过URL发送到服务器上面检索子节点
	// menuAction_index.action?id=1
	$("#tree").tree( {
		url : "menuController_index.do",
		lines : true,
		animate : true,
		onClick : function(data) {
			var flag = $("#divtabs").tabs("exists", data.text);
			if (!flag) {//选项卡面板不存在
				$("#divtabs").tabs("add", {
					title : data.text,
					closable : true,
					href : data.url
				});
			}
		}
	});
});