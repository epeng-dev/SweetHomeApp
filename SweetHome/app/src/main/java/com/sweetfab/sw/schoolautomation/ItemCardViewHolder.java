package com.sweetfab.sw.schoolautomation;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by mskan on 2017-10-11.
 */

public class ItemCardViewHolder extends RecyclerView.ViewHolder {
	public TextView roomView;
	public TextView commandView;
	public CardView cardView;
	public Switch commandSwitch;

	public ItemCardViewHolder(View itemView) {
		super(itemView);
		roomView = (TextView)itemView.findViewById(R.id.roomText);
		commandView = (TextView)itemView.findViewById(R.id.commandText);
		cardView = (CardView)itemView.findViewById(R.id.cardView);
		commandSwitch = (Switch)itemView.findViewById(R.id.Switch);
	}
}
