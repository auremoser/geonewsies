package com.mediahack.geonewsi.social_media;

import java.util.ArrayList;

import android.os.AsyncTask;

import com.mediahack.geonewsi.FragmentMedia;
import com.mediahack.geonewsi.MainActivity.PlaceholderFragment;



public class DownloaderTask_Media extends AsyncTask<String, Void, ArrayList<Tweet>>{

	private FragmentMedia fragment;
	
	public DownloaderTask_Media(FragmentMedia fragment) {
		this.fragment = fragment;
	}
	
	@Override
	protected ArrayList<Tweet> doInBackground(String... params) {
		TwitterManager mTwitter = new TwitterManager();
		return mTwitter.listTweets();
	}
	
	@Override
	public void onPostExecute(ArrayList<Tweet> result) {
		super.onPostExecute(result);

		if (fragment != null) {
			fragment.updateTweets(result);
		}

	}

}
