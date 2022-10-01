package com.shiv.usecases;

import java.util.Scanner;

import com.shiv.dao.EngineerDao;
import com.shiv.dao.EngineerDaoImpl;
import com.shiv.exception.EngineerException;

public class DeleteEngineer {

	public void deleteEngineerById(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the id");
		
		int id = sc.nextInt();
		
		EngineerDao dao = new EngineerDaoImpl();
		
		try {
			boolean x = dao.deleteEngineer(id);
			if(x) {
				System.out.println("Engineer with id "+id+" is deleted from this system");
			}
			else {
				System.out.println("Engineer with id "+id+" is not found in our system");
			}
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	
	
}
