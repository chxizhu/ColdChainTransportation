layui.define(['jquery', 'form', 'layer', 'element'], function(exports) {
	var $ = layui.jquery,
		form = layui.form,
		layer = layui.layer,
		element = layui.element;
	var menu = [];
	var curMenu;
	
	//菜单信息加载,登录用户信息加载
	$.ajax({
		type : 'get',
		url : "../systemmodel/getsystemmodelbyrole",
		async:false, 
		datatype : 'json',
		success : function(menudata) {
			//返回menu的json数据
			if(menudata.code==0){
				//$("#userrole").text(menudata.loginuser[0].name);
				var menu = "";
				for (var i = 0; i < menudata.data.length; i++) {
					if (menudata.data[i].parentid == 0 && menudata.data[i].deepth==1) {		// 查询所有父类菜单
						menu += "<li>"
						menu +="<a href='javascript:;'><i class='layui-icon' style='font-size:18px'>"+menudata.data[i].imageurl+"</i>"
						menu += "<cite>"+ menudata.data[i].chinesename +"<cite>"
						menu +="<i class='iconfont nav_right'>&#xe697;</i></a>"
						menu +="<ul class='sub-menu'>"
						for (var j = 0; j < menudata.data.length; j++) {
							if (menudata.data[j].parentid == menudata.data[i].id) {// 判断父类菜单下的子类菜单
								menu += "<li>"
								menu += "<a _href="+menudata.data[j].navurl+"><i class='iconfont'>&#xe6a7;" +
										"</i><cite>"+menudata.data[j].chinesename+"</cite></a>"
								menu += "</li>"
							}
						}
						menu +="</ul>"
						menu += "</li>"
					}
				}
				$("#nav").html(menu);
				var element = layui.element;
			}
		},
		error : function() {},
	});
	
	//左侧导航菜单的显示和隐藏
	$('.container .left_open i').click(function(event) {
		if($('.left-nav').css('left') == '0px') {
			//此处左侧菜单是显示状态，点击隐藏
			$('.left-nav').animate({
				left: '-221px'
			}, 100);
			$('.page-content').animate({
				left: '0px'
			}, 100);
			$('.page-content-bg').hide();
		} else {
			//此处左侧菜单是隐藏状态，点击显示
			$('.left-nav').animate({
				left: '0px'
			}, 100);
			$('.page-content').animate({
				left: '200px'
			}, 100);
			//点击显示后，判断屏幕宽度较小时显示遮罩背景
			if($(window).width() < 768) {
				$('.page-content-bg').show();
			}
		}
	});
	
	/*退出系统*/
	$("#loginout").click(function(){
		$.ajax({
			type: 'get',
			url: '../sysadminusermanager/logoutsystem',
			datatype: 'json',
			success: function(data) {
				if(data.code=="10001"){
					window.location.href = "../html/login.jsp";
				}else{
					layer.msg(data.msg,{icon:2});
				}
			},
			error: function() {}
		});
	});
	
	/*密码修改*/
	$("#ddpersonalmsg").click(function(){
		var title = $(this).html();
		var url ="../html/personMessage.jsp";
		changeURL(url,title);
	});

	
	/*密码修改*/
	$("#changepwd").click(function(){
		var title = $(this).html();
		var url ="../html/changePwd.jsp";
		changeURL(url,title);
	});

	//如果有子级就展开，没有就打开frame
	$('.left-nav #nav li').click(function(event) {
		if($(this).children('.sub-menu').length) {
			if($(this).hasClass('open')) {
				$(this).removeClass('open');
				$(this).find('.nav_right').html('&#xe697;');
				$(this).children('.sub-menu').stop().slideUp();
				$(this).siblings().children('.sub-menu').slideUp();
			} else {
				$(this).addClass('open');
				$(this).children('a').find('.nav_right').html('&#xe6a6;');
				$(this).children('.sub-menu').stop().slideDown();
				$(this).siblings().children('.sub-menu').stop().slideUp();
				$(this).siblings().find('.nav_right').html('&#xe697;');
				$(this).siblings().removeClass('open');
			}
		} else {
			$(this).children().addClass("navacolor");
			$(this).siblings().children().removeClass("navacolor");
			var url = $(this).children('a').attr('_href');
			var title = $(this).find('cite').html();
			changeURL(url,title);
		}
		event.stopPropagation();
	});
	
	//点击侧边导航栏页面跳转
	function changeURL(url,title){
		$("#ifram1").attr("src", url);
		$("#liformtitle").text(title);
	}
	
	/*弹出层*/
	/*
	    参数解释：
	    title   标题
	    url     请求的url
	    id      需要操作的数据id
	    w       弹出层宽度（缺省调默认值）
	    h       弹出层高度（缺省调默认值）
	*/
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

	//@todo 重新计算iframe高度
	function FrameWH() {
		var h = $(window).height() - 80;
		$("iframe").css("height", h + "px");
	}
	$(window).resize(function() {
		FrameWH();
	});
});
