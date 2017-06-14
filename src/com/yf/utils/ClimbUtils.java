package com.yf.utils;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class ClimbUtils {

	public static void main(String[] args) {
		try {
			String res = get(
					"http://browse.renren.com/s/all?from=homeindex&q=ÎÞÁÄ&itab=11#qt=¹«Ö÷Á³/tindex=1",
					null, null);
			System.out.println(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(String url, Map<String, String> param,
			Map<String, String> header) throws IOException {
		OkHttpClient client = new OkHttpClient();
		FormEncodingBuilder body = new FormEncodingBuilder();
		if (param != null) {
			for (Map.Entry<String, String> enty : param.entrySet()) {
				body.add(enty.getKey(), enty.getValue());
			}
		}
		Request request = new Request.Builder().get()
				.url(url)
				// .put(body.build()) .patch(body.build())
				.addHeader("Accept",
						"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                .addHeader("Accept-Encoding", "gzip, deflate, sdch, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.8")
                .addHeader("Cookie", UUID.randomUUID().toString())
                .addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36")
                
				.build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			return null;
		}
	}
}
