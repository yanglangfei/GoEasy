package com.yf.test;

import com.yf.utils.JsoupUtil;

public class Test {
	
	public static void main(String[] args) {
		try {
			JsoupUtil.getTrending("java");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
