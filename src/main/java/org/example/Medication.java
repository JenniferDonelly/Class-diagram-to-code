package org.example;

import java.util.ArrayList;

public class Medication {
	private String name;
	private int shelfLife; // Number of days
	private ArrayList<Purchase> purchases;
	private bool forDisposal;

	public Medication(String name, int shelfLife) {
		this.name = name;
		this.shelfLife = shelfLife;
		purchases = new ArrayList<Purchase>();
	}

	public Medication(String name, int shelfLife, Purchase purchase) {
		this(name, shelfLife);
		purchases.add(purchase);
	}

	public bool isForDisposal() {
		return forDisposal;
	}

	public String getName() {
		return name;
	}
	public int getShelfLife() {
		return shelfLife;
	}
}
