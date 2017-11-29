package com.sweetfab.sw.schoolautomation;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by mskan on 2017-09-27.
 */

public class MainCardViewItems {
	private String name;
	private int imageIcon;
	private int imagePic;
	private ArrayList<String> roomList;
	private ArrayList<String> commandOnList;
	private ArrayList<String> commandOffList;

	public int getImagePic() {
		return imagePic;
	}

	public void setImagePic(int imagePic) {
		this.imagePic = imagePic;
	}

	public int getImageIcon() {
		return imageIcon;
	}

	public void setImageIcon(int imageIcon) {
		this.imageIcon = imageIcon;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public ArrayList<String> getRoomList() {
		return roomList;
	}

	public void setRoomList(ArrayList<String> roomList) {
		this.roomList = roomList;
	}

	public ArrayList<String> getCommandOnList() {
		return commandOnList;
	}

	public void setCommandOnList(ArrayList<String> commandOnList) {
		this.commandOnList = commandOnList;
	}

	public ArrayList<String> getCommandOffList() {
		return commandOffList;
	}

	public void setCommandOffList(ArrayList<String> commandOffList) {
		this.commandOffList = commandOffList;
	}
}
