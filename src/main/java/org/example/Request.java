package org.example;

import java.util.ArrayList;

public class Request {

	private static int requestIdCounter = 1;

	private int requestId;
	private String name;
	private String description;
	private Employee creator;
	private Manager reviewer;
	private boolean reviewed;
	private boolean accepted;

	private static ArrayList<Request> requests = new ArrayList<Request>();

	public Request(String name, String description, Employee creator) {
		this.requestId = requestIdCounter++;
		requests.add(requestId, this);

		this.name = name;
		this.description = description;
		this.creator = creator;
		this.reviewer = null;
		this.reviewed = false;
		this.accepted = false;
	}

	public int getRequestId() {
		return requestId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Employee getCreator() {
		return creator;
	}
	
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
	}

	public static ArrayList<Request> viewRequests() {
		return requests;
	}
	
}
