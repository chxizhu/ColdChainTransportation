<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'echarts.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/echarts.min.js"></script>

  </head> 
  
  <body>
      <div id="bin" style="width: 600px;height:400px;position: absolute;margin-left:580px;" ></div>
      <div id="zhu" style="width: 600px;height:400px;"></div>
      
      <script src="js/jquery-3.3.1.js" charset="utf-8"></script>
	  <script src="layui/layui.js" charset="utf-8"></script>
      <script type="text/javascript">        
/*       myChart.setOption({
     tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b}: {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        x: 'left',
        data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
    },
    series: [
        {
            name:'访问来源',
            type:'pie',
            radius: ['50%', '70%'],
            avoidLabelOverlap: false,
            label: {
                normal: {
                    show: false,
                    position: 'center'
                },
                emphasis: {
                    show: true,
                    textStyle: {
                        fontSize: '30',
                        fontWeight: 'bold'
                    }
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data:[
                {value:335, name:'直接访问'},
                {value:310, name:'邮件营销'},
                {value:234, name:'联盟广告'},
                {value:135, name:'视频广告'},
                {value:1548, name:'搜索引擎'}
            ]
        }
    ]
      }) */
      
      var zchart = echarts.init($("#zhu")[0]);
  $.ajax({
   url : "Temperature/selectchart",
   type : "get",
   dataType : "json",
   success : function(dt) {
    var arrname=new Array();
    var arrvalue=new Array();
    for (var i = 0; i < dt.data.length; i++) {
     arrname.push(dt.data[i].nowtime);
     arrvalue.push(dt.data[i].realtimet)
    }
    zchart.setOption({
    title: {
            text: '温度时间柱状图',
            subtext: 'Example in MetricsGraphics',
            left: 'center'
        },
     tooltip : {},
     xAxis : {
      data : arrname,
     },
     yAxis : {},
     series : {
      name : '成绩人数',
      type : 'bar',
      data : arrvalue
     } 
    });
   }
  })
  
  var zcharts = echarts.init($("#bin")[0]);
  $.ajax({
   url : "Onenet/gettemp",
   type : "get",
   dataType : "json",
   success : function(dt) {
    var arrname=new Array();
    var arrvalue=new Array();
    for (var i = 0; i < dt.data.length; i++) {
     arrname.push(dt.data[i].nowtime);
     arrvalue.push(dt.data[i].realtimet)
    }
    zcharts.setOption({
    title: {
            text: '温度时间折线图',
            subtext: 'Example in MetricsGraphics',
            left: 'center'
        },
     tooltip : {},
     xAxis : {
      data : arrname,
     },
     yAxis : {},
     series : {
      name : '温度',
      type : 'line',
      data : arrvalue
     } 
    });
   }
  })
      </script>
  </body>
</html>
