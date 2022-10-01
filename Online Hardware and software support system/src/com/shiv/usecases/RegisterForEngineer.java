package com.shiv.usecases;

import java.util.Scanner;

import com.shiv.beans.Engineer;
import com.shiv.dao.EngineerDao;
import com.shiv.dao.EngineerDaoImpl;

public class RegisterForEngineer {

	public void registerEngineer() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Engineer's Name");
		String name = sc.next();
		
		System.out.println("Enter Username");
		String username = sc.next();
		
		System.out.println("Enter Password");
		String password = sc.next();
		
		System.out.println("Enter Category (Software / Hardware)");
		String category = sc.next();
		
		EngineerDao dao = new EngineerDaoImpl();
		
		Engineer engineer = new Engineer(name, username, password, category);
		
		String result  = dao.registerEngineer(engineer);
		
		System.out.println(result);
		
	}
	
}
