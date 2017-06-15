package com.yf.utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtils {

	public static String post(String url,Map<String, String> params) {
		CloseableHttpClient clients = null;
		try {
			clients = HttpClients.createDefault();
			HttpPost post = new HttpPost(url);
			post.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*;q=0.8");
			post.setHeader("Accept-Encoding", "gzip, deflate, sdch");
			post.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
			post.setHeader("Cookie", "BAIDUID=4F4FF5A186D2E3EB0A63D0342B90F0F1:FG=1; BIDUPSID=4F4FF5A186D2E3EB0A13D0342B90F0F1; __cfduid=d9e8e82c0f8912dacd22744dc01ee9edf1490160529; PSTM=1495593649; BDUSS=kJ4YTFuemxHZ2FrU1BUdkdzN2o5VGgwTXA4QThnMk9yQ1pzVXllNnlOTlR5VXhaSVFBQUFBJCQAAAAAAAAAAAEAAADGltRXZmVuZ2Vyb3VzAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAFM8JVlTPCVZc; BD_HOME=1; H_PS_PSSID=22872_1462_21112_18560_22071_22157; BD_UPN=12314353");
			post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
			post.setHeader("Host", "http://www.renren.com/");
			post.setHeader("Connection", "keep-alive");
			post.setHeader("Upgrade-Insecure-Requests", "1");
			post.setHeader("Cache-Control", "max-age=0");
			
			List<NameValuePair> parameters=new ArrayList<>();
			if(params!=null){
				for(Map.Entry<String, String> p : params.entrySet()){
					parameters.add(new BasicNameValuePair(p.getKey(), p.getValue()));
				}
			}
			post.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));
			CloseableHttpResponse execute = clients.execute(post);
			System.out.println(execute.getStatusLine().getStatusCode());
			if (execute.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return EntityUtils.toString(execute.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				clients.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static String get(String url,Map<String, String> params) {
		CloseableHttpClient clients = null;
		try {
			clients = HttpClients.createDefault();
			StringBuilder builder=new StringBuilder(url);
			if(params!=null){
				builder.append("?");
				for(Map.Entry<String, String> p : params.entrySet()){
					builder.append(p.getKey());
					builder.append("=");
					builder.append(p.getValue());
					builder.append("&");
				}
				builder.replace(builder.length()-1, builder.length(), "");
			}
			HttpGet get = new HttpGet(builder.toString());
			get.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*;q=0.8");
			get.setHeader("Accept-Encoding", "gzip, deflate, sdch");
			get.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
			get.setHeader("Cookie", "BAIDUID=4F4FF5A186D2E3EB0A63D0342B90F0F1:FG=1; BIDUPSID=4F4FF5A186D2E3EB0A13D0342B90F0F1; __cfduid=d9e8e82c0f8912dacd22744dc01ee9edf1490160529; PSTM=1495593649; BDUSS=kJ4YTFuemxHZ2FrU1BUdkdzN2o5VGgwTXA4QThnMk9yQ1pzVXllNnlOTlR5VXhaSVFBQUFBJCQAAAAAAAAAAAEAAADGltRXZmVuZ2Vyb3VzAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAFM8JVlTPCVZc; BD_HOME=1; H_PS_PSSID=22872_1462_21112_18560_22071_22157; BD_UPN=12314353");
			get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
			get.setHeader("Host", "http://www.renren.com/");
			get.setHeader("Connection", "keep-alive");
			get.setHeader("Upgrade-Insecure-Requests", "1");
			get.setHeader("Cache-Control", "max-age=0");
			CloseableHttpResponse execute = clients.execute(get);
			System.out.println(execute.getStatusLine().getStatusCode());
			if (execute.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return EntityUtils.toString(execute.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				clients.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		String res = get("https://github.com/trending/java", null);
		System.out.println(res);
	}
	
	
	

}
