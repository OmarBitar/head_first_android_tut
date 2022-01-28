package com.example.chapter2_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class receivedMsg extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received_msg);
        Intent intent = getIntent();
        TextView textView = (TextView) findViewById(R.id.recivedMsg);
        textView.setText(intent.getStringExtra(EXTRA_MESSAGE));
    }

    public void shareMsg(View view) {
        TextView text = (TextView) findViewById(R.id.recivedMsg);
        String msg = text.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, msg);

        Intent chooserIntent = Intent.createChooser(intent, getString(R.string.chooser));
        startActivity(chooserIntent);
    }
}