package com.sweetfab.sw.schoolautomation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ItemActivity extends AppCompatActivity {
	int imagePic;
	ArrayList<String> commandOnList;
	ArrayList<String> commandOffList;
	ArrayList<String> roomList;
	String mainCommand;
	ArrayList<ItemCardViewItems> items;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item);
		setupWindowAnimations();

		imagePic = getIntent().getIntExtra("imagePic", 0);
		commandOnList = getIntent().getStringArrayListExtra("commandOnList");
		commandOffList = getIntent().getStringArrayListExtra("commandOffList");
		roomList = getIntent().getStringArrayListExtra("roomList");
		mainCommand = getIntent().getStringExtra("maincommand");
		ImageView imageView = (ImageView) findViewById(R.id.imageView);
		imageView.setBackgroundResource(imagePic);
		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
		recyclerView.setHasFixedSize(true);
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(layoutManager);

		items = new ArrayList<>();
		for(int i = 0; i < roomList.size(); i++){
			ItemCardViewItems item = new ItemCardViewItems();
			item.setCommandOn(commandOnList.get(i));
			item.setCommandOff(commandOffList.get(i));
			item.setRoomName(roomList.get(i));
			items.add(item);
		}

		RecyclerView.Adapter adapter = new ItemCardViewAdapter(items, this, mainCommand);
		recyclerView.setAdapter(adapter);
	}

	private void setupWindowAnimations(){
		Fade fade = new Fade();
		fade.setDuration(10000);
		getWindow().setEnterTransition(fade);
	}
}
