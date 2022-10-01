package com.shiv.dao;

import java.util.List;

import com.shiv.beans.Engineer;
import com.shiv.exception.EngineerException;

public interface EngineerDao {

	public String registerEngineer(Engineer engineer);
	
	public List<Engineer> getAllEngineer()throws EngineerException;
	
	public boolean deleteEngineer(int id) throws EngineerException;
	
	public List<Engineer> getAssignedProblem() throws EngineerException;
	
}
