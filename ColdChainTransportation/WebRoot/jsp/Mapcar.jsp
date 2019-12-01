<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="//api.map.baidu.com/api?v=2.0&ak=hwFA0UIw2SlcFSPIYn7MGPAQemYzYXVj"></script>
	<script type="text/javascript" src="http://blog.aigouzhushou.com/layui-v2.4.3/layui-v2.4.5/layui.js"></script>
	<link rel="stylesheet" href="http://blog.aigouzhushou.com/layui-v2.4.3/layui-v2.4.5/css/layui.css" />
	<title>线路站点信息添加</title>
	<style type="text/css">
		body, html{width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>
</head>
<body>
	 <div class="layui-form-item">
		 <div class="layui-inline">
		   <label class="layui-form-label">站点名称:</label>
		   <div class="layui-input-inline">
		     <input type="text" id="name" name="phone" class="layui-input">
		   </div>
		 </div>
	     <div class="layui-inline">
	       <label class="layui-form-label">经度:</label>
	       <div class="layui-input-inline">
	         <input type="text" id="lng" name="phone" class="layui-input">
	       </div>
	     </div>
	     <div class="layui-inline">
	       <label class="layui-form-label">纬度:</label>
	       <div class="layui-input-inline">
	         <input type="text" id="lat" class="layui-input">
	       </div>
	     </div>
		  <div class="layui-inline">
		 <button type="button" id="btn" class="layui-btn">添加</button>
		 </div>
	   </div>
	   
	<div id="allmap" style="width: 100%;height: 100%;"></div>
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
  
	var map = new BMap.Map("allmap");   
			 
	map.centerAndZoom("云南",12);  
	map.enableScrollWheelZoom(true);
		map.disableDragging();     //禁止拖拽
		setTimeout(function(){
		   map.enableDragging();
			  
			  	}, 2000);//两秒后开启拖拽
	//单击获取点击的经纬度
	map.addEventListener("click",function(e){
      var point = new BMap.Point(e.point.lng,e.point.lat);
      var marker = new BMap.Marker(point);  // 创建标注
	  map.addOverlay(marker); // 将标注添加到地图中
	  $("#lng").val(e.point.lng);
	  $("#lat").val(e.point.lat);
      /* alert(e.point.lng + "," + e.point.lat); */
	});
	
	$("#btn").click(function(){
						var lng=$("#lng").val().trim();
						var lat=$("#lat").val().trim();
						var name=$("#name").val().trim();
						var data={lng:lng,lat:lat,name:name};
						
				$.ajax({
						type : 'post',
						url : '../TPunchTheTloc/add',
						data:data,
						datatype : 'json',
						success : function(data) {
							if (data.code == "0") {
								alert("添加成功");
							}else{
								alert("添加失败");
							}
						},
						error : function() {}
					});				
					 	
						});					
					
</script>