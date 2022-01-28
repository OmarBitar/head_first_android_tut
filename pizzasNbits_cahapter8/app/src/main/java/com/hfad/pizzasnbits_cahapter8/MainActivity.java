package com.hfad.pizzasnbits_cahapter8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

	private ShareActionProvider shareActionProvider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
	}

	/*
	inflates your menu resource file. This means that it creates a
	Menu object that’s a Java representation of your menu resource file,
	and any actions the menu resource file contains are translated to
	MenuItems. These are then added to the app bar.
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);

		MenuItem menuItem = menu.findItem(R.id.action_share);
		shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
		setShareActionIntent("Want to join me for pizza?");

		return super.onCreateOptionsMenu(menu);
	}

	private void setShareActionIntent(String text) {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_TEXT, text);
		shareActionProvider.setShareIntent(intent);
	}
	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_create_order:
				Intent intent = new Intent(this, OrderActivity.class);
				startActivity(intent);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

}