package com.shiv.dao;

import java.util.List;

import com.shiv.beans.Engineer;
import com.shiv.exception.ComplainException;
import com.shiv.exception.EmployeeException;
//import com.shiv.exception.ComplainException;
import com.shiv.exception.EngineerException;

public interface EngineerDao {

	public String registerEngineer(Engineer engineer);
	
	public Engineer loginForEngineer(String username, String password) throws EngineerException;
	
	public List<Engineer> getAllEngineer()throws EngineerException;
	
	public boolean deleteEngineer(int id) throws EngineerException;
	
	public List<Engineer> getAssignedProblem() throws EngineerException;
	
	public String allocateProblemToEngineer(int engid, int cid) throws EngineerException, ComplainException;
	
	public String changePasswordEngineer(String pass, String user) throws EngineerException;

	
}

