<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>网站用户管理</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="../layui/css/layui.css" media="all">
		<link rel="stylesheet" href="../css/call.css" media="all">
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
			height:350px;
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
			width: 20%;
		}
	</style>
</head>
<body>
	<!--弹框调用内容Start-->
	<div id="adminuserdetail" class="adminuserdetail">			
		<table class="layui-table" style="width:450px">
		    <tbody>
		      <tr>
		        <td class="tdbck">账号</td>
		        <td><span id="userid"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">姓名</td>
		        <td><span id="username"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">性别</td>
		        <td><span id="sex"></span></td>
		      </tr>
		     <!--  <tr>
		        <td class="tdbck">电话</td>
		        <td><span id="tel"></span></td>
		      </tr> -->
		      <tr>
		        <td class="tdbck">状态</td>
		        <td><span id="status"></span></td>
		      </tr>
		     
		    </tbody>
		  </table>
		  
		   <div id="call-top-right">
            <img src="../images/callPhone.png" width="200" height="200" id="demo-img" />
        </div>
		  
		 <div class="layui-card button-card" id="callcard">      
        <div class="layui-card-body">
            <p id="button-area">
                <input type="text" name="T1" model="tel"  size="20" id="dialcode" style="margin-left:100px;height:30px;" readonly="readonly">
                <button class="layui-btn layui-btn-danger" name="B10" onClick="TV_StartDial(0, dialcode.value); TV_EnableMic(0, TRUE); TV_EnableLine2Spk(0, TRUE)" id="dialing"> 拨号</button>
                <!-- 点击拨号按钮之后，拨号，打开MIC，打开耳机 -->
                <button class="layui-btn layui-btn-normal" name="B7" onClick="TV_OffHookCtrl(0)"> 摘机</button>
                <button class="layui-btn layui-btn-normal" name="B8" onClick="TV_HangUpCtrl(0); TV_EnableMic(0, FALSE); TV_EnableLine2Spk(0, FALSE); CloseDevice(ODT_LBRIDGE, function (nResult) { AppendStatus('关闭设备.'); });"> 挂机</button>
                <!-- 点击关机按钮之后，挂机，关闭MIC,关闭耳机，关闭设备 -->
                <button class="layui-btn layui-btn-normal" name="B6" id="call-close" onClick="CloseDevice(ODT_LBRIDGE,function(nResult){AppendStatus('关闭设备.');});"> 关闭设备</button>
            </p>

            <p id="call_record">
                <button class="layui-btn layui-btn-normal" name="B13" onClick="TV_StartPlayFile(0, 0)"> 播放文件</button>
                <button class="layui-btn layui-btn-normal" name="B14" onClick="TV_StopPlayFile(0)"> 停止播放</button>
                <button class="layui-btn layui-btn-normal" name="B15" onClick="TV_StartRecordFile(0, 0)"> 开始录音</button>
                <button class="layui-btn layui-btn-normal" name="B16" onClick="TV_StopRecordFile(0)"> 停止录音</button>
                <button class="layui-btn layui-btn-normal" name="B26" onClick="TV_DeleteRecordFile(0)"> 删除录音</button>
            </p>

            <p id="openOrClose">
                <button class="layui-btn layui-btn-normal" name="B18" onClick="TV_EnableMic(0,TRUE)"> 打开MIC</button>
                <button class="layui-btn layui-btn-normal" name="B19" onClick="TV_EnableMic(0,FALSE)"> 关闭MIC</button>
                <button class="layui-btn layui-btn-normal" name="B22" onClick="TV_EnableLine2Spk(0,TRUE)"> 打开耳机</button>
                <button class="layui-btn layui-btn-normal" name="B23" onClick="TV_EnableLine2Spk(0,FALSE)"> 关闭耳机</button>

                <!-- <button class="layui-btn layui-btn-normal" name="B11" onClick="TV_OpenDoPlay(0)"> 打开喇叭</button>
                    <button class="layui-btn layui-btn-normal" name="B12" onClick="TV_CloseDoPlay(0)"> 关闭喇叭</button> -->
            </p>
        </div>
    </div>
		  
	</div>
	<!--弹框调用内容END-->	

	<div class="blogUser-con">
		<!-- 条件筛选框Start -->
		<blockquote class="layui-elem-quote not_border_left">
			<form class="layui-form" action="">		   
				<button type="button" class="layui-btn layui-bg-blue" id="addartType" lay-event="addartType" lay-filter="addartType" style="margin-left: 10px;">添加司机</button>
			</form>
		</blockquote>
		<!-- 条件筛选框End -->

		<table class="layui-hide" name="blogUser" id="blogUser" lay-filter="blogUser"></table>

		<script type="text/html" id="barDemo">
 			<a class="layui-btn layui-btn-xs" lay-event="call">打电话</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>

		<!-- 用户信息添加Start -->
		<div id="add-blogUser" >
			<div class="artTypeLayer">
				<form class="layui-form" action="">
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
                  <input type="text" id="pwd" name="pwd" 
                  autocomplete="off" class="layui-input">
              </div>             
          </div>  	
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                                               电话：
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="tel" name="tel" 
                  autocomplete="off" class="layui-input">
              </div>             
          </div>  
           <div class="layui-form-item">
    		<label class="layui-form-label">状态</label>
    <div class="layui-input-block">
        <input type="checkbox" checked="" name="open" lay-skin="switch" lay-filter="switchTest" lay-text="ON|OFF">
    </div>
  </div>
  <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="status" name="status" style="display:none;"  autocomplete="off" class="layui-input">
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
			url : '../User/select',
			title : '添加司机',
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
					field : 'userName',
					title : '姓名',
					align : 'center'
				}, {
					field : 'sex',
					align : 'center',
					title : '性别',
				}, {
					field : 'tel',
					align : 'center',
					title : '电话'
				}, {
					field : 'status',
					align : 'center',
					title : '状态',
				}, {
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
			var useridornickname=$("#userName").val().trim();
			table.render({
				elem : '#blogUser',
				url : '../systemmodel/roleListByName?userName='+useridornickname,
				title : '添加司机',
				height: "full-160",
				skin : 'line',
				even : true,
				cols : [ 
				       [ {
					type : 'numbers',
					title : '病人',
					align : 'center',
					width : 80
				}, {
					field : 'roleid',
					title : '饮食与营养型态',
					align : 'center'
				}, {
					field : 'rolename',
					align : 'center',
					title : '排泄型态',
				}, {
					field : 'authorityId',
					align : 'center',
					title : '休息与睡眠型态'
				},{
					title : '日常生活活动',
					toolbar : '#barDemo',
					align : 'center'
				},{
					field : 'authorityId',
					align : 'center',
					title : '自理能力'
				},{
					field : 'authorityId',
					align : 'center',
					title : '个人嗜好'
				} ,{
					title : '操作',
					toolbar : '#barDemo',
					align : 'center'
				}] 
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
			$("#pwd").val("");
			$("#tel").val("");
			
			layer.open({
				type : 1,
				title : '添加司机',
				area : [ '450px', '335px' ],
				shade : 0.4,
				content : $('#add-blogUser'),
				btn : [ '保存', '返回' ],
				yes : function() {
					var userid = $("#userid").val().trim();
					var username = $("#username").val().trim();
					var pwd = $("#pwd").val().trim();
					var tel = $("#tel").val().trim();
					var sex = $('input:radio:checked').val();
					var status = $("#status").val().trim();
					

					if(userid == "") {
						layer.tips('不能为空', '#userid');
						return;
					} 
					if(username==""){
						layer.tips('不能为空', '#username');
						return;
					}
					if(pwd == "") {
						layer.tips('不能为空', '#pwd');
						return;
					} 
					if(tel == "") {
						layer.tips('不能为空', '#tel');
						return;
					} 
					$.ajax({
						type : 'get',
						url : '../User/add?userid='+userid+'&username='+username+'&pwd='+pwd+'&tel='+tel+'&sex='+sex+'&status='+status,
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
		
		//监听指定开关
  form.on('switch(switchTest)', function(data){
    var msg = (this.checked ? 'true' : 'false');
    $("#status").val(msg);
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
			
		//拨打电话
		table.on('tool(blogUser)', function(obj) {
			var data = obj.data;
			//alert(data);
			$("#userid").text(data.userid);
			$("#username").text(data.userName);
			$("#sex").text(data.sex);
			$("#status").text(data.status);
			 $("#dialcode").text(data.tel);
			 $("#dialcode").attr("value", data.tel);     //将json值赋值到input     
			
			
			switch (obj.event) {
				case 'call':
					layer.open({
				        type: 1, 
				        title: '拨打电话',
				        area: ['720px', '630px'],
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
			        		url: "../User/delect?userid=" + data.userid,
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