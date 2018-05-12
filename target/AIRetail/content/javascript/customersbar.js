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


function Submit() {
	var shop = $("#shop").val();
	var starttime = $("#date_timepicker_start").val();
	var endtime = $("#date_timepicker_end").val();
	if(starttime==""||endtime==""){
		alert("请选择时间段！");
		return false;
	}
	var basis = $("#basis").val();
	var timetype = $("#timetype").val();
	var inout=$("#inout").val();
	var url = "get"+inout+"Data";
	if (basis == "gender") {
		url = url + "byG"
	} else {
		url = url + "byA";
	}
	$.getJSON(url, {
		"rankid" : shop,
		"st" : starttime,
		"et" : endtime,
		"type" : timetype
	}).done(function(data) {
		if(data.length<=0){
			alert("未查询到任何数据！");
			return false;
		}
		if (basis == "gender") {
			var female = new Object();
			var male = new Object();
			var xaxis = new Array();
			female.name = "女性";
			female.data = new Array();
			male.name = "男性";
			male.data = new Array();
			for (var i = 0; i < data.length; i++) {
				var item = data[i];
				xaxis.push(Highcharts.dateFormat('%Y-%m-%d %H:%M:%S',item.time_stamp));
				male.data.push(item.male);
				female.data.push(item.female);
			}
			console.log(xaxis);
			Bar(xaxis, [ male, female ]);
		} else {
			var a1 = new Object();
			var a2 = new Object();
			var a3 = new Object();
			var a4 = new Object();
			var a5 = new Object();
			var a6 = new Object();
			var xaxis = new Array();
			a1.name = "20岁及以下"
			a2.name = "21-30岁"
			a3.name = "31-40岁"
			a4.name = "41-50岁"
			a5.name = "51-60岁"
			a6.name = "61岁及以上"
			a1.data=new Array();
			a2.data=new Array();
			a3.data=new Array();
			a4.data=new Array();
			a5.data=new Array();
			a6.data=new Array();
			for (var i = 0; i < data.length; i++) {
				var item = data[i];
				xaxis.push(Highcharts.dateFormat('%Y-%m-%d %H:%M:%S',item.time_stamp));
				a1.data.push(item.a1);
				a2.data.push(item.a2);
				a3.data.push(item.a3);
				a4.data.push(item.a4);
				a5.data.push(item.a5);
				a6.data.push(item.a6);
			}
			Bar(xaxis, [a1,a2,a3,a4,a5,a6]);
		}
	});
};
// 客户信息直方图绘制
function Bar(xaxis, dat) {
	$('#customersbar')
			.highcharts(
					{
						chart : {
							type : 'column'
						},
						title : {
							text : '客户信息统计直方图'
						},
						xAxis : {
							categories:xaxis,
							crosshair:true,
							title:{
								text:'时间'
							}
						},
						yAxis : {
							min : 0,
							title : {
								text : '流量 (人数)'
							}
						},
						tooltip : {
							headerFormat : '<span style="font-size:10px">{point.key}</span><table>',
							pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
									+ '<td style="padding:0"><b>{point.y} 人</b></td></tr>',
							footerFormat : '</table>',
							shared : true,
							useHTML : true
						},
						plotOptions : {
							column : {
								borderWidth : 0
							}
						},
						series : dat
					});
}
// 日期时间选择器的脚本
$.datetimepicker.setLocale('zh');
$(function () {
    $('#date_timepicker_start').datetimepicker({
    	value: StartTime(),
    	format: 'Y-m-d H:00:00',
        onShow: function (ct) {
            this.setOptions({
                maxDate: $('#date_timepicker_end').val() ? $('#date_timepicker_end').val() : 0
            })
        },
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
})

/*
 * $('#timetype').change(function(){ var
 * p1=$(this).children('option:selected').val(); });
 */
