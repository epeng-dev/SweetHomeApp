package com.sweetfab.sw.schoolautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupWindowAnimations();

		ImageView imageView = (ImageView) findViewById(R.id.imageView);
		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

		Glide.with(this).load(R.drawable.sweethome).into(imageView);
		recyclerView.setHasFixedSize(true);
		RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
		recyclerView.setLayoutManager(layoutManager);
		ArrayList<MainCardViewItems> items = new ArrayList<>();

		ArrayList<String> roomList = new ArrayList<>();
		roomList.add("2-3");
		ArrayList<String> commandOnList = new ArrayList<>();
		commandOnList.add("EBHAoneon");
		ArrayList<String> commandOffList = new ArrayList<>();
		commandOffList.add("EBHAoneoff");
		MainCardViewItems item = new MainCardViewItems();
		item.setImageIcon(R.drawable.light_icon);
		item.setImagePic(R.drawable.light_pic);
		item.setName("Light");
		item.setRoomList(roomList);
		item.setCommandOnList(commandOnList);
		item.setCommandOffList(commandOffList);
		items.add(item);

		roomList = new ArrayList<>();
		roomList.add("2-3");
		commandOnList = new ArrayList<>();
		commandOnList.add("EBHAtwoon");
		commandOffList = new ArrayList<>();
		commandOffList.add("EBHAtwooff");
		item = new MainCardViewItems();
		item.setImageIcon(R.drawable.aircon_icon);
		item.setImagePic(R.drawable.aircon_pic);
		item.setName("Aircon");
		item.setRoomList(roomList);
		item.setCommandOnList(commandOnList);
		item.setCommandOffList(commandOffList);
		items.add(item);

		roomList = new ArrayList<>();
		roomList.add("2-3");
		commandOnList = new ArrayList<>();
		commandOnList.add("EBHAblindup");
		commandOffList = new ArrayList<>();
		commandOffList.add("EBHAblinddown");
		item = new MainCardViewItems();
		item.setImageIcon(R.drawable.blind_icon);
		item.setImagePic(R.drawable.blind_pic);
		item.setName("Blind");
		item.setRoomList(roomList);
		item.setCommandOnList(commandOnList);
		item.setCommandOffList(commandOffList);
		items.add(item);

		RecyclerView.Adapter adapter = new MainCardViewAdapter(items, this);
		recyclerView.setAdapter(adapter);
	}

	@Override
	public void onBackPressed() {
		finishAffinity();
	}

	private void setupWindowAnimations(){
		Slide slide = new Slide();
		slide.setDuration(500);
		getWindow().setEnterTransition(slide);
	}
}
