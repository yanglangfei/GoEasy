package com.yf.utils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupUtil {

	/**
	 * @param lan
	 * @return
	 * @throws Exception
	 * 
	 *   获取热门 github 项目
	 */
	public static String getTrending(String lan) throws Exception {
		Document doc = Jsoup.connect("https://github.com/trending/" + lan)
				.get();
		Element easyML = doc.getElementsByClass("repo-list").first();
		Elements li = easyML.getElementsByTag("li");
		System.out.println(li.size());
		for (int i = 0; i < li.size(); i++) {
			Element item = li.get(i);
			Element a = item.getElementsByTag("a").first();
			String attr = a.attr("href");
			System.out.println(attr);
		}
		return null;
	}
	
	public static String getWhichGitData(String userName,String lan){
		
		return null;
	}

}
