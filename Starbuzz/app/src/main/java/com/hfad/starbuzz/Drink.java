package com.hfad.starbuzz;

public class Drink {
	private String name, description;
	private int imageResourceId;

	public Drink(String name, String description, int imageResourceId) {
		this.name = name;
		this.description = description;
		this.imageResourceId = imageResourceId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getImageResourceId() {
		return imageResourceId;
	}

	public String toString() { return this.name; }

	public static final Drink[] drinks = {
		new Drink("Latte","A couple of espresso shots with steamed milk",R.drawable.latte),
		new Drink("boiled coffee","coffee powder mixed with hot water",R.drawable.boiled_coffee),
		new Drink("roast coffee","hanned picked coffee beans",R.drawable.roast_coffee)
	};
}
