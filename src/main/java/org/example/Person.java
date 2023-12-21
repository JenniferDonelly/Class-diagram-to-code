package org.example;

public abstract class Person {
	private String name;
	private String surname;
	private String phone;
	private String pesel;
	private int hourlyRate;

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getPhone() {
		return phone;
	}

	public String getPesel() {
		return pesel;
	}

	public int getHourlyRate() {
		return hourlyRate;
	}

	public Person(String name, String surname, String phone, String pesel, int hourlyRate) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.pesel = pesel;
		this.hourlyRate = hourlyRate;
	}

	public int calculateSalary() {
		return hourlyRate * 8 * 5 * 4;
	}
}
