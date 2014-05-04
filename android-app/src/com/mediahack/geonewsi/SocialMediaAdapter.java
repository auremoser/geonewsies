package com.mediahack.geonewsi;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mediahack.geonewsi.social_media.Tweet;

public class SocialMediaAdapter extends BaseAdapter{


	private List<Tweet> list_media = new ArrayList<Tweet>();
	private Context context;
	
	public SocialMediaAdapter(Context context){
		this.context = context;
	}
	
	
	public void add(Tweet tweet){
		list_media.add(tweet);
		notifyDataSetChanged();
	}
	
	public void clear(){
		list_media.clear();
	}
	
	@Override
	public int getCount() {
		return list_media.size();
	}

	@Override
	public Object getItem(int position) {
		return list_media.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO No ID?
		return position;
	}

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		 if(convertView == null){
			   
			    LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			    convertView = mInflater.inflate(R.layout.row_media, null, true);
				
			   }

				Tweet tweet = list_media.get(position);
				
				//ImageView pic = (ImageView) convertView.findViewById(R.id.rowView);
				//pic.setLayoutParams(new GridView.LayoutParams(185, 185));
				//pic.setScaleType(ImageView.ScaleType.);
				TextView name = (TextView) convertView.findViewById(R.id.rowText);
				//TableRow listUser = (TableRow) convertView.findViewById(R.id.listUsers);
				
				
				//listUser.setBackgroundColor(Color.rgb(79, 213, 214));
				//pic.setImageResource(student.getReference_icon_user());
				name.setText(tweet.getMessage());
				//name.setBackgroundColor(R.color.dark_cyan);  
				
				return convertView;
	}
}
