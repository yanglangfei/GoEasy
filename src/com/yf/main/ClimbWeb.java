package com.yf.main;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class ClimbWeb {
	
	private static String uri;
	private static String tagname;

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
		Document parse = newInstance.newDocumentBuilder().parse(uri);
		NodeList byTagName = parse.getElementsByTagName(tagname);
		for(int i=0;i<byTagName.getLength();i++){
			String textContent = byTagName.item(i).getTextContent();
			if(textContent.equals("name")){
				
			}
		}
		
	}
	
	
	

}
