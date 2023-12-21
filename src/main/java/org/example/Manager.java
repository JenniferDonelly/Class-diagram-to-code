package org.example;

public class Manager extends Person {

	private int bonus;

	public int getBonus() {
		return bonus;
	}

	public Manager(String name, String surname, String phone, String pesel, int hourlyRate, int bonus) {
		super(name, surname, phone, pesel, hourlyRate);
		this.bonus = bonus;
	}

	@Override
	public int calculateSalary() {
		return super.calculateSalary() + bonus;
	}
}
