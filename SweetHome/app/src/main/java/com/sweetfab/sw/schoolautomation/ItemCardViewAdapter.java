package com.sweetfab.sw.schoolautomation;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import java.util.ArrayList;

/**
 * Created by mskan on 2017-10-11.
 */

public class ItemCardViewAdapter extends RecyclerView.Adapter<ItemCardViewHolder>{
	private ArrayList<ItemCardViewItems> items;
	private Activity activity;
	private String mainCommand;

	public ItemCardViewAdapter(ArrayList<ItemCardViewItems> cardViewItems, Activity activity, String command){
		this.items = cardViewItems;
		this.activity = activity;
		this.mainCommand = command;
	}

	@Override
	public ItemCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_itemcard, parent, false);
		return new ItemCardViewHolder(view);
	}

	@Override
	public void onBindViewHolder(final ItemCardViewHolder holder, final int position) {
		holder.commandView.setText(mainCommand);
		holder.roomView.setText(items.get(position).getRoomName());
		holder.cardView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				holder.commandSwitch.toggle();
			}
		});
		holder.commandSwitch.setChecked(items.get(position).isFlag());
		holder.commandSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					HttpContent httpContent = new HttpContent();
					httpContent.setCommand(items.get(position).getCommandOn());
					httpContent.setActivity(activity);
					items.get(position).setFlag(true);
					HttpAsyncTask httpAsyncTask = new HttpAsyncTask();
					httpAsyncTask.execute(httpContent);
				}
				else{
					HttpContent httpContent = new HttpContent();
					httpContent.setCommand(items.get(position).getCommandOff());
					httpContent.setActivity(activity);
					items.get(position).setFlag(false);
					HttpAsyncTask httpAsyncTask = new HttpAsyncTask();
					httpAsyncTask.execute(httpContent);
				}
			}
		});

	}

	@Override
	public int getItemCount() {
		return items.size();
	}
}
