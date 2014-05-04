package com.mediahack.geonewsi.news;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;

public class Response {

	/*"status": "ok",
    "userTier": "internal",
    "total": 28,
    "startIndex": 1,
    "pageSize": 10,
    "currentPage": 1,
    "pages": 3,
    "orderBy": "newest",

	 * */
	//ID
	public static String id_status = "status";
	public static String id_userTier = "userTier";
	public static String id_total = "total";
	// </ID>
	
	private String status;
	private String userTier;
	private String total;
	
	private List<News> list_news;
	
	public Response(){
		list_news = new ArrayList<News>();
		
	}
	
	public Response(String status, String userTier, String total){
		this.status = status;
		this.userTier = userTier;
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserTier() {
		return userTier;
	}

	public void setUserTier(String userTier) {
		this.userTier = userTier;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
	
	public void addNew(News news_obj){
		this.list_news.add(news_obj);
		
	}

	
}

