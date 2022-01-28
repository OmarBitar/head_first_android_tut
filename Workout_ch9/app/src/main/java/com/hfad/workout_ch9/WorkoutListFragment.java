package com.hfad.workout_ch9;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WorkoutListFragment extends ListFragment {

	static interface Listener {
		void itemClicked(long id);
	}
	private Listener listener;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		String[] names = new String[Workout.workouts.length];
		for (int i = 0 ; i < names.length; i++) {
			names[i] = Workout.workouts[i].getName();
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<>(
				inflater.getContext(), android.R.layout.simple_list_item_1, names
		);
		// bind array to adapter
		setListAdapter(adapter);
		// calling the superclass onCreateView() method gives you the default
		// layout for the ListFragment.
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	// this is how we can get the context of the activity this gets attached to this fragment
	@Override
	public void onAttach(@NonNull Context context) {
		super.onAttach(context);
		this.listener = (Listener) context;
	}

	@Override
	public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
		if (listener != null) {
			listener.itemClicked(id);
		}
	}
}