package com.shiv.beans;

public class Complain {

	private String category;
	private String assignedEngineer;
	
	public Complain() {
		// TODO Auto-generated constructor stub
	}

	public Complain(String category, String assignedEngineer) {
		super();
		this.category = category;
		this.assignedEngineer = assignedEngineer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAssignedEngineer() {
		return assignedEngineer;
	}

	public void setAssignedEngineer(String assignedEngineer) {
		this.assignedEngineer = assignedEngineer;
	}

	@Override
	public String toString() {
		return "Complain [category=" + category + ", assignedEngineer=" + assignedEngineer + "]";
	}
	
}
