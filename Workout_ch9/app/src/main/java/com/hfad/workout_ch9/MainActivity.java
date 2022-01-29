package com.hfad.workout_ch9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
		implements WorkoutListFragment.Listener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public void itemClicked(long id) {
		View fragmentContainer = findViewById(R.id.fragment_container);
		if (fragmentContainer != null) {
			WorkoutDetailFragment details = new WorkoutDetailFragment();
			// start transaction
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			details.setWorkout(id);
			ft.replace(R.id.fragment_container, details);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.addToBackStack(null);
			ft.commit();
		} else {
			Intent intent = new Intent(this, DetailActivity.class);
			intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
			startActivity(intent);
		}
	}

}