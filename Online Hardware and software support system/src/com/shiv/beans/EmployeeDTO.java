package com.shiv.beans;

public class EmployeeDTO {

	private int id;
	private String status;
	private String AssignedEngineer;
	private String complainName;
	
	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeDTO(int id, String status, String assignedEngineer, String complainName) {
		super();
		this.id = id;
		this.status = status;
		AssignedEngineer = assignedEngineer;
		this.complainName = complainName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssignedEngineer() {
		return AssignedEngineer;
	}

	public void setAssignedEngineer(String assignedEngineer) {
		AssignedEngineer = assignedEngineer;
	}

	public String getComplainName() {
		return complainName;
	}

	public void setComplainName(String complainName) {
		this.complainName = complainName;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", status=" + status + ", AssignedEngineer=" + AssignedEngineer
				+ ", complainName=" + complainName + "]";
	}
	
	
	
}
