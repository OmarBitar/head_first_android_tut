package com.example.chapter2_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMsg(View view) {
        EditText input = (EditText) findViewById(R.id.editView);
        String msg = input.getText().toString();

        Intent intent = new Intent(this, receivedMsg.class);
        intent.putExtra(receivedMsg.EXTRA_MESSAGE ,msg);
        startActivity(intent);
    }

    public void shareMsg(View view) {
        EditText input = (EditText) findViewById(R.id.editView);
        String msg = input.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        startActivity(intent);
    }
}