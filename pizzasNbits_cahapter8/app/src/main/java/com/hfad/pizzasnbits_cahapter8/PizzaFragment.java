package com.hfad.pizzasnbits_cahapter8;

import android.app.ListFragment;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class PizzaFragment extends ListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		ArrayAdapter<String> adapter = new ArrayAdapter<>(
				inflater.getContext(),
				android.R.layout.simple_list_item_1,
				getResources().getStringArray(R.array.pizzas)
		);
		setListAdapter(adapter);
		// Inflate the layout for this fragment
		return super.onCreateView(inflater, container, savedInstanceState);
	}
}