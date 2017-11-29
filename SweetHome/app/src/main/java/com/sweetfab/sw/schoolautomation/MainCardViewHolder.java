package com.sweetfab.sw.schoolautomation;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mskan on 2017-10-11.
 */

public class MainCardViewHolder extends RecyclerView.ViewHolder {
	public TextView textView;
	public ImageView imageView;
	public CardView cardView;
	public MainCardViewHolder(View itemView) {
		super(itemView);
		textView = (TextView)itemView.findViewById(R.id.textView);
		imageView = (ImageView)itemView.findViewById(R.id.imageView);
		cardView = (CardView)itemView.findViewById(R.id.cardView);
	}
}
