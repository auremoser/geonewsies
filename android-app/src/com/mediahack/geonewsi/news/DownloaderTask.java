package com.mediahack.geonewsi.news;

import java.util.ArrayList;

import com.mediahack.geonewsi.MainActivity.PlaceholderFragment;

import android.os.AsyncTask;

public class DownloaderTask extends AsyncTask<String, Void, ArrayList<News>> {

	private PlaceholderFragment fragment;
	
	public DownloaderTask(PlaceholderFragment fragment){
		this.fragment = fragment;
	}
	
	@Override
	protected ArrayList<News> doInBackground(String... params) {
		//Execute Guardian API
		
		Guardian g = new Guardian();
		return g.listNews();
	}
	
	@Override
	public void onPostExecute(ArrayList<News> result) {
		super.onPostExecute(result);

		if (fragment != null) {
			fragment.updateNews(result);
		}

	}

}
