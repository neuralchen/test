/**
 * 
 */
function StartTime(){   
	var now = new Date();  
    var seperator1 = "-";
    var seperator2 = ":"; 
    var year = now.getFullYear();       // 年
    var month = now.getMonth() + 1;     // 月
    var day = now.getDate();            // 日
    var hh = "00";            // 时
    var mmss = "00"+seperator2+"00";    // 分
    var clock = year + seperator1;   
    if(month < 10)clock += "0";         
    clock += month + seperator1;         
    if(day < 10)clock += "0";            
    clock += day + " ";                 
    clock += hh + seperator2;  
    clock+=mmss;
    return(clock);  
};
function CurentTime(){   
        var now = new Date();  
        var seperator1 = "-";
        var seperator2 = ":"; 
        var year = now.getFullYear();       // 年
        var month = now.getMonth() + 1;     // 月
        var day = now.getDate();            // 日
        var hh = now.getHours();            // 时
        var mmss = "00"+seperator2+"00";    // 分
        var clock = year + seperator1;   
        if(month < 10)clock += "0";         
        clock += month + seperator1;         
        if(day < 10)clock += "0";            
        clock += day + " ";        
        if(hh < 10)clock += "0";            
        clock += hh + seperator2;  
        clock+=mmss;
        return(clock);   
}; 
// 生成序列
function GenSeq(num){
	var arr = new Array(num);
	for(var i = 0;i < num;i++){
	arr[i]=i;
	}
	return arr;
};


// 时间区间选择
// 热力图绘制
var setwidth=1000;
var margin = {
	top : 30,
	right : 0,
	bottom : 100,
	left : 60,
	delta: 10
}, width = setwidth+margin.left+margin.right;
var maxwidth=60;
var buckets = 9, colors = ["#ffffd9", "#edf8b1", "#c7e9b4", "#7fcdbb", "#41b6c4", "#1d91c0","#225ea8", "#253494", "#081d58" ];
var gridSize,height,legendElementWidth;
var yxasix,times;
var svg,defs,shap;
var heatmap;// 热力图绘图区
var xasix,yasix;// 坐标轴绘图区
var legend;// 图例绘制区
var xcount,ycount;

function InitHeatmap(){
    d3.select("svg").remove();
	var actleft=margin.left+(setwidth-xcount*gridSize)/2;
	svg = d3.select("#chart").append("svg").attr("width",
			width + margin.left + margin.right).attr("height", height + margin.top + margin.bottom);
	
    heatmap= svg.append("g").attr("id","heatmap")
             .attr("transform","translate(" + actleft + "," + margin.top + ")")
             .attr("height", height).attr("width", width);
    
    xasix  = svg.append("g").attr("id","xasix")
             .attr("transform","translate(" + actleft + ",0)")
             .attr("height", margin.top).attr("width", width);
    
    yasix  = svg.append("g").attr("id","yasix")
             .attr("transform","translate(0," + margin.top + ")")
             .attr("height", height).attr("width",actleft);
    
    var temp=margin.top + height+10;
    var lengactleft = margin.left+(setwidth-buckets*gridSize)/2;
    legend = svg.append("g").attr("id","legend")
             .attr("transform","translate(" + lengactleft + "," + temp + ")")
             .attr("height",margin.bottom).attr("width", width);
	// 设置一个mask
	defs=d3.select("#chart svg").append("defs").attr("id","res").append("clipPath").attr("id","wocao")
				.attr("clipPathUnits","objectBoundingBox").append('polygon').attr("points",shap);
	d3.select("#res").append("line").attr("id","yline").attr("x1","0")
	            .attr("x2","8").attr("y1","0").attr("y2","0").attr("class","axis-class");
	d3.select("#res").append("line").attr("id","xline").attr("x1","0")
			    .attr("x2","0").attr("y1","0").attr("y2","8").attr("class","axis-class");
	// 纵轴
	temp=actleft-margin.delta-5;
	var dayLabels = yasix
			.selectAll(".dayLabel")
			.data(yxasix)
			.enter()
			.append("text")
			.attr("class", "mono")
			.text(function(d) {
				return d+1;
			})
			.attr("x", 0)
			.attr("y", function(d, i) {
				return i * gridSize;
			})
			.style("text-anchor", "end")
			.attr("transform", "translate("+temp+"," + gridSize/1.5  + ")");
	
	// 横轴
	var timeLabels = xasix.selectAll(".timeLabel").data(times).enter()
			.append("text").attr("class", "mono")
			.text(function(d) {
				return d+1;
			}).attr("x", function(d, i) {
				return i * gridSize;
			}).attr("y", 0).style("text-anchor", "middle")
			.attr("transform", "translate(" + gridSize / 2 + ", 15)");
	xasix.selectAll(".timeLabel")
	     .data(times1).enter().append("use").attr("xlink:href","#xline")
         .attr("x",function(d, i) {return i * gridSize;}).attr("y",margin.top-margin.delta);
	yasix.selectAll(".dayLabel").data(yxasix1).enter()
	     .append("use").attr("xlink:href","#yline")
	     .attr("x",actleft-margin.delta).attr("y",function(d, i) {return i * gridSize;});
	xasix.append("line").attr("x1",0)
		 .attr("x2",gridSize*xcount).attr("y1",margin.top-10)
		 .attr("y2",margin.top-margin.delta).attr("class","axis-class");
	yasix.append("line").attr("x1",actleft-margin.delta)
	     .attr("x2",actleft-margin.delta).attr("y1",0)
	     .attr("y2",height).attr("class","axis-class");
};


