package com.shiv.usecases;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to the Online hardware and software System");
		System.out.println("==================================================");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Press 1 for login as a HOD");
			System.out.println("Press 2 for login as a Engineer");
			System.out.println("Press 3 for login as a Employee");
			System.out.println("Press 4 for exit the app");
			
			int c = sc.nextInt();
			
			if(c == 1) {
				System.out.println("Do you have an account");
				System.out.println("Press 1 for yes");
				System.out.println("Press 2 for no");
				int x = sc.nextInt();
				if(x == 2) {
					GettingDetailsHOD reg = new GettingDetailsHOD();
					reg.register();
				}
				Login login = new Login();
				login.login();
				while(true) {
					System.out.println("Press 1 for Register a new Engineer");
					System.out.println("Press 2 for see the list of registered Engineer");
					System.out.println("Press 3 for delete any Engineer from the system");
					System.out.println("Press 4 for see the raised problem");
					System.out.println("Press 5 for assign any problem to any Engineer");
					System.out.println("Press 6 for exit the HOD Section");
					
					int y = sc.nextInt();
					
					if(y == 1) {
						RegisterForEngineer register = new RegisterForEngineer();
						register.registerEngineer();
					}
					else if(y == 2) {
						GetAllRegisteredEngineer gare = new GetAllRegisteredEngineer();
						gare.getRegisteredEngineer();
					}
					else if(y == 3) {
						DeleteEngineer de = new DeleteEngineer();
						de.deleteEngineerById();
					}
					else if(y == 4) {
						RaisedProblem rp = new RaisedProblem();
						rp.raisedProblemForEngineer();
					}
					else if(y == 5) {
						
					}
					else if(y == 6) {
						break;
					}
				}
			}
			else if(c == 2) {
				
			}
			else if(c == 3) {
				
			}
			else if(c == 4) {
				break;
			}
			
			
		}
		
		System.out.println("Thank you for using my application");
		
	}

}
