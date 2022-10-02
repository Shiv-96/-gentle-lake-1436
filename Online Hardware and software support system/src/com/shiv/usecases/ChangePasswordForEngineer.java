package com.shiv.usecases;

import java.util.Scanner;

import com.shiv.dao.EngineerDao;
import com.shiv.dao.EngineerDaoImpl;
import com.shiv.exception.EngineerException;

public class ChangePasswordForEngineer {

	public void changeThePassword() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Username");
		String uname = sc.next();
		
		System.out.println("New Password");
		String pass = sc.next();
		
		EngineerDao dao = new EngineerDaoImpl();
			try {
				String result = dao.changePasswordEngineer(pass, uname);
				
				System.out.println(result);
			} catch (EngineerException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
			
	}
	
}
