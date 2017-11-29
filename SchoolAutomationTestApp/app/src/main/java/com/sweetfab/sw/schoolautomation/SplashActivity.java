package com.sweetfab.sw.schoolautomation;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				finish();
				Intent intent = new Intent(SplashActivity.this, MainActivity.class);
				startActivity(intent);
			}
		}, 2500);
	}

	@Override
	public void finish() {
		super.finish();
		this.overridePendingTransition(R.anim.anim_stop, R.anim.anim_translate_right);
	}
}
