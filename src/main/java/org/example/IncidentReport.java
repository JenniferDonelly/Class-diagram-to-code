package org.example;

public class IncidentReport {

	private static int reportIdCounter = 1;
	
	private int reportId;
	private String name;
	private String description;

	public int getReportId() {
		return reportId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	private IncidentReport(String name, String description, Employee creator) {
		this.reportId = reportIdCounter++;
		this.name = name;
		this.description = description;
	}

	static public IncidentReport enterAnIncidentReport(String name, String description, Employee creator) {
		return new IncidentReport(name, description, creator);
	}
	
}
