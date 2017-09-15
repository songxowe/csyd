<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
    <title>ECharts实例</title> 
    <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/easyui/themes/icon.css" />
<script src="${pageContext.request.contextPath }/resources/easyui/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/easyui/jquery.easyui.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/easyui/locale/easyui-lang-zh_CN.js"></script> 
  </head>  
  <body>  
    <!--Step:1 Prepare a dom for ECharts which (must) has size (width & hight)-->  
    <!--Step:1 为ECharts准备一个具备大小（宽高）的Dom-->  
    <div id="mainBar" style="height:500px;border:1px solid #ccc;padding:10px;"></div>  
      
    <!--Step:2 Import echarts.js-->  
    <!--Step:2 引入echarts.js-->  
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script> 
    

    


      
     <script type="text/javascript"> 
     var myChart; 
     // Step:3 conifg ECharts's path, link to echarts.js from current page.  
    // Step:3 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径  
    require.config({  
        paths: {  
            echarts: 'http://echarts.baidu.com/build/dist'  
        }  
    });  
      
    // Step:4 require echarts and use it in the callback.  
    // Step:4 动态加载echarts然后在回调函数中开始使用，注意保持按需加载结构定义图表路径  
    require(  
        [  
            //这里的'echarts'相当于'./js'  
            'echarts',  
            'echarts/chart/bar',  
            'echarts/chart/line',  
            'echarts/chart/pie'
        ],  
        //创建ECharts图表方法  
        function (ec) {  
            //--- 折柱 ---  
                //基于准备好的dom,初始化echart图表  
            var myChart = ec.init(document.getElementById('mainBar'));
            
            
            //定义图表option  
            var option = {  
                //标题，每个图表最多仅有一个标题控件，每个标题控件可设主副标题  
                title: {  
                    //主标题文本，'\n'指定换行  
                    text: '2017年湖南省移动产品统计报表',  
         /*                     //主标题文本超链接  
                    link: 'http://www.tqyb.com.cn/weatherLive/climateForecast/2014-01-26/157.html',  
                    //副标题文本，'\n'指定换行  
                    subtext: 'www.stepday.com',  
                    //副标题文本超链接  
                    sublink: 'http://www.stepday.com/myblog/?Echarts',  */ 
                    //水平安放位置，默认为左侧，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）  
                    x: 'left',  
                    //垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）  
                    y: 'top'  
                },  
                //提示框，鼠标悬浮交互时的信息提示  
                tooltip: {  
                    //触发类型，默认（'item'）数据触发，可选为：'item' | 'axis'  
                    trigger: 'axis'  
                },  
                //图例，每个图表最多仅有一个图例  
                legend: {  
                    //显示策略，可选为：true（显示） | false（隐藏），默认值为true  
                    show: true,  
                    //水平安放位置，默认为全图居中，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）  
                    x: 'center',  
                    //垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）  
                    y: 'top',  
                    //legend的data: 用于设置图例，data内的字符串数组需要与sereis数组内每一个series的name值对应  
                    data: ['销售量']  
                },  
                //工具箱，每个图表最多仅有一个工具箱  
                toolbox: {  
                    //显示策略，可选为：true（显示） | false（隐藏），默认值为false  
                    show: true,  
                    //启用功能，目前支持feature，工具箱自定义功能回调处理  
                    feature: {  
                        //辅助线标志  
                        mark: {show: true},  
                        //dataZoom，框选区域缩放，自动与存在的dataZoom控件同步，分别是启用，缩放后退  
                        dataZoom: {  
                            show: true,  
                             title: {  
                                dataZoom: '区域缩放',  
                                dataZoomReset: '区域缩放后退'  
                            }  
                        },  
                        //数据视图，打开数据视图，可设置更多属性,readOnly 默认数据视图为只读(即值为true)，可指定readOnly为false打开编辑功能  
                        dataView: {show: true, readOnly: true},  
                        //magicType，动态类型切换，支持直角系下的折线图、柱状图、堆积、平铺转换  
                        magicType: {show: true, type: ['line', 'bar']},  
                        //restore，还原，复位原始图表  
                        restore: {show: true},  
                        //saveAsImage，保存图片（IE8-不支持）,图片类型默认为'png'  
                        saveAsImage: {show: true}  
                    }  
                },  
                //是否启用拖拽重计算特性，默认关闭(即值为false)  
                calculable: true,  
                //直角坐标系中横轴数组，数组中每一项代表一条横轴坐标轴，仅有一条时可省略数值  
                //横轴通常为类目型，但条形图时则横轴为数值型，散点图时则横纵均为数值型  
                xAxis: [  
                    {  
                        //显示策略，可选为：true（显示） | false（隐藏），默认值为true  
                        show: true,  
                        //坐标轴类型，横轴默认为类目型'category'  
                        type: 'category',  
                        //类目型坐标轴文本标签数组，指定label内容。 数组项通常为文本，'\n'指定换行  
                        data: '[]'  
                    }  
                ],  
                //直角坐标系中纵轴数组，数组中每一项代表一条纵轴坐标轴，仅有一条时可省略数值  
                //纵轴通常为数值型，但条形图时则纵轴为类目型  
                yAxis: [  
                    {  
                        //显示策略，可选为：true（显示） | false（隐藏），默认值为true  
                        show: true,  
                        //坐标轴类型，纵轴默认为数值型'value'  
                        type: 'value',  
                        //分隔区域，默认不显示  
                        splitArea: {show: true}  
                    }  
                ],  
                  
                //sereis的数据: 用于设置图表数据之用。series是一个对象嵌套的结构；对象内包含对象  
                series: [  
                    {  
                        //系列名称，如果启用legend，该值将被legend.data索引相关  
                        name: '销售量',  
                        //图表类型，必要参数！如为空或不支持类型，则该系列数据不被显示。  
                        type: 'bar',  
                        //系列中的数据内容数组，折线图以及柱状图时数组长度等于所使用类目轴文本标签数组axis.data的长度，并且他们间是一一对应的。数组项通常为数值  
                        data: '[]',  
                        //系列中的数据标注内容  
                        markPoint: {  
                            data: [  
                                {type: 'max', name: '最大值'},  
                                {type: 'min', name: '最小值'}  
                            ]  
                        },  
                        //系列中的数据标线内容  
                        /* markLine: {  
                            data: [  
                                {type: 'average', name: '平均值'}  
                            ]  
                        }  */ 
                    },  
                /*     {  
                        //系列名称，如果启用legend，该值将被legend.data索引相关  
                        name: '降水量',  
                        //图表类型，必要参数！如为空或不支持类型，则该系列数据不被显示。  
                        type: 'bar',  
                        //系列中的数据内容数组，折线图以及柱状图时数组长度等于所使用类目轴文本标签数组axis.data的长度，并且他们间是一一对应的。数组项通常为数值  
                        data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],  
                        //系列中的数据标注内容  
                        markPoint: {  
                            data: [  
                                {type: 'max', name: '最大值'},  
                                {type: 'min', name: '最小值'}  
                            ]  
                        },  
                        //系列中的数据标线内容  
                        markLine: {  
                            data: [  
                                {type: 'average', name: '平均值'}  
                            ]  
                        }  
                    } */  
                ]  
            };  
                  
            //为echarts对象加载数据              
            myChart.setOption(option);
            
            $.ajax({
				type : 'post',
				url : 'findProduct',
				dataType : 'json',
				success : function(data) {
				
					option.xAxis[0].data=data.category;
					option.series[0].data=data.y;
	            
	              myChart.setOption(option);
				}
			})
			
           
              
             
        }
          
    ); 
 
     
    </script>  
  </body>  
</html>  