package com.shiv.usecases;

import java.util.Scanner;

import com.shiv.beans.Engineer;
import com.shiv.dao.EngineerDao;
import com.shiv.dao.EngineerDaoImpl;
import com.shiv.exception.EngineerException;

public class LogiInForEngineer {

	public boolean loginForEngineer() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Engineer");
		String username = sc.next();
		
		System.out.println("Enter Password");
		String pass = sc.next();

		EngineerDao dao = new EngineerDaoImpl();
		
		try {
			Engineer engineer = dao.loginForEngineer(username, pass);
			
			System.out.println("==============================");
			System.out.println("Welcome "+engineer.getName());
			
			
			System.out.println("===============================");
			return true;
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
		return false;
	}
	
}
