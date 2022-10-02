package com.shiv.usecases;

import java.util.Scanner;

import com.shiv.dao.EmployeeDao;
import com.shiv.dao.EmployeeDaoImpl;
import com.shiv.exception.EmployeeException;

public class ChangeThePasswordForEmployee {

	public void changeThePassword() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Username");
		String uname = sc.next();
		
		System.out.println("New Password");
		String pass = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		try {
			String result = dao.changePasswordEmployee(pass, uname);
			
			System.out.println(result);
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
