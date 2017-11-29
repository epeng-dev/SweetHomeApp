package com.sweetfab.sw.schoolautomation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by mskan on 2017-09-27.
 */

public class MainFragment extends Fragment {
	private ArrayList<MainCardViewItems> items;
	public MainFragment(){

	}

	public static MainFragment newInstance() {

		Bundle args = new Bundle();

		MainFragment fragment = new MainFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main, container, false);
		final EditText editText = (EditText) view.findViewById(R.id.edittext);
		Button button = (Button) view.findViewById(R.id.button);
		RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
		recyclerView.setHasFixedSize(true);
		RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
		recyclerView.setLayoutManager(layoutManager);
		items = new ArrayList<MainCardViewItems>();
		for(int i = 0; i < 2; i++){
			MainCardViewItems item = new MainCardViewItems();
			item.setImage(R.drawable.light);
			if(i == 0)	item.setName("스위치 전체 ON");
			else item.setName("스위치 전체 OFF");
			items.add(item);
		}
		RecyclerView.Adapter adapter = new MainCardViewAdapter(items, getContext());
		recyclerView.setAdapter(adapter);

		button.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				String request = editText.getText().toString();
				ContextBox contextBox = new ContextBox(getContext(), request);
				HttpAsyncTask httpAsyncTask = new HttpAsyncTask();
				httpAsyncTask.execute(contextBox);
			}
		});
		return view;
	}
}
