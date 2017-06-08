package com.yf.main;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyWeb {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket=new ServerSocket(80);
		System.out.println("启动服务器..");
		Socket socket=serverSocket.accept();
		System.out.println("客户端访问到:"+socket.getRemoteSocketAddress().toString());
		OutputStream os = socket.getOutputStream();
		DataOutputStream dos=new DataOutputStream(os);
		dos.writeUTF("Content-Type:text/plain;charset=UTF-8");
		dos.writeUTF("<h1>connect success</h1>");
	}
}
