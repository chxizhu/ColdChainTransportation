<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>首页</title>
		<link rel="stylesheet" href="../layui/css/layui.css" />
		<style>
			body{
				overflow: hidden;
			}
			.homepage-con{
				width: 100%;
				height: 100%;
				text-align: center;
				padding: 0px 15px 15px;
			}
			.homepage-con h1{
				color: rgb(38,149,162);
				font-size: 70px;
				font-weight: 500;
				margin-top: 150px;
			}
		</style>
	</head>
	<body>
		<div class="homepage-con">
			<h1>冷链运输管理平台</h1>
		</div>
		<script type="text/javascript" src="../layui/layui.js" ></script>
	</body>
</html>
