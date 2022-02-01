package com.hfad.workout_ch9;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Locale;

public class StopwatchFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_stopwatch, container, false);
	}

	private int seconds = 0; private boolean running; private boolean wasRunning;
	private TextView currentLife;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		currentLife = (TextView) findViewById(R.id.currentLife);

		if (savedInstanceState != null) {
			seconds = savedInstanceState.getInt("seconds");
			running = savedInstanceState.getBoolean("running");
			wasRunning = savedInstanceState.getBoolean("wasRunning");
		}

	}

	@Override
	public void onResume() {
		super.onResume();
		if (wasRunning) {
			currentLife.setText("resumed");
			running = true;
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		currentLife.setText("paused");
		running = false;
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putInt("seconds", seconds);
		savedInstanceState.putBoolean("running", running);
		savedInstanceState.putBoolean("wasRunning",wasRunning);
	}

	public void onClickStart(View view){
		running = true;
		wasRunning = true;
		currentLife.setText("resumed");
	}

	public void onClickStop(View view){
		running = wasRunning = false;
	}

	public void onClickRestart(View view){
		running =  false;
		seconds = 0;
	}

	private void runTimer(View view){
		final Handler handler = new Handler();
		handler.post(new Runnable() {
			@Override
			public void run() {
				int hours = seconds/3600;
				int minutes = (seconds%3600)/60;
				int secs = seconds%60;
				String time = String.format(
						Locale.getDefault(),"%d:%02d:%02d", hours, minutes, secs
				);

				TextView timeView = (TextView) view.findViewById(R.id.time_view);
				timeView.setText(time);
				if(running) { seconds++; }

				handler.postDelayed(this,1000);
			}
		});
	}
}