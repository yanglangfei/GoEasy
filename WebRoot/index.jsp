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

<title>接收邮件消息</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="http://cdn.goeasy.io/goeasy.js"></script>
<style>
* {
	font-family: "微软雅黑";
}

.msgArea {
	width: 500px;
	height: 500px;
	border: 1px solid red;
}

img {
	width: 50px;
	height: 50px;
	border-radius: 50%;
	margin-right: 10px;
	margin-top: 10px;
}
#img1{
  border: 1px solid red;
}

#img2{
  border: 1px solid yellow;
}

#img3{
  border: 1px solid #ff00ff;
}

#img4{
  border: 1px solid #00ff00;
}

#img5{
  border: 1px solid #0000ff;
}

#img6{
  border: 1px solid #eeff00;
}

#img7{
  border: 1px solid #ffeecc;
}
</style>
</head>
<body>
	<img id="img1" alt="" src="images/skin2.jpg">
	<img id="img2" alt="" src="images/skin3.jpg">
	<img id="img3" alt="" src="images/skin4.jpg">
	<img id="img4" alt="" src="images/skin5.jpg">
	<img id="img5" alt="" src="images/skin6.jpg">
	<img id="img6" alt="" src="images/skin7.jpg">
	<img id="img7" alt="" src="images/icon.png">
	<h2>接受消息</h2>
	<button onclick="cancelSun()">取消订阅</button>
	<button onclick="publishMsg()">发布消息</button>
	<div class="msgArea"></div>



	<script type="text/javascript">
		var msgArea = document.getElementsByTagName("div")[0];
		var goEasy = new GoEasy({
			appkey : "BS-c0fcd8a9992a49d1a4f2a96faa8b4484",
			onConnected : function() {
				alert("成功连接GoEasy。");
			},
			onDisconnected : function() {
				alert("与GoEasy连接断开。");
			},
			onConnectFailed : function(error) {
				alert("与GoEasy连接失败，错误编码：" + error.code + "错误信息："
						+ error.content);
			}
		});
		//订阅 Chanel1 并接受消息
		goEasy.subscribe({
			channel : "chanel1",
			onMessage : function(message) {
				alert("您有新的消息");
				var div = document.createElement("div");
				div.innerHTML = message.channel + ":" + message.content;
				msgArea.appendChild(div);
			},
			onSuccess : function() {
				alert("订阅成功");
			},
			onFailed : function(error) {
				alert("订阅失败，错误编码：" + error.code + " 错误信息：" + error.content);
			}
		});

		//取消订阅Chanel1
		function cancelSun() {
			goEasy.unsubscribe({
				channel : "chanel1",
				onSuccess : function() {
					alert("取消成功");
				},
				onFailed : function(error) {
					alert("取消订阅失败，错误编码：" + error.code + " 错误信息："
							+ error.content);
				}
			});
		}

		//发布消息
		function publishMsg() {
			goEasy.publish({
				channel : "chanel2",
				message : "你好,Server"
			});

		}
	</script>

</body>
</html>
