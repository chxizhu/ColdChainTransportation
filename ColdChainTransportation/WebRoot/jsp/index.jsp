<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png" />
	<link rel="icon" type="image/png" href="../assets/img/favicon.png" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>临床护理教学管理平台</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <!-- Bootstrap core CSS     -->
    <link href="../css/bootstrap.min.css" rel="stylesheet" />

    <!--  Material Dashboard CSS    -->
    <link href="../css/material-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="../css/demo.css" rel="stylesheet" />

    <!--     Fonts and icons     -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href='css/2d7207a20f294df196f3a53cae8a0def.css' rel='stylesheet' type='text/css'>
</head>
<body>

	<div class="wrapper">

	    <div class="sidebar" data-color="purple" data-image="../assets/img/sidebar-1.jpg">
			<!--
		        Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

		        Tip 2: you can also add an image using data-image tag
		    -->

			<div class="logo">
				<img src="../images\logo.jpg">
				<a href="#" class="simple-text">
				<span class="logo_n">冷链运输管理</span>
					
				</a>
			</div>

	    	<div class="sidebar-wrapper">
	            <ul class="nav">
	                
	                <li  class="active">
	                    <a href="class.html" target="right" >
	                        <i class="material-icons">domain</i>
	                        <p>班级管理</p>
	                    </a>
					</li>
					<li>
							<a href="product.html" target="right" onclick="fold()">
								<i class="material-icons">account_circle</i>
								<p>用户管理</p>
							</a>
							<ul class="nav_kids" id="custom" style="display: none">
									<li>
											<a href="teacher.html" target="right" >
											
												<p >教师管理</p>
											</a>
									</li>
									<li>
											<a href="student.html" target="right" class="kids">
												
												<p >学生管理</p>
											</a>
									</li>
									
							</ul>
						</li>
	                <li>
	                    <a href="score.html" target="right">
	                        <i class="material-icons">content_paste</i>
	                        <p>成绩管理</p>
	                    </a>
	                </li>
	                <li>
	                    <a href="product.html" target="right" onclick="unfold()">
	                        <i class="material-icons">perm_contact_calendar</i>
	                        <p>病人管理</p>
						</a>
						<ul class="nav_kids" id="nav_kids" style="display: none">
								<li>
										<a href="patientsInfo.html" target="right" >
										
											<p>病人基本信息</p>
										</a>
								</li>
								<li>
										<a href="user.html" target="right" class="kids">
											
											<p>日常生活状况管理</p>
										</a>
								</li>
								<li>
										<a href="user.html" target="right" >
											
											<p>检查管理</p>
										</a>
								</li>
								<li>
										<a href="user.html" target="right" >
											
											<p>现病史管理</p>
										</a>
								</li>
								<li>
										<a href="user.html" target="right" >
											
											<p>主诉管理</p>
										</a>
								</li>
								
						</ul>
	                </li>
	               
	                
	              
	            </ul>
	    	</div>
	    </div>

	    <div class="main-panel">
			<nav class="navbar navbar-transparent navbar-absolute" style="background-color: #fff;">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div>
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav navbar-right">
							<li>
								<a href="#pablo" class="dropdown-toggle" data-toggle="dropdown">
									
									<p class="welcome">欢迎您！<span>李师傅</span></p>
								</a>
								<ul class="dropdown-menu">
									<li><a href="#">退出</a></li>
								</ul>
							</li>
							<!-- <li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<div> <img src="../images\head.jpg" class="user_h"></div>
									

								</a>
								<ul class="dropdown-menu">
									<li><a href="#">退出</a></li>
								</ul>
							</li> -->
							
						</ul>

					
					</div>
				</div>
			</nav>

			<div class="content">
				<div class="container-fluid">
					<div class="row" style="margin-top: -15px;">
						
				
						<iframe src="class.html" width="100%" height="760" name="right" style="border: none;"></iframe>

				
				</div>
			</div>

		
		</div>
	</div>

</body>

	<!--   Core JS Files   -->
	<script src="../js/jquery-3.1.0.min.js" type="text/javascript"></script>
	<script src="../js/bootstrap.min.js" type="text/javascript"></script>
	<script src="../js/material.min.js" type="text/javascript"></script>

	<!--  Charts Plugin -->
	<script src="../js/chartist.min.js"></script>



	<script src="../js/material-dashboard.js"></script>

	<!-- Material Dashboard DEMO methods, don't include it in your project! -->
	
	<script type="text/javascript" src="myplugs/js/plugs.js">
		</script>
		<script type="text/javascript">
			//添加编辑弹出层
			function updatePwd(title, id) {
				$.jq_Panel({
					title: title,
					iframeWidth: 500,
					iframeHeight: 300,
					url: "updatePwd.html"
				});
			}
		</script>


	<script type="text/javascript">
    	$(document).ready(function(){

$(".nav li").click(function(){
	
	$(".nav li").removeClass("active");
	$(this).addClass("active");
	
});
$(".nav_kids li").click(function(){
	
	$(".nav_kids li").removeClass("active");
	$(this).addClass("active");
	
})

			// Javascript method's body can be found in assets/js/demos.js

    	});
	</script>

</html>
