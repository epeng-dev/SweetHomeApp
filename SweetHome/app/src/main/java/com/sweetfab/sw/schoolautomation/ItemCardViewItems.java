package com.sweetfab.sw.schoolautomation;

import java.util.ArrayList;

/**
 * Created by mskan on 2017-09-27.
 */

public class ItemCardViewItems {
	private String roomName;
	private String commandOn;
	private String commandOff;
	private Boolean flag = false;

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getCommandOn() {
		return commandOn;
	}

	public void setCommandOn(String commandOn) {
		this.commandOn = commandOn;
	}

	public String getCommandOff() {
		return commandOff;
	}

	public void setCommandOff(String commandOff) {
		this.commandOff = commandOff;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
