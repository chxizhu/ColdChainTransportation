Highcharts.setOptions({
	global: {
		useUTC: false
	}
});

function activeLastPointToolip(chart) {
	var points = chart.series[0].points;
	chart.tooltip.refresh(points[points.length - 1]);
}

var temp;
var time;
var mycars = new Array()
$.ajax({
	type: "POST",
	url:"../Onenet/gettemp",
	dataType: 'json',
	xhrFields: {
		withCredentials: true
	},
	async: false, //是否异步
	crossDomain: true,
	success: function(data) {
		
		temp = data.data[data.data.length - 1].tid;
		
		
		

	}

});
setInterval(function() {
	$.ajax({
		type: "POST",
		url:"../Onenet/gettemp",
		dataType: 'json',
		xhrFields: {
			withCredentials: true
		},
		async: false, //是否异步
		crossDomain: true,
		success: function(data) {
			temp = data.data[data.data.length - 1].tid;

		}

	});

}, 5000);
var chart = Highcharts.chart('container', {
	chart: {
		type: 'spline',
		marginRight: 100,
		events: {
			load: function() {

				var series = this.series[0],
					chart = this;
				activeLastPointToolip(chart);
				setInterval(function() {
					var x = (new Date()).getTime(), // 当前时间
						y = temp; // 随机值
					series.addPoint([x, y], true, true);
					activeLastPointToolip(chart);
				}, 5000);
			}
		}
	},
	title: {
		text: '当前温度'
	},
	xAxis: {
		type: 'datetime',
		tickPixelInterval: 150
	},
	yAxis: {
		title: {
			text: null
		}
	},
	tooltip: {
		formatter: function() {
			return '<b>' + this.series.name + '</b><br/>' +
				Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
				Highcharts.numberFormat(this.y, 2);
		}
	},
	legend: {
		enabled: false
	},
	series: [{
		name: '随机数据',
		data: (function() {
			// 生成随机值
			var data = [],
				time = (new Date()).getTime(),
				i;
			for (i = -19; i <= 0; i += 1) {
				data.push({
					x: (new Date()).getTime(),
					y: temp
				});
			}
			return data;
		}())
	}]
});