var heatmapChart = function(data) {
		var colorScale = d3.scale.quantile().domain(
				[ 0, buckets - 1, d3.max(data, function(d) {
					return d.value;
				}) ]).range(colors);
		var cards = heatmap.selectAll(".hour").data(data, function(d) {
			return d.day + ':' + d.hour;
		});
		cards.append("title");
		cards.enter().append("rect").attr("x", function(d) {
			return (d.hour - 1) * gridSize;
		}).attr("y", function(d) {
			return (d.day - 1) * gridSize;
		}).attr("rx", 4).attr("ry", 4).attr("class", "hour bordered").attr(
				"width", gridSize).attr("height", gridSize).style("fill",
				colors[0]);
		cards.transition().duration(1000).style("fill", function(d) {
			return colorScale(d.value);
		});
		cards.select("title").text(function(d) {
			return d.value;
		});
		cards.exit().remove();
		// 以下设置图例
		var legend1 = legend.selectAll(".legend").data(
				[ 0 ].concat(colorScale.quantiles()), function(d) {
					return d;
				});
		legend1.enter().append("g").attr("class", "legend");
		legend1.append("rect").attr("x", function(d, i) {
			return legendElementWidth * i;
		}).attr("width", legendElementWidth).attr("height",
				gridSize/2).style("fill", function(d, i) {
			return colors[i];
		});
		legend1.append("text").attr("class", "mono").text(function(d) {
			return "≥ " + Math.round(d);
		}).attr("x", function(d, i) {
			return legendElementWidth * i;
		}).attr("y",gridSize/2+20);
		legend1.exit().remove();
		d3.select("#heatmap").style({"clip-path":"url(#wocao)"});
};
// 确认查询时间
var curts=0;
var loaddata;
function Confirm() {
	var shop = $("#rankid").val();
	var starttime = $("#date_timepicker_start").val();
	var endtime = $("#date_timepicker_end").val();
	var timetype = $("#timetype").val();
	if(starttime==""||endtime==""){
		alert("请选择时间段！");
		return false;
	}
	$.getJSON("getheatmapdata", {
		"rankid" : shop,
		"st":starttime,
		"et":endtime,
		"type" : timetype
	}).done(function(data) {
		if(data.data.length<=0){
			alert("未查询到任何数据！");
			return false;
		}
		loaddata=data;
		xcount=data.shopstructure.x_grid_count;
		ycount=data.shopstructure.y_grid_count;
		shap=data.shopstructure.shap;
		gridSize = Math.floor(width / xcount);
		if(gridSize>maxwidth)
			gridSize=maxwidth;
		height = gridSize*ycount;
        legendElementWidth = gridSize;
		times=GenSeq(xcount);
		yxasix=GenSeq(ycount);
		times1=GenSeq(xcount+1);
		yxasix1=GenSeq(ycount+1);
		InitHeatmap();
		// 设置热力图的时间戳
		$("#timestamp").text(Highcharts.dateFormat('%Y-%m-%d %H:%M:%S',data.data[curts].ts));
		var mask=new Array();
		var count=0;
		for (var i = 1; i <= xcount; i++){
			for (var j = 1; j <= ycount; j++)
			{
				mask.push({
					day : j,
					hour : i,
					value : data.data[curts].data[count]
				});
				count=count+1;
			}
		}
		heatmapChart(mask);
	});
};
function pre(){
	if(loaddata!=null){
		curts=(curts-1);
		if(curts<0)curts=loaddata.data.length-1;
		$("#timestamp").text(Highcharts.dateFormat('%Y-%m-%d %H:%M:%S',loaddata.data[curts].ts));
		var mask=new Array();
		var count=0;
		for (var i = 1; i <= xcount; i++){
			for (var j = 1; j <= ycount; j++)
			{
				mask.push({
					day : j,
					hour : i,
					value : loaddata.data[curts].data[count]
				});
				count=count+1;
			}
		}
		console.log(mask);
		heatmapChart(mask);
	}
};
function afte(){
	if(loaddata!=null){
		curts=(curts+1)%loaddata.data.length;
		if(curts<0)curts=loaddata.data.length-1;
		$("#timestamp").text(Highcharts.dateFormat('%Y-%m-%d %H:%M:%S',loaddata.data[curts].ts));
		var mask=new Array();
		var count=0;
		for (var i = 1; i <= xcount; i++){
			for (var j = 1; j <= ycount; j++)
			{
				mask.push({
					day : j,
					hour : i,
					value : loaddata.data[curts].data[count]
				});
				count=count+1;
			}
		}
		console.log(mask);
		heatmapChart(mask);
	}
};

