package com.sweetfab.sw.schoolautomation;

import android.content.Context;

/**
 * Created by mskan on 2017-10-12.
 */

public class ContextBox {
	Context context;
	String command;

	public ContextBox(Context ct, String cmd){
		this.context = ct;
		this.command = cmd;
	}

	public Context getContext() {
		return context;
	}

	public String getCommand() {
		return command;
	}
}
