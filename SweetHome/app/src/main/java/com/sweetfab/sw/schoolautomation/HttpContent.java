package com.sweetfab.sw.schoolautomation;

import android.app.Activity;
import android.content.Context;

/**
 * Created by mskan on 2017-10-12.
 */

public class HttpContent {
	private Activity activity;
	private String command;

	public HttpContent(){

	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
}
