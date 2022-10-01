package com.shiv.dao;

import com.shiv.beans.HOD;
import com.shiv.exception.HODException;

public interface HODDao {

	public String insertHODDetails(String name, String username, String password);
	
	public HOD loginHOD(String username, String password) throws HODException;

	
	
}