// 日期时间选择器的脚本
$.datetimepicker.setLocale('zh');
$(function () {
	var curtime= CurentTime();
    $('#date_timepicker_start').datetimepicker({
    	value: StartTime(),
    	format: 'Y-m-d H:00:00',
        onShow: function (ct) {
            this.setOptions({
                maxDate: $('#date_timepicker_end').val() ? $('#date_timepicker_end').val() : 0
            })
        },
        defaultTime: true
    });
    
    $('#date_timepicker_end').datetimepicker({
    	value: CurentTime(),
    	format: 'Y-m-d H:00:00',
        onShow: function (ct) {
            this.setOptions({
                minDate: $('#date_timepicker_start').val() ? $('#date_timepicker_start').val() : false,
                maxDate: 0
            })
        }
    });　  
    
    $('#timetype').change(function(){  
    　　　　var p1=$(this).children('option:selected').val();
	    if(p1=="hour"){
	    	 $('#date_timepicker_start').datetimepicker({format: 'Y-m-d H:00:00'});
	    	 $('#date_timepicker_end').datetimepicker({format: 'Y-m-d H:00:00'});
	    }
	    else if(p1=="day"){
	    	$('#date_timepicker_start').datetimepicker({format: 'Y-m-d 00:00:00'});
	   	 $('#date_timepicker_end').datetimepicker({format: 'Y-m-d 00:00:00'});
	    }
	    else{
	    	$('#date_timepicker_start').datetimepicker({format: 'Y-m-01 00:00:00'});
	      	 $('#date_timepicker_end').datetimepicker({format: 'Y-m-01 00:00:00'});
	    }
    });
});