package com.hfad.chapter5_views_headfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onToggleEmotion(View view) {
        ToggleButton btn = (ToggleButton) findViewById(R.id.toggleEmotion);
        TextView response = (TextView) findViewById(R.id.mood_result);
        if (btn.isChecked()) {
            response.setText("👍");
        } else {
            response.setText("👎");
        }
    }

    public void onSwitchToggle(View view) {
        Switch btn  = (Switch) findViewById(R.id.switch1);
        TextView response = (TextView) findViewById(R.id.day_response);
        if (btn.isChecked()) {
            response.setText("👍");
        } else {
            response.setText("👎");
        }
    }
}