package com.shiv.beans;

public class Engineer {

	private int id;
	private String name;
	private String username;
	private String password;
	private String category;
	private String isAssigned;
	
	public Engineer() {
		
	}

	public Engineer(String name, String username, String password, String category) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.category = category;
	}
	

	public Engineer(String name, String username, String password, String category, String isAssigned) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.category = category;
		this.isAssigned = isAssigned;
	}

	
	
	public Engineer(int id, String name, String username, String password, String category, String isAssigned) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.category = category;
		this.isAssigned = isAssigned;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	

	public String getIsAssigned() {
		return isAssigned;
	}

	public void setIsAssigned(String isAssigned) {
		this.isAssigned = isAssigned;
	}

	@Override
	public String toString() {
		return "Engineer [name=" + name + ", username=" + username + ", password=" + password + ", category=" + category
				+ ", isAssigned=" + isAssigned + "]";
	}

	
	
	
	
}
