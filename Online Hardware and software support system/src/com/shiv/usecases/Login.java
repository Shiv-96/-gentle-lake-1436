package com.shiv.usecases;

import java.util.Scanner;

import com.shiv.beans.HOD;
import com.shiv.dao.HODDao;
import com.shiv.dao.HODDaoImpl;
import com.shiv.exception.HODException;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter username");
		String uname = sc.next();
		
		System.out.println("Enter Password");
		String pass = sc.next();
		
		HODDao dao = new HODDaoImpl();
		
		try {
			HOD hod  = dao.loginHOD(uname, pass);
			System.out.println("Welcome "+hod.getName());
		} catch (HODException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

}
