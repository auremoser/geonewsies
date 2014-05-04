package com.mediahack.geonewsi.news;

public class News {

	//<ID>
	public static String id_ID = "id";
	public static String id_sectionID = "sectionId";
	public static String id_sectionName = "sectionName";
	public static String id_webPublicationDate ="webPublicationDate";
	public static String id_webTitle = "webTitle";
	public static String id_webUrl = "webUrl";
	public static String id_apiUrl = "apiUrl";
	//</ID>
	
	private String url;
	private String sectionName;
	private String title;
	
	public News(){
		
	}
	
	public News(String url, String sectionName, String title){
		this.url = url;
		this.sectionName = sectionName;
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
