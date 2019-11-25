<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
	<meta charset="utf-8" />
	<title>车辆行驶轨迹</title>
	<style type="text/css">
		body, html{width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
		#map_canvas{width:100%;height:500px;}
		#result {width:50%}
	</style>
	<script src="//api.map.baidu.com/api?v=2.0&ak=hwFA0UIw2SlcFSPIYn7MGPAQemYzYXVj"></script>
	<script type="text/javascript" src="//api.map.baidu.com/library/LuShu/1.2/src/LuShu_min.js"></script>
</head>
<body>
	<div><h4>车辆行驶轨迹查看</h4></div>
	<div id="map_canvas"></div>
	<div id="result"></div>
	<button id="run">开始</button>
	<button id="stop">停止</button>
	<button id="pause">暂停</button>
	<!-- <button id="hide">隐藏信息窗口</button>
	<button id="show">展示信息窗口</button> -->
	<script>
	var map = new BMap.Map('map_canvas');
	map.enableScrollWheelZoom();
	map.centerAndZoom(new BMap.Point(116.404, 39.915), 13);
	
	var lushu;
	// 实例化一个驾车导航用来生成路线
    var drv = new BMap.DrivingRoute('北京', {
        onSearchComplete: function(res) {
            if (drv.getStatus() == BMAP_STATUS_SUCCESS) {
                var plan = res.getPlan(0);
                var arrPois =[];
                for(var j=0;j<plan.getNumRoutes();j++){
                    var route = plan.getRoute(j);
                    arrPois= arrPois.concat(route.getPath());
                }
                map.addOverlay(new BMap.Polyline(arrPois, {strokeColor: '#111'}));
                map.setViewport(arrPois);

                lushu = new BMapLib.LuShu(map,arrPois,{
                defaultContent:"",//"从天安门到百度大厦"
                autoView:true,//是否开启自动视野调整，如果开启那么路书在运动过程中会根据视野自动调整
                icon  : new BMap.Icon('http://lbsyun.baidu.com//jsdemo/img/car.png', new BMap.Size(52,26),{anchor : new BMap.Size(27, 13)}),
                speed: 4500,
                enableRotation:true,//是否设置marker随着道路的走向进行旋转
                landmarkPois: [
                   {lng:116.314782,lat:39.913508,html:'加油站',pauseTime:2},
                   {lng:116.315391,lat:39.964429,html:'高速公路收费<div><img src="//map.baidu.com/img/logo-map.gif"/></div>',pauseTime:3},
                   {lng:116.381476,lat:39.974073,html:'肯德基早餐',pauseTime:2}
                ]});
            }
        }
    });
	
    var start=new BMap.Point(103.00962233061672,25.242081114064987);
    var end=new BMap.Point(102.71460114,25.0491531);
	drv.search(start, end);
	
	
	
	//绑定事件
	$("run").onclick = function(){
		lushu.start();
	}
	$("stop").onclick = function(){
		lushu.stop();
	}
	$("pause").onclick = function(){
		lushu.pause();
	}
	$("hide").onclick = function(){
		lushu.hideInfoWindow();
	}
	$("show").onclick = function(){
		lushu.showInfoWindow();
	}
	
	
	function $(element){
		return document.getElementById(element);
	}	
</script>
</body>
</html>