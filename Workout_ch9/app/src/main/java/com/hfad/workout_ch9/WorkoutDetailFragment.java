package com.hfad.workout_ch9;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WorkoutDetailFragment extends Fragment {

	private long workoutId;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState != null) {
			workoutId = savedInstanceState.getLong("workoutId");
		}
	}

	//Inflating the layout turns your XML views into Java objects.
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_workout_detail, container, false);
	}

	@Override
	public void onStart() {
		super.onStart();
		// to get accesss to other view components; must use view class since frag does not
		// inheret the same functions as the activity class
		// The getView() method gets the fragment's root View. We can then use this to get
		// references to the workout title and description text views.
		View view = getView();
		if (view != null) {
			TextView title = (TextView) view.findViewById(R.id.textTitle);
			TextView description = (TextView) view.findViewById(R.id.textDescription);
			Workout workout = Workout.workouts[(int) workoutId];
			title.setText(workout.getName());
			description.setText(workout.getDescription());
		}
	}

	@Override
	public void onSaveInstanceState(@NonNull Bundle outState) {
		outState.putLong("workoutId", workoutId);
	}

	public void setWorkout(long id) {
		this.workoutId = id;
	}
}