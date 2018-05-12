/**
 * 
 */
function CurentTime()  
{   
    var now = new Date();       
    var year = now.getFullYear();       // 年
    var month = now.getMonth() + 1;     // 月
    var day = now.getDate();            // 日
    var hh = now.getHours();            // 时
    var mm = now.getMinutes();          // 分
    var ss=now.getSeconds();            // 秒
    var splitstr1="";
    var splitstr2="";
    var splitstr3="";
    var clock = year + splitstr1;       
    if(month < 10) clock += "0";         
    clock += month + splitstr1;      
    if(day < 10) clock += "0";   
    clock += day + splitstr2;      
    if(hh < 10) clock += "0";  
    clock += hh + splitstr3;  
    if (mm < 10) clock += '0';   
    clock += mm+ splitstr3;        
    if (ss < 10) clock += '0';
    clock += ss;  
    return(clock);   
}  

function send() {
	var mode=$("#mode").val();
//	var token="5B58D63AC8576F7F017B08A26C84E35A";
//	var rankid = 111;
	var face_pic = $("#face_pic").val();
	var gender = $("#gender").val();
	var age = $("#age").val();
	var whole_body_pic = $("#whole_body_pic").val();
	
	var passenger = new Object;
// passenger.token= token;
//	passenger.rankid=rankid;
	passenger.face_pic=face_pic;
	passenger.Gender=gender;
	passenger.Age=age;
	passenger.whole_body_pic=whole_body_pic;
	passenger.timestamp=CurentTime();
	
	var url="api/vistors/"+mode;
	url="api/vistors/uploaddata"
	$.ajax({  
        type : "POST",  
        url : url,  
        data : "{\""+ mode +"\":"+JSON.stringify(passenger)+"}",  
        contentType : "application/json",  
        dataType : "json",  
        complete:function(msg) {  
        	console.log(msg);
        	$("#result").html(msg);  
        }  
    });
};

function heatmapsend(){
//	var rankid = 666;
	var heatmap= new Object;
	var selecttime = $("#date_timepicker").val();
//	heatmap.rankid=rankid;
	heatmap.timestamp=selecttime;
	var numArr = []; // 定义一个空数组
    var txt = $('.heatmap'); // 获取所有文本框
    for (var i = 0; i < txt.length; i++) {
        numArr.push(txt.eq(i).val()); // 将文本框的值添加到数组中
    }
    heatmap.data=numArr;
	var url="api/vistors/uploaddata";
	$.ajax({  
        type : "POST",  
        url : url,  
        data : "{\"heatmap\":"+JSON.stringify(heatmap)+"}",  
        contentType : "application/json",  
        dataType : "json",  
        complete:function(msg) {  
        	console.log(msg);
        	$("#result").html(msg);  
        }  
    });
};
$.datetimepicker.setLocale('zh');
$(function () {
	var curtime= CurentTime();
	$('#date_timepicker').datetimepicker({
		format: 'Y-m-d H:i:00',
	    onShow: function (ct) {
	        this.setOptions({
	            maxDate: $('#date_timepicker_end').val() ? $('#date_timepicker_end').val() : 0,
	        });
	    },
	    value: curtime,
	    step:10
	});
});
