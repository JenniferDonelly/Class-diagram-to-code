package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Request {

	private static int requestIdCounter = 1;

	private int requestId;
	private RequestType requestType;
	private String name;
	private String description;
	private Employee creator;
	private Manager reviewer;
	private boolean reviewed;
	private boolean accepted;
	private LocalDateTime creationDate;
	private LocalDateTime reviewDate;

	private static ArrayList<Request> requests = new ArrayList<Request>();

	private Request(RequestType requestType, String name, String description, Employee creator) {
		this.requestId = requestIdCounter++;
		requests.add(requestId, this);

		this.requestType = requestType;
		this.name = name;
		this.description = description;
		this.creator = creator;
		this.reviewer = null;
		this.reviewed = false;
		this.accepted = false;

		this.creationDate = LocalDateTime.now();
		this.reviewDate = null;
	}

	public int getRequestId() {
		return requestId;
	}

	public RequestType getRequestType() {return requestType; }

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Employee getCreator() {
		return creator;
	}

	public LocalDateTime getCreationDate() { return creationDate; }
	
	public boolean isReviewed() {
		return reviewed;
	}

	public Manager getReviewer() {
		return reviewer;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void review(Manager reviewer, boolean verdict) {
		this.reviewer = reviewer;
		this.reviewed = true;
		this.accepted = verdict;
		this.reviewDate = LocalDateTime.now();
	}

	public LocalDateTime getReviewDate() {return reviewDate; }

	public static ArrayList<Request> viewRequests() {
		return requests;
	}

	public static Request requestNewMedicine(Employee creator, String name, String description) {
		return new Request(RequestType.NEW_MED, name, description, creator);
	}

	public static Request requestResupply(Employee creator, String name, String description) {
		return new Request(RequestType.RESUPPLY, name, description, creator);
	}
}

enum RequestType {
	NEW_MED,
	RESUPPLY
}
