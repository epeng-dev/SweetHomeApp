package com.sweetfab.sw.schoolautomation;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by mskan on 2017-10-11.
 */

public class MainCardViewAdapter extends RecyclerView.Adapter<MainCardViewHolder>{
	private ArrayList<MainCardViewItems> items;
	private Activity activity;

	public MainCardViewAdapter(ArrayList<MainCardViewItems> mainCardViewItems, Activity activity){
		this.items = mainCardViewItems;
		this.activity = activity;
	}

	@Override
	public MainCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_maincard, parent, false);
		return new MainCardViewHolder(view);
	}

	@Override
	public void onBindViewHolder(final MainCardViewHolder holder, final int position) {
		holder.imageView.setImageResource(items.get(position).getImageIcon());
		holder.textView.setText(items.get(position).getName());
		holder.cardView.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(activity, ItemActivity.class);
				intent.putExtra("imagePic", items.get(position).getImagePic());
				intent.putExtra("commandOnList", items.get(position).getCommandOnList());
				intent.putExtra("commandOffList", items.get(position).getCommandOffList());
				intent.putExtra("roomList", items.get(position).getRoomList());
				intent.putExtra("maincommand", items.get(position).getName());
				activity.startActivity(intent);
			}
		});
	}

	@Override
	public int getItemCount() {
		return items.size();
	}
}
