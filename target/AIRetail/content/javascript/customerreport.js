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
});
var wocao;
function Submit() {
	var shop = $("#rankid").val();
	var starttime = $("#date_timepicker_start").val();
	var endtime = $("#date_timepicker_end").val();
	if(starttime==""||endtime==""){
		alert("请选择时间段！");
		return false;
	}
	var inout=$("#inout").val();
	$.getJSON("getCustomerData", {
		"rankid" : shop,
		"st" : starttime,
		"et" : endtime,
		"type" : inout
	}).done(function(data) {
		if(data.length<=0){
			alert("未查询到任何数据！");
			return false;
		}
		wocao=data;
		$("#customercontent").empty();
		for (var i = 0; i < data.length; i++) {
			var item = data[i];
			var datestr = new Date(item.timestamp);
			var trHTML = "<tr><td>"+i+"</td>"+"<td><img src=\"data:image/jpeg;base64,"+item.facepic+"\"/></td>"+"<td>"+item.gender+"</td>"+
			              "<td>"+item.age+"</td>"+"<td><img src=\"data:image/jpeg;base64,"+item.wholebodypic+"\"/></td>"+"<td>"+datestr+"</td>"+"</tr>";
			$("#customercontent").append(trHTML);
		}
	});
};

