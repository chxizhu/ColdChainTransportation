<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>后台管理</title>
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="../css/font.css">
		<link rel="stylesheet" href="../css/index.css">
		<link rel="stylesheet" href="../layui/css/layui.css" />
		<style type="text/css">
		.layui-tab-title li .layui-tab-close{
			display:none;
		}
		.navacolor{
			color:#148cf1;
		}
		</style>
	</head>
	<body>
		<!-- 顶部开始 -->
	<div class="container" id="layerDemo">
		<div class="logo">
			<a href="index.html">冷链运输管理平台</a>
		</div>
		<!-- 图标展开左侧栏开始 -->
		<div class="left_open">
			<!--<i title="展开左侧栏" class="iconfont">&#xe699;</i>-->
			<i title="展开左侧栏" class="layui-icon layui-icon-shrink-right"></i>

		</div>		
		<!-- 新增结束 -->
		<!-- '管理员'及 '前台首页'开始 -->
		<ul class="layui-nav right" lay-filter="">
		
		<li class="layui-nav-item to-index">				
				<a href="javascript:;">用户角色：${loginUser.name }</a>
			</li>			
			<li class="layui-nav-item">
				<a href="javascript:;">${loginUser.username }</a>				
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->
					<dd>
						<button class="layui-btn" onclick="x_admin_show('添加评分项','Car.jsp')">个人信息</button> 
					</dd>					
				</dl>
			</li>	
			
			<li class="layui-nav-item "><button data-method="confirmTrans"
						class="layui-btn layui-btn-danger"">退出</button></li>
		</ul>
	</div>
	<!-- 顶部结束 -->
		
		<!-- 中部开始 -->
		<!-- 左侧菜单开始 -->
		<div class="left-nav" style="overflow-x: hidden; width:200px;">
			<div id="side-nav" style="overflow-x: hidden;height:100%">
				<ul id="nav">	
				</ul>
			</div>
		</div>
		<!-- 左侧菜单结束 -->
		
		<!-- 右侧主体开始 -->
		<div class="page-content">
			<div class="layui-tab tab" lay-filter="wenav_tab" id="WeTabTip" lay-allowclose="true">
				<ul class="layui-tab-title" id="tabName">
					<li id="liformtitle">我的桌面</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">
						<iframe id="ifram1" src="homePage.jsp" frameborder="0" scrolling="yes" class="weIframe"></iframe>
					</div>
				</div>
			</div>
		</div>
		<!-- 右侧主体结束 -->
		<!-- 中部结束 -->
		
		<!-- 底部开始 -->
		<div class="footer">
			<center>
			<div class="copyright">Copyright ©2018 云南工商学院.软件技术</div>
			</center>
		</div>
		<!-- 底部结束 -->
		
		<script type="text/javascript" src="../layui/layui.all.js" charset="utf-8"></script>
		<script type="text/javascript" src="../js/jquery-3.3.1.js" ></script>
		<script type="text/javascript" src="../js/admin.js" ></script>
		
		<script type="text/javascript">
		layui.use('layer', function() { //独立版的layer无需执行这一句
			var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
			//触发事件
			var active = {
				confirmTrans : function() {
					//配置一个透明的询问框
					layer.msg('确定要退出嘛？', {
						time : 20000, //20s后自动关闭
						btn : [ '确定', '取消' ],
						yes : function(index, layero) { // 默认的是 按钮一
							sessionStorage.clear()
							window.location.reload()
							window.location.href = "login.jsp"
						}
					});
				}
			};

			$('#layerDemo .layui-btn').on('click', function() {
				var othis = $(this), method = othis.data('method');
				active[method] ? active[method].call(this, othis) : '';
			});
		});
		
		function x_admin_show(title,url,w,h){
	    if (title == null || title == '') {
	        title=false;
	    };
	    if (url == null || url == '') {
	        url="404.html";
	    };
	    if (w == null || w == '') {
	        w=($(window).width()*0.9);
	    };
	    if (h == null || h == '') {
	        h=($(window).height() - 50);
	    };
	    layer.open({
	        type: 2,
	        area: [w+'px', h +'px'],
	        fix: false, //不固定
	        maxmin: true,
	        shadeClose: true,
	        shade:0.4,
	        title: title,
	        content: url
	    });
	}
	</script>
	</body>
</html>