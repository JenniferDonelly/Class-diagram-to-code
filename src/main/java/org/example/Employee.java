package org.example;

public class Employee extends Person {

	public Employee(String name, String surname, String phone, String pesel, int hourlyRate) {
		super(name, surname, phone, pesel, hourlyRate);
	}

	@Override
	public int calculateSalary() {
		return super.calculateSalary();
	}
}
