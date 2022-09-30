package com.shiv.usecases;

import java.util.Scanner;

import com.shiv.dao.HODDao;
import com.shiv.dao.HODDaoImpl;

public class GettingDetailsHOD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name");
		String name = sc.next();
		
		System.out.println("Enter username");
		String username = sc.next();
		
		System.out.println("Enter password");
		String password = sc.next();
		
		HODDao dao = new HODDaoImpl();
		
		String result = dao.insertHODDetails(name, username, password);
		
		System.out.println(result);
		
	}

}
