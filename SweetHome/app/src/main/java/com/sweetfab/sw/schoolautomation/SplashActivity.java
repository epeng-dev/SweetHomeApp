package com.sweetfab.sw.schoolautomation;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SplashActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		final ImageView imageView = (ImageView) findViewById(R.id.splashimage);

		Glide.with(this).load(R.drawable.sweethome).into(imageView);
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent intent = new Intent(SplashActivity.this, MainActivity.class);
				View sharedView = imageView;
				String transitionName = "sweethome";
				ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this, sharedView, transitionName);
				startActivity(intent, activityOptions.toBundle());
			}
		}, 2500);
	}
}
