<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta charset="utf-8">
<link rel="icon" href="https://static.jianshukeji.com/highcharts/images/favicon.ico">
<meta name="viewport" content="width=device-width, initial-scale=1">	<script src="https://code.highcharts.com.cn/highcharts/modules/exporting.js"></script>
	<script src="https://code.highcharts.com.cn/highcharts/highcharts.js"></script>
	<script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
	<script src="../js/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="../layui/css/layui.css">
</head>
<body>
<div id="container" style="min-width:400px;height:400px"></div>
<hr/>
        <div class="layui-container">
				<form class="layui-form">
					<div class="layui-form-item">
						<div class="layui-inline" style="width:100px;">						
						</div>					
					<div id="main" style="width:800px;height:400px;"></div>
				</form>
			</div>
<script src="../js/tempx.js"></script>
<script src="../js/echarts.min.js"></script>
<script src="../js/jquery-3.3.1.js"></script>
<script src="../layui/layui.js" charset="utf-8"></script>

</body>
</html>