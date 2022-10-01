package com.shiv.usecases;

import java.util.List;

import com.shiv.beans.Engineer;
import com.shiv.dao.EngineerDao;
import com.shiv.dao.EngineerDaoImpl;
import com.shiv.exception.EngineerException;

public class GetAllRegisteredEngineer {

	public void getRegisteredEngineer() {
		
		EngineerDao dao = new EngineerDaoImpl();
		
		try {
			List<Engineer> engineers = dao.getAllEngineer();
			
			
			engineers.forEach(e ->{
				
				System.out.println("Engineer's Name : "+e.getName());
				System.out.println("Engineer's username : "+e.getUsername());
				System.out.println("Engineer's Password : "+e.getPassword());
				System.out.println("Engineer's Category : "+e.getCategory());
				System.out.println("Problem Assigned : "+e.getIsAssigned());
				
				System.out.println("=======================================");
				
			});
		} catch (EngineerException ee) {
			System.out.println(ee.getMessage());
		}
	}
	
}
