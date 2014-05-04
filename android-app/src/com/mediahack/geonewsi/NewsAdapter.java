package com.mediahack.geonewsi;

import com.mediahack.geonewsi.news.*;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsAdapter extends BaseAdapter {
	
	private List<News> list_news = new ArrayList<News>();
	private Context context;
	
	public NewsAdapter(Context context){
		this.context = context;
	}
	
	
	public void add(News news){
		list_news.add(news);
		notifyDataSetChanged();
	}
	
	public void clear(){
		list_news.clear();
	}
	
	@Override
	public int getCount() {
		return list_news.size();
	}

	@Override
	public Object getItem(int position) {
		return list_news.get(position);
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
			    convertView = mInflater.inflate(R.layout.row, null, true);
				
			   }

				News news = list_news.get(position);
				
				//ImageView pic = (ImageView) convertView.findViewById(R.id.rowView);
				//pic.setLayoutParams(new GridView.LayoutParams(185, 185));
				//pic.setScaleType(ImageView.ScaleType.);
				TextView name = (TextView) convertView.findViewById(R.id.rowText);
				//TableRow listUser = (TableRow) convertView.findViewById(R.id.listUsers);
				
				
				//listUser.setBackgroundColor(Color.rgb(79, 213, 214));
				//pic.setImageResource(student.getReference_icon_user());
				name.setText(news.getTitle());
				//name.setBackgroundColor(R.color.dark_cyan);  
				
				return convertView;
	}

}
