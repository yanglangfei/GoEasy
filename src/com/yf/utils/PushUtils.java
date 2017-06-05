package com.yf.utils;
import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;
public class PushUtils {
	
	private static String appkey="BC-7d1a200ee48f4901ab5c7d84c3ab96d4";
	private static PublishListener listener=new PublishListener(){

		@Override
		public void onFailed(GoEasyError error) {
			super.onFailed(error);
			System.out.println("发布失败");
		}

		@Override
		public void onSuccess() {
			super.onSuccess();
			System.out.println("发布成功");
		}
		
		
	};

	public static void push(String chanel,String content){
		GoEasy goEasy=new GoEasy(appkey);
		goEasy.publish(chanel, content, listener);
		
	}

}
