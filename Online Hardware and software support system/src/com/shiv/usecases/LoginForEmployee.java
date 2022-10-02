package com.shiv.usecases;

import java.util.Scanner;

import com.shiv.beans.Employee;
import com.shiv.dao.EmployeeDao;
import com.shiv.dao.EmployeeDaoImpl;
import com.shiv.exception.EmployeeException;

public class LoginForEmployee {

	public boolean loginForEmployee() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username:");
		String username = sc.next();
		
		System.out.println("Enter password:");
		String password = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			Employee employee = dao.loginEmployee(username, password);
			
			System.out.println("Welcome "+employee.getName());
			System.out.println("===========================");
			return true;
			
		} catch (EmployeeException ee) {
			System.out.println(ee.getMessage());
		}
		return false;
	}
	
}
