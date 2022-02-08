package com.hfad.collapsing_toolbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void fabBtn(View view) {
		String Text = "hello world";
		Snackbar.make(findViewById(R.id.fab),Text,Snackbar.LENGTH_SHORT)
				.setAnchorView(findViewById(R.id.fab))
				.show();
	}
}