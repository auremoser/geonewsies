package com.mediahack.geonewsi;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebView_Activity extends Activity {

	public static String URL_ID =  "urlextra";
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview);
		WebView webview = (WebView) findViewById(R.id.webView);
		//myWebView.loadUrl("https://taalk.vline.com/o65mryu0bmg6chkn");
		
	 String URL =  this.getIntent().getExtras().getString(URL_ID);

	        webview.clearCache(true);
	        webview.clearHistory();
	        WebSettings webSettings = webview.getSettings();
	        webSettings.setJavaScriptEnabled(true);
	        webSettings.setDomStorageEnabled(true);
	        webview.setWebViewClient(new WebViewClient());
	        //webview.setWebChromeClient(new WebChromeClient());
	       // webview.addJavascriptInterface(new JavaScriptInterface(this), "Android");

	        setContentView(webview);
	       webview.loadUrl(URL);
	
	   
	      /* getActionBar().setHomeButtonEnabled(true); // diferences?¿ */
	
	}
}
