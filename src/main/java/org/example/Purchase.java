package org.example;

import java.time.LocalDate;

public class Purchase {
	private LocalDate date;
	private Employee assignee;
	private Prescription prescription;

	public LocalDate getDate() {
		return date;
	}

	public Employee getAssignee() {
		return assignee;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public Purchase(LocalDate date, Employee assignee, Prescription prescription) {
		this.date = date;
		this.assignee = assignee;
		this.prescription = prescription;
	}

	public Purchase(LocalDate date, Employee assignee) {
		this(date, assignee, null);
	}
}
