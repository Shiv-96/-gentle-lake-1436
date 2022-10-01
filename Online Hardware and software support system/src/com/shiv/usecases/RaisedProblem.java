package com.shiv.usecases;

import java.util.List;

import com.shiv.beans.Engineer;
import com.shiv.dao.EngineerDao;
import com.shiv.dao.EngineerDaoImpl;
import com.shiv.exception.EngineerException;

public class RaisedProblem {

	public void raisedProblemForEngineer() {
		
		EngineerDao dao = new EngineerDaoImpl();
		
		try {
			List<Engineer> engineers = dao.getAssignedProblem();
			
			engineers.forEach(e ->{
				
				System.out.println("=======================================");
				
				System.out.println("Engineer's Name is "+e.getName());
				System.out.println(e.getName()+" is dealing "+e.getCategory()+" realated issue");
				System.out.println(e.getName()+" is Assigned to "+e.getIsAssigned());
				
				System.out.println("=======================================");
				
			});
			
			
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	
	
}
