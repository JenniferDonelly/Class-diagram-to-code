package org.example;

import java.util.ArrayList;

public class Medication {
	private String name;
	private int shelfLife; // Number of days
	private ArrayList<Purchase> purchases;
	private boolean forDisposal;

	public Medication(String name, int shelfLife) {
		this.name = name;
		this.shelfLife = shelfLife;
		this.purchases = new ArrayList<>();
		this.forDisposal = false; // default value
	}

	public Medication(String name, int shelfLife, Purchase purchase) {
		this(name, shelfLife);
		this.purchases.add(purchase);
	}

	public boolean isForDisposal() {
		return forDisposal;
	}

	public void setForDisposal(boolean forDisposal) {
		this.forDisposal = forDisposal;
	}

	public String getName() {
		return name;
	}

	public int getShelfLife() {
		return shelfLife;
	}

	public ArrayList<Purchase> getPurchases() {
		return purchases;
	}

	public void addPurchase(Purchase purchase) {
		if(purchase != null) {
			this.purchases.add(purchase);
		}
	}
}
