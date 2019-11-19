<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>网站用户管理</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="../layui/css/layui.css" media="all">
	<style>
		.blogUser-con .layui-table-view {
			border: none;
		}
		
		.blogUser-con .layui-table-box {
			margin-top: 10px;
		}
		
		.blogUser-con {
			padding: 0 15px 15px 15px;
			margin-bottom:50px;
		}
		.blogUser-con  .layui-table-tool-self{
			display:none;
		}
		.blogUser-con .not_border_left {
			border-left: none !important;
		}
		
		.blogUser-con .blogUser dl dd.layui-this {
			background-color: #1E9FFF !important;
		}
		
		.blogUser-con .hide {
			display: none;
		}
		
		.blogUser-con .show {
			display: block;
		}
		
		.blogUser-con .btn_size {
			height: 28px !important;
			line-height: 28px !important;
		}
		
		.blogUser-con .layui-table-body table tbody .layui-table-hover {
			background: #fffdd3 !important;
		}
		
		.blogUser-con .layui-table-body table tbody .layui-table-click {
			background: #fdef9b !important;
		}
		
		.blogUser-con .layui-table, .layui-table-view {
			border: none;
			margin-top: 0;
		}
		
		#add-blogUser {
			display: none;
			z-index: 999 !important;
		}
		
		#add-blogUser .artTypeLayer {
			height:500px;
			width: 90%;
			margin-left: auto;
			margin-right: auto;
			padding-top: 20px;
		}
		.adminuserdetail{
			padding:20px;
			display: none;
		}
		.adminuserdetail table tr td{
			padding: 15px;text-align: center;
		}
		.adminuserdetail .tdbck{
			background: #f2f2f2;
			width: 30%;
		}
	</style>
