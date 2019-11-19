<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="../css/amazeui.min.css" />
    <style>
        .logininfo{
            height: 380px;
            background-color: #fff;
            padding: 50px;
        }     
        .btnlogin{
            background-color: #19A97B;
            color: #fff;
            border: none;
        }
        .forget{
            font-size: 14px;
            color: darkgrey;
            width: 100px;
        }
        .denglu{
            
            text-align: center;
            font-size: 26px;
            letter-spacing: 30px;
        }
        body{
          
            background-image: url("../images/login3.jpg");
            background-size: cover;
        }
        .am-form{
            padding: 10px;
        }
        .title_login{
            height: 380px;
            background-color: #19A97B;
            border-right: 2px solid #268E83;
            text-align: center;
        }
        .loginbox{
            height: 380px;
            width: 700px;
            margin-top: 200px;
            box-shadow: 20px 20px 10px #020F0B;
        }
        .title_login img{
           
            width: 250px;
            margin-top: 50px;
            padding:40px 0;
        }
        .tit_log{
            font-size: 24px;
            line-height: 100px;
            font-weight: 700;
            color: #0D543D;
           
            
        }
        .bigbox{
            position: fixed;
            width: 100%;
    height: 100%;
    background: rgba(0,0,0,.7);
}
    </style>
</head>
<body>
       <div class="bigbox">
        <div class="am-g loginbox">
        <div class="am-u-lg-5 am-u-md-5  title_login">
            <img src="../images/logo.png">
            <span class="tit_log">冷链运输管理平台</span>
        </div>
          <div class="am-u-lg-7 am-u-md-7 logininfo">
              
            <form method="post" class="am-form">
              <label for="account">账号:</label>
              <input type="email" name="" id="stuId" value="">
              <br>
              <label for="password">密码:</label>
              <input type="password" name="" id="stuPwd" value="">
              <br>
              <label for="remember-me">
                    <a href="#" class="forget">忘记密码？</a>
              </label>
              <br>
              <div class="am-cf">
               
               
                <button type="button" class="am-btn am-btn-default am-btn-block btnlogin" id="btnLogin">登录</button>
              </div>
            </form>
           
          </div>
        </div>
    </div>
	<script type="text/javascript" src="../layui/layui.all.js"></script>
	<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
	<script>
				layui.use(['form','layer'], function(){
					var layer = layui.layer
					var form = layui.form;	  
					var $ = layui.jquery;					
					/* 点击登录 */
					$("#btnLogin").click(function(){
						var username=$("#stuId").val().trim();
						var password=$("#stuPwd").val().trim();
				
					 	if(username==null || username=="" || username==undefined){
							$("#user_name").focus();
							return;
						}
						if(password==null || password=="" || password==undefined){
							$("#user_password").focus();
							return;
						}
						if(password.length<6 || password.length>18){
							layer.alert('密码长度不符合规范!', {icon: 2});
							return;
						} 						
						/*
						var enpwd = hex_md5(fix(Encryption_key,password));
						$("#inppassword").val(enpwd);
						*/
						 var index = layer.load(0, {shade: 0.1});
						$.ajax({
		 					 url : '../Admin/AdminLogin?userid='+username+'&userpwd='+password, 
							datatype : 'json',
							success : function(data) {
								if (data.code == 0) {
								/* $(function(){
									    $.ajax({url:"controller/selecFY",
									    success:function(result){
									        
									    }});
									}); */
									window.location.href = "index.jsp";
									
								} else {
									layer.alert(data.msg, {icon: 2});
									layer.close(index);
									$("input").val("");
								}
							},
							error:function(e){
			    	        	 layer.alert(e.msg); 	
								/*  layer.alert('登录失败!', {icon: 2});		 */					 
			    	        }
						}); 						
					});					
				});
			</script>
</body>
</html>