package com.sweetfab.sw.schoolautomation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by mskan on 2017-10-11.
 */

public class MainCardViewAdapter extends RecyclerView.Adapter<MainCardViewHolder>{
	private ArrayList<MainCardViewItems> items;
	private Context context;

	public MainCardViewAdapter(ArrayList<MainCardViewItems> mainCardViewItems, Context context){
		this.items = mainCardViewItems;
		this.context = context;
	}

	@Override
	public MainCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
		return new MainCardViewHolder(view);
	}

	@Override
	public void onBindViewHolder(MainCardViewHolder holder, final int position) {
		holder.imageView.setImageResource(items.get(position).getImage());
		holder.textView.setText(items.get(position).getName());
		holder.cardView.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				Toast.makeText(context, items.get(position).getName(), Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public int getItemCount() {
		return items.size();
	}
}
