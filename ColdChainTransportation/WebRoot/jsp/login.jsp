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
	<script type="text/javascript" src="layui/layui.all.js"></script>
	<script type="text/javascript" src="js/loadselect.js"></script>
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script>
		$(document).ready(function(){
		  $("#btnLogin").click(function(){
		    var stuId=$("#stuId").val().trim();
		    var stuPwd=$("#stuPwd").val().trim();
		    //alert(stuId+stuPwd);
		    if(stuId==null||stuId==""){
		    	layer.alert('账号不能为空', {
		    		title:"提示",
				  //icon: 1,
				  //skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
				})
		    }
		    else if(stuPwd==null||stuPwd==""){
		    	layer.alert('账号不能为空', {
		    		title:"提示",
				  //icon: 1,
				  //skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
				})
		    }
		    else{
		    	$.ajax({
		    		type: 'get',
					url: "user/tealogin",
					dataType: 'json',
					data:{
						teaId:stuId,
						teaPwd:stuPwd
					},
					success:function(data){
						if(data.code == 0){
							//layer.confirm(data.msg, {
								//icon: 1,
								//btn: ['确定']
							//},function(){
								window.location.href='index.html';
							//});
						}else{
							layer.confirm(data.msg, {
								icon: 6,
								btn: ['确定']
							});
						}
					},error:function(){
						layer.confirm('出现错误，删除失败，请重试！', {
						icon: 6,
						btn: ['确定']
						});
					},
		    	})
		    }
		  });
		});
	</script>
</body>
</html>