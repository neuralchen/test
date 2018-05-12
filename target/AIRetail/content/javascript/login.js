/**
 * 
 */
function Confirm() {
	var userlabel=$('#userlabel').val();
	var passwd=$('#passwd').val();
	if(userlabel==""){
		$('.warn-info').text("账号不能为空！");
	}
	else if(passwd==""){
		$('.warn-info').text("密码不能为空！");
	}
	else{
        $('#loginform').submit();
	}
};