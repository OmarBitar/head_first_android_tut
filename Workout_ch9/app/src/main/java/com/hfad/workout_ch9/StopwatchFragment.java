package com.hfad.workout_ch9;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.Locale;

public class StopwatchFragment extends Fragment implements View.OnClickListener{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);
		runTimer(layout);
		Button startBtn, stopBtn, resetBtn;
		currentLife = (TextView) layout.findViewById(R.id.currentLife);
		startBtn = (Button) layout.findViewById(R.id.start);
		stopBtn = (Button) layout.findViewById(R.id.stop);
		resetBtn = (Button) layout.findViewById(R.id.restart);
		startBtn.setOnClickListener(this);
		stopBtn.setOnClickListener(this);
		resetBtn.setOnClickListener(this);
		// Inflate the layout for this fragment
		return layout;
	}

	private int seconds = 0; private boolean running; private boolean wasRunning;
	private TextView currentLife;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

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

	private void onClickStart(){
		running = true;
		wasRunning = true;
		currentLife.setText("resumed");
	}

	private void onClickStop(){
		running = wasRunning = false;
	}

	private void onClickRestart(){
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

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.start:
				onClickStart();
				break;
			case R.id.stop:
				onClickStop();
				break;
			case R.id.restart:
				onClickRestart();
				break;
		}
	}
}