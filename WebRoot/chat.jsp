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

<title>My JSP 'chat.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<input type="text">
	<button >发送</button>
	<script type="text/javascript">
		var wsUri = "ws://192.168.1.31:8080/EasyPush/socket";
		var input=document.getElementsByTagName("input")[0];
		var button=document.getElementsByTagName("button")[0];
		var websocket = new WebSocket(wsUri);
		websocket.onopen = function() {
			//连接上server
			alert("open");
		};
		websocket.onmessage = function(msg) {
		console.log(msg);
			alert("接受到消息:"+msg.data);
		};
		button.onclick=function(){
			websocket.send(input.value);
			alert("send");
		};
	</script>
</body>
</html>
