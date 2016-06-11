<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
 
<!DOCTYPE html>
<html>
<head>
	<title>后台管理</title>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/index.css" />
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="title">后台管理系统</div>

		<div id="user_info">
			<div id="welcome">欢迎使用本系统</div>
		</div>
	</div>
	<div id="navigator">
		<iframe src="./tree.jsp"></iframe>
    </div>
	<div id="main">
		<iframe name="MainFrame" src="query_success.jsp"></iframe>
	</div>
	<div id="footer">Copyright © 2016 All Rights Reserved Powered By lc-dmx</div>
</div>
</body>
<script type="text/javascript">
function screenAdapter(){
	document.getElementById('footer').style.top=document.documentElement.scrollTop+document.documentElement.clientHeight- document.getElementById('footer').offsetHeight+"px";
		document.getElementById('navigator').style.height=document.documentElement.clientHeight-100+"px";
		document.getElementById('main').style.height=document.documentElement.clientHeight-100+"px";
		document.getElementById('main').style.width=window.screen.width-230+"px";
}

window.onscroll=function(){screenAdapter();};
window.onresize=function(){screenAdapter();};
window.onload=function(){screenAdapter();};
</script>
</html>