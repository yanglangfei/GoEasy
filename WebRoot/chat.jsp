<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Socket聊天</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style>
#area {
	width: 1000px;
	height: 1000px;
	border: 1px red solid;
	margin-top: 10px;
}

.adv,img {
	width: 100px;
	height: 100px;
	/* background: url("images/skin6.jpg");  */
	/* background-repeat: no-repeat;
   background-size:cover; */
	position: absolute;
	position: fixed;
	top: 45%;
	right: 10px;
}
</style>
</head>

<body>
	<input type="text">
	<button>发送</button>
	<div id="area"></div>

	<!-- 广告区域  链接进入第三方网站 -->
	<div class="adv">
		<a href="sex.html"><img alt="色情广告" src="images/skin6.jpg"></a>
	</div>

	<script type="text/javascript">
		var wsUri = "ws://192.168.1.31:8080/EasyPush/socket";
		var input = document.getElementsByTagName("input")[0];
		var button = document.getElementsByTagName("button")[0];
		var div = document.getElementsByTagName("div")[0];
		var websocket = new WebSocket(wsUri);
		websocket.onopen = function() {
			//连接上server
			var newDiv = document.createElement("div");
			newDiv.innerHTML = "连接成功...";
			div.appendChild(newDiv);
		};
		websocket.onmessage = function(msg) {
			var newDiv = document.createElement("div");
			newDiv.innerHTML = msg.data;
			div.appendChild(newDiv);
		};
		button.onclick = function() {
			websocket.send(input.value);
			input.value = "";
		};
		//断开连接
		//websocket.close();

		document.oncontextmenu = function(e) {
			e.returnValue = false;
			//禁用右键
		};

		document.onkeydown = function(e) {
			//退格键，回车键，CTRL+N新窗口键，,shift+F10
			/* alert(e.key);
			console.log(e); */
			if(e.altKey&&(e.key=="ArrowDown"||e.key=="ArrowUp"||e.key=="ArrowLeft"||e.key=="ArrowRight")){
			  //Alt+方向键
			   e.returnValue=false;
			  //e.ctrlKey
			}
			
			if(e.ctrlKey&&(e.key=="n"||e.key=="N")){
			   return false;
			}
		};
		document.onscroll=function(e){
		   //滚动事件
		   console.log(e);
		};
		
	</script>
</body>
</html>
