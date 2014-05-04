package com.mediahack.geonewsi;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;


import com.mediahack.geonewsi.MainActivity.PlaceholderFragment;

import com.mediahack.geonewsi.social_media.DownloaderTask_Media;
import com.mediahack.geonewsi.social_media.Tweet;

	public class FragmentMedia extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		private SocialMediaAdapter mediaAdapter;
		private ListView listView;
		private Context context;
		
		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static FragmentMedia newInstance(int sectionNumber) {
			FragmentMedia fragment = new FragmentMedia();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public FragmentMedia() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			listView= (ListView) rootView.findViewById(R.id.listNews);
			mediaAdapter = new SocialMediaAdapter(this.getActivity());
			listView.setAdapter(mediaAdapter);
			
			//DataModel
			DownloaderTask_Media task = new DownloaderTask_Media(this);
			task.execute("");
			
			return rootView;
		
		
		}

		
		public void updateTweets(ArrayList<Tweet> result){
			int max = result.size();
			for(int i = 0; i<max; i++)
				mediaAdapter.add(result.get(i));
			
			//loading
		}
	
}
