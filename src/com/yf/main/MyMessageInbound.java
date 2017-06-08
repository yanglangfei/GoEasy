package com.yf.main;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;

public class MyMessageInbound extends MessageInbound {
	private  List<MyMessageInbound> mmiList = new ArrayList<MyMessageInbound>();
	WsOutbound out;

	@Override
	protected void onBinaryMessage(ByteBuffer arg0) throws IOException {

	}

	@Override
	protected void onTextMessage(CharBuffer arg0) throws IOException {
		System.out.println("accept text msg:"+arg0.toString());
		for(MyMessageInbound mm : mmiList){
			CharBuffer wrap = CharBuffer.wrap(arg0);
			mm.out.writeTextMessage(wrap);
			mm.out.flush();
		}
	}

	@Override
	protected void onClose(int status) {
		super.onClose(status);
		mmiList.remove(this);
		System.out.println("client close...");
		
	}

	@Override
	protected void onOpen(WsOutbound outbound) {
		super.onOpen(outbound);
		try {
			this.out=outbound;
			mmiList.add(this);
			out.writeTextMessage(CharBuffer.wrap("hello"));
			System.out.println("client connected...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
