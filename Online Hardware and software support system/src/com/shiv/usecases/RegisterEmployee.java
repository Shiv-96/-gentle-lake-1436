package com.shiv.usecases;

import java.util.Scanner;

import com.shiv.beans.Employee;
import com.shiv.dao.EmployeeDao;
import com.shiv.dao.EmployeeDaoImpl;

public class RegisterEmployee {

	public void eegisterEmployee() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Engineer's Name");
		String name = sc.next();
		
		System.out.println("Enter Username");
		String username = sc.next();
		
		System.out.println("Enter Password");
		String password = sc.next();

		EmployeeDao dao = new EmployeeDaoImpl();
		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setUsername(username);
		employee.setPassword(password);
		
		String result = dao.registerEmployee(employee);
		
		System.out.println(result);
		
	}
	
}
