package com.yf.main;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;
public class MyMessageInbound extends MessageInbound {
	private  static  List<MyMessageInbound> mmiList = new ArrayList<MyMessageInbound>();
	private WsOutbound out;
	private HttpSession session;
	public MyMessageInbound(HttpSession session) {
		this.session=session;
	}

	@Override
	protected void onBinaryMessage(ByteBuffer buffer) throws IOException {
		//���ܵ��ļ���Ϣ
		System.out.println("���ܵ��ļ���Ϣ...");
		for(MyMessageInbound mm : mmiList){
			mm.out.writeBinaryMessage(buffer);
			mm.out.flush();
		}
	}
	

	@Override
	protected void onTextMessage(CharBuffer buff) throws IOException {
		//���ܵ��ı���Ϣ
		try {
			System.out.println("����Ϣ:{��"+this.session.getId().substring(0, 5)+"��:"+buff.toString()+"}");
			CharBuffer wrap = CharBuffer.wrap(session.getId().substring(0, 5)+":"+buff);
			sendMsg(wrap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void sendMsg(CharBuffer buff) throws Exception{
		System.out.println("ת����Ϣ("+mmiList.size()+"):"+buff.toString());
		for(MyMessageInbound mm : mmiList){
			mm.out.writeTextMessage(buff);
			mm.out.flush();
		}
	}

	@Override
	protected void onClose(int status) {
		super.onClose(status);
		try {
			mmiList.remove(this);
			String leaveInfo="�û���"+this.session.getId().substring(0, 5)+"��"+"����...";
			CharBuffer buff=CharBuffer.wrap("<font color='green'>"+leaveInfo+"</font>");
			sendMsg(buff);
			System.out.println(leaveInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	protected void onOpen(WsOutbound outbound) {
		super.onOpen(outbound);
		try {
			this.out=outbound;
			mmiList.add(this);
			String comeInfo="�û���"+this.session.getId().substring(0, 5)+"��"+"����...";
			System.out.println(comeInfo);
			CharBuffer buff=CharBuffer.wrap("<font color='red'>"+comeInfo+"</font>");
			sendMsg(buff);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