</head>
<body>
	<!--弹框调用内容Start-->
	<div id="adminuserdetail" class="adminuserdetail">			
		<table class="layui-table">
		    <tbody>
		      <tr>
		        <td class="tdbck">账号</td>
		        <td><span id="ckuserid"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">姓名</td>
		        <td><span id="ckusername"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">角色</td>
		        <td><span id="ckname"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">性别</td>
		        <td><span id="cksex"></span></td>
		      </tr>
		     <tr>
		        <td class="tdbck">电话</td>
		        <td><span id="ckphone"></span></td>
		      </tr>
		    </tbody>
		  </table>
	</div>
	<!--弹框调用内容END-->	

	<div class="blogUser-con">
		<!-- 条件筛选框Start -->
		<blockquote class="layui-elem-quote not_border_left">
			<form class="layui-form" action="">
			
			<div class="layui-form-item">
              <label for="phone" class="layui-form-label">
              	 姓名：
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="adminame" name="adminame" 
                  autocomplete="off" class="layui-input">
              </div>             
          </div>
          
          <div class="layui-form-item" style = "margin-left:270px;margin-top:-52px;position: absolute;">
              <label for="phone" class="layui-form-label">
              	 角色：
              </label>
              <div class="layui-input-inline">
                  <select name="role" id="role" lay-verify="required" lay-search="">
          <option value="">直接选择或搜索选择</option>
           <option value="管理员">管理员</option>
          <option value="值班经理">值班经理</option>
         </select>
              </div>             
          </div>
          <div class="layui-form-item" style = "margin-left:570px;margin-top:-52px;position: absolute;">
              <label for="phone" class="layui-form-label">
              	 性别：
              </label>
              <div class="layui-input-inline">
                  <select name="adminsex" id="adminsex" lay-verify="required" lay-search="">
          <option value="">直接选择或搜索选择</option>
          <option value="男">男</option>
          <option value="女">女</option>
         </select>
              </div>             
           </div>
            <div class="layui-inline" style = "margin-left:900px;margin-top:-52px;position: absolute;">
	     	   		<button id="btnselfrontinfo" type="button" class="layui-btn layui-bg-blue">查询</button>
			    </div>	
			    <div class="layui-inline" style = "margin-left:970px;margin-top:-52px;position: absolute;">  		   
				<button type="button" class="layui-btn layui-bg-blue" id="addartType" lay-event="addartType" lay-filter="addartType" style="margin-left: 10px;">添加用户</button>
				</div>
			</form>
		</blockquote>
		<!-- 条件筛选框End -->

		<table class="layui-hide" name="blogUser" id="blogUser" lay-filter="blogUser"></table>

		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="seluser">查看</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>

		<!-- 用户信息添加Start -->
		<div id="add-blogUser" >
			<div class="artTypeLayer">
				<form class="layui-form" action="">
				 <div class="layui-form-item">   
    <div class="layui-inline">
      <label class="layui-form-label">角色：</label>
      <div class="layui-input-block">
				       	 <select name="adminrole" id="adminrole" lay-filter="roleid">
						 <option value="00">请选择角色</option>						
						 </select>	
				      </div>
    </div>
    </div>
					
    			   <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
              	 账号：
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="userid" name="userid" 
                  autocomplete="off" class="layui-input">
              </div>             
          </div>
           <div class="layui-form-item">
              <label for="L_email" class="layui-form-label">
                                                       姓名：
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="username" name="username" 
                  autocomplete="off" class="layui-input">
              </div>              
          </div>
 			<div class="layui-form-item">
              <label for="L_email" class="layui-form-label">
                                                       性别：
              </label>
              <div class="layui-input-inline">
                  <input type="radio" name="sex" value="男" title="男">
      			  <input type="radio" name="sex" value="女" title="女">     
              </div>              
          </div>
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                                               密码：
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="userpwd" name="userpwd" 
                  autocomplete="off" class="layui-input">
              </div>             
          </div>  	
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                                               电话：
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="phone" name="phone" 
                  autocomplete="off" class="layui-input">
              </div>             
          </div>  
				</form>
			</div>
		</div>
		<!-- 用户信息添加End -->
		
	</div>
	<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
	<script>
	layui.use([ 'table', 'form', 'layer', 'laydate', 'laytpl', 'element' ], function() {
		var table = layui.table, form = layui.form, 
			layer = layui.layer, $ = layui.jquery,
			laydate = layui.laydate, laytpl = layui.laytpl,
			element = layui.element;
	
		/*加载表格*/
		table.render({
			elem : '#blogUser',
			id:'blogUserid',
			url : '../AdminUser/select',
			title : '用户添加',
			height: "full-160",
			skin : 'line',
			even : true,
			cols : [ 
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center',
					width : 80
				},{
					field : 'userid',
					title : '账号',
					align : 'center'
				}, {
					field : 'username',
					title : '姓名',
					align : 'center'
				}, {
					field : 'sex',
					align : 'center',
					title : '性别',
				}, {
					field : 'phone',
					align : 'center',
					title : '电话'
				},{
					title : '角色',
					field : 'name',
					align : 'center',
				},{
					title : '操作',
					toolbar : '#barDemo',
					align : 'center'
				} ] 
			 ],
			 page: {
					layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'],
					groups: 5,
					limit: 10,
					limits: [10, 20, 30, 40, 50],
					theme: '#1E9FFF',						
			 },
		});
		
		/* 点击查询对网站用户进行筛选 */
		$("#btnselfrontinfo").click(function(){
			var name=$("#adminame").val().trim();
			var role=$("#role").val().trim();
			var sex=$("#adminsex").val().trim();
			var param = '?name=' + name + '&role=' + role + '&sex=' + sex;
			
			table.render({
				elem : '#blogUser',
				url : '../AdminUser/mhselect' + param,
				title : '用户添加',
				height: "full-160",
				skin : 'line',
				even : true,
				cols : [ 
				       [{
					type : 'numbers',
					title : '序号',
					align : 'center',
					width : 80
				},{
					field : 'userid',
					title : '账号',
					align : 'center'
				}, {
					field : 'username',
					title : '姓名',
					align : 'center'
				}, {
					field : 'sex',
					align : 'center',
					title : '性别',
				}, {
					field : 'phone',
					align : 'center',
					title : '电话'
				},{
					title : '角色',
					field : 'name',
					align : 'center',
				},{
					title : '操作',
					toolbar : '#barDemo',
					align : 'center'
				} ] 
				 ],
				 page: {
					layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'],
					groups: 5,
					limit: 10,
					limits: [10, 20, 30, 40, 50],
					theme: '#1E9FFF',						
				 },
			});
		});
		
		/* 添加一个网站用户 */
		$("#addartType").click(function(){
			$("#userid").val("");
			$("#username").val("");
			$("#userpwd").val("");
			$("#phone").val("");
			
			layer.open({
				type : 1,
				title : '用户添加',
				area : [ '450px', '335px' ],
				shade : 0.4,
				content : $('#add-blogUser'),
				btn : [ '保存', '返回' ],
				yes : function() {
					var userid = $("#userid").val().trim();
					var username = $("#username").val().trim();
					var userpwd = $("#userpwd").val().trim();
					var phone = $("#phone").val().trim();
					var sex = $('input:radio:checked').val();
					var adminrole = $("#adminrole").val().trim();
					

					if(userid == "") {
						layer.tips('不能为空', '#userid');
						return;
					} 
					if(username==""){
						layer.tips('不能为空', '#username');
						return;
					}
					if(userpwd == "") {
						layer.tips('不能为空', '#userpwd');
						return;
					} 
					if(phone == "") {
						layer.tips('不能为空', '#phone');
						return;
					} 
					$.ajax({
						type : 'get',
						url : '../AdminUser/add?userid='+userid+'&username='+username+'&userpwd='+userpwd+'&adminrole='+adminrole+'&phone='+phone+'&sex='+sex,
						datatype : 'json',
						success : function(data) {
							if (data.code == "0") {
								layer.confirm(data.msg, {
								  btn: ['确定'],
								  icon:1
								}, function(){
									table.reload("blogUserid", { //此处是上文提到的 初始化标识id
						                where: {
						                	keyword:data.code=='10001'
						                }
						            });	
									layer.closeAll();
								});
							}else{
								layer.confirm(data.msg, {
								  btn: ['确定'],
								  icon:2
								});
								layer.setTop(layero);
							}
						},
						error : function() {}
					});						
				},
				btn2 : function() {layer.closeAll();}
			});
		});
		
		
	/* 动态加载用户角色 */
	$(function() {
				$.ajax({
					url : "../AdminRole/xlselect",
					type : "POST",
					data : null,
					dataType : 'json',
					contentType : 'application/json;charset=UTF-8',//contentType 很重要
					success : function(e) {
						//alert(e.msg+"\n"+e.flag+"\n"+ JSON.stringify(e));
						//alert(e.resultoObject[1]);
						var s = $("#adminrole").html();		
						var str = "";			
						for(var i=0;i<e.data.length;i++){					
							str += '<option value=' + e.data[i].id + '>' + e.data[i].name + '</option>';
						}
						$("#adminrole").append(str);
						form.render("select");
					},
					error : function(e) {
						alert("error:"+e.msg);
					}
		
				})
			});
		//表格工具栏事件 
		table.on('tool(blogUser)', function(obj) {
			var data = obj.data;
			$("#ckuserid").text(data.userid);
			$("#ckusername").text(data.username);
			$("#ckphone").text(data.phone);
			$("#cksex").text(data.sex);
			$("#ckname").text(data.name);
			
			switch (obj.event) {
				case 'seluser':
					layer.open({
				        type: 1, 
				        title: '管理员信息详情',
				        area: ['600px', '430px'],
				        shade: 0.8,
				        content: $('#adminuserdetail'),
				        btn: ['返回'], 
				        yes: function(){
				          layer.closeAll();
				          $(".adminuserdetail").css("display","none");
				        },
				        cancel: function(){ 
						  $(".adminuserdetail").css("display","none");
						}
				    });
				break;
				
				//删除按钮操作
				case 'del':
					layer.confirm('确定要删除么？', {
					  btn: ['确定','取消'],
					  icon:3
					}, function(){
						$.ajax({
			        		type: 'get',
			        		url: "../AdminUser/delect?userid=" + data.userid,
			        		dataType: 'json',
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
									  btn: ['确定']
									}, function(){
										table.reload("blogUserid", { //此处是上文提到的 初始化标识id
							                where: {
							                	keyword:data.code=='0'
							                }
							            });	
										layer.closeAll();
									});          				 
			        			}
			        			else{
			        				layer.confirm(data.msg, {
										  btn: ['确定']
									});
			        			}
			        		},
			        		error:function(){
			        			layer.confirm('出现错误，删除失败，请重试！', {
									  btn: ['确定']
								});
			        		},
			        	});   
					}, function(){ 
						layer.closeAll();
					});
				break;
				
			}
			;
		});
	
	});
	layui.use('upload', function(){
  var $ = layui.jquery
  ,upload = layui.upload;
  //普通图片上传
  var uploadInst = upload.render({
    elem: '#test1'
    ,url: 'FileUploadServlet.do'
    ,method: 'post'
    ,before: function(obj){
      //预读本地文件示例，不支持ie8
      obj.preview(function(index, file, result){
        $('#demo1').attr('src', result); //图片链接（base64）
         console.log(file);
      
         $("#photoid").attr("value",file.name);
         
      });
    }
  });
  
 
});
	</script>
</body>
</html>