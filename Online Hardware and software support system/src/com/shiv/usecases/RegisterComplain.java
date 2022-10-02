package com.shiv.usecases;

import java.util.Scanner;

import com.shiv.beans.Complain;
import com.shiv.dao.EmployeeDao;
import com.shiv.dao.EmployeeDaoImpl;
import com.shiv.exception.EmployeeException;

public class RegisterComplain {

	public void registerCommplain(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter The category In which you want to raised the complain (Hardware / Software)");
		
		String category = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		Complain complain = new Complain();
		complain.setCategory(category);
		complain.setAssignedEngineer("Not Assigned");
		
		try {
			String result = dao.registerComplain(complain);
			
			System.out.println(result);
		} catch (EmployeeException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
