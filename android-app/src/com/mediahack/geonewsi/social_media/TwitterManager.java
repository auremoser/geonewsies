package com.mediahack.geonewsi.social_media;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import twitter4j.Query;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Trend;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterManager {
	
	private String jSTrend_Place = "https://api.twitter.com/1.1/trends/place.json?";//Trending topics by place
	private String woeid_London = "id=44418,";
	private String finalEndPoint;
	
	private Twitter twitter;
	
	private String ACCESS_TOKEN = "2424378884-zTZGO8BFosgswLY4FfcCj4xsa6VSn5VSnDWCGgV";
	private String ACCESS_TOKEN_SECRET = "QEY8fahJBuVODGMT3qvC0HB9HzQRcKe70FuM1mMu3qNgT";
	private String KEY = "W8rWnji5Hs0cSxaBAUnc3BDmw";
	private String SECRET = "K9ponFICMxlM379Mpc7ncuul4epMoVAOWMvE2O9G2FN0dNAVev";
	
	public TwitterManager(){
		//finalEndPoint = jSTrend_Place+woeid_London;
		twitter = this.getTwitter();

	
		
	}
	
	public ArrayList<Tweet> listTweets(){
		
	
		ArrayList<Tweet> listTemp = new ArrayList<Tweet>();
		
		
		
		Trends trends;
		try {
			trends = twitter.getPlaceTrends(23424975);
			for (int i = 0; i < trends.getTrends().length; i++) {
				String tmp = trends.getTrends()[i].getName();
				Tweet temp = new Tweet(tmp,tmp);
				listTemp.add(temp);
			}
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		return listTemp;
	}
	
	// Authorization needed to get data from  Twitter...
	 @SuppressLint("NewApi")
	private Twitter getTwitter() {
		 
	        ConfigurationBuilder cb = new ConfigurationBuilder();
	        cb.setOAuthConsumerKey(KEY);
	        cb.setOAuthConsumerSecret(SECRET);
	        cb.setOAuthAccessToken(ACCESS_TOKEN);
	        cb.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
	        return new TwitterFactory(cb.build()).getInstance();
	   
	 }

}
