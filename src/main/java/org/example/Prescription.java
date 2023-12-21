package org.example;

import java.time.LocalDate;

public class Prescription {

	private static int prescriptionIdCounter = 1;

	private LocalDate date;
	private String pesel;
	private int prescriptionId;

	public LocalDate getDate() {
		return date;
	}

	public String getPesel() {
		return pesel;
	}

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public Prescription(LocalDate date, String pesel) {
		prescriptionId = prescriptionIdCounter++;

		this.date = date;
		this.pesel = pesel;
	}
}
