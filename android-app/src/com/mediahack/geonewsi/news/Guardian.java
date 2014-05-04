package com.mediahack.geonewsi.news;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import java.io.IOException;

public class Guardian {
	
	public static String LOG = "GuardianService";
	
	public static String id_response = "response";
	public static String id_section ="section";
	public static String id_result ="results";
	
	private String finalPoint;
	private Response response;

	public Guardian(){
		finalPoint = "http://content.guardianapis.com/uk-news?show-fields=productionOffice&show-editors-picks=true&show-most-viewed=true&date-id=date%2Flast24hours&api-key=mediahackdays2014";
		response = new Response();

	}
	public Guardian(String point){
		finalPoint = point; //http://explorer.content.guardianapis.com/#/search?q=spain&api-key=mediahackdays2014
		response = new Response();
	}
	
	private String getResponse() throws IOException{
		URL url = new URL(finalPoint);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String entrada;
		String cadena="";
		while ((entrada = br.readLine()) != null){
			cadena = cadena + entrada;
		}
		return cadena;
	}
	
	public ArrayList<News> listNews(){
		return initiate();
	}
	
	private ArrayList<News> initiate(){
		ArrayList<News> listNews = new ArrayList<News>();
		try {
			String response = getResponse();
			
			if(response!=null){

			JSONObject oJson = new JSONObject(response);
			

			//Status OK
			if(oJson.getJSONObject(id_response).getString(Response.id_status).equalsIgnoreCase("ok")){
				
				JSONObject oJsonResponse = oJson.getJSONObject(id_response);
				
				JSONArray news_array = oJsonResponse.getJSONArray(id_result);
				
				int size = news_array.length();
				for(int i = 0; i<size; i++){
					JSONObject jsonNews = news_array.getJSONObject(i);
					News news = new News(jsonNews.getString(News.id_webUrl),jsonNews.getString(News.id_sectionName),jsonNews.getString(News.id_webTitle));
					listNews.add(news);
				}
			
			} 

			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return listNews;
	}
}
