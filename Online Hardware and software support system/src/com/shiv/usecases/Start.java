package com.shiv.usecases;

import java.util.Scanner;

import com.shiv.dao.EngineerDao;
import com.shiv.dao.EngineerDaoImpl;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to the Online hardware and software System");
		System.out.println("==================================================");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("=============================================");
			System.out.println("Press 1 for login as a HOD");
			System.out.println("Press 2 for login as a Engineer");
			System.out.println("Press 3 for login as a Employee");
			System.out.println("Press 4 for exit the app");
			System.out.println("=============================================");
			
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
				boolean p = login.login();
				while(p) {
					System.out.println("=============================================");
					System.out.println("Press 1 for Register a new Engineer");
					System.out.println("Press 2 for see the list of registered Engineer");
					System.out.println("Press 3 for delete any Engineer from the system");
					System.out.println("Press 4 for see the raised problem");
					System.out.println("Press 5 for assign any problem to any Engineer");
					System.out.println("Press 6 for exit the HOD Section");
					System.out.println("=============================================");
					
					int y = sc.nextInt();
					
					if(y == 1) {
						System.out.println("=============================================");
						RegisterForEngineer register = new RegisterForEngineer();
						register.registerEngineer();
						System.out.println("=============================================");
					}
					else if(y == 2) {
						System.out.println("=============================================");
						GetAllRegisteredEngineer gare = new GetAllRegisteredEngineer();
						
						gare.getRegisteredEngineer();
						System.out.println("=============================================");
					}
					else if(y == 3) {
						System.out.println("=============================================");
						DeleteEngineer de = new DeleteEngineer();
						de.deleteEngineerById();
						System.out.println("=============================================");
					}
					else if(y == 4) {
						System.out.println("=============================================");
						RaisedProblem rp = new RaisedProblem();
						rp.raisedProblemForEngineer();
						System.out.println("=============================================");
					}
					else if(y == 5) {
						System.out.println("==============================================");
						
						System.out.println("Enter Engineer Id");
						int engId = sc.nextInt();
						
						System.out.println("Enter Complain Id");
						int comId = sc.nextInt();
						
						EngineerDao dao = new EngineerDaoImpl();
						
						
						
						try {
							
							String result = dao.allocateProblemToEngineer(engId, comId);
							
							System.out.println(result);
							
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						
						System.out.println("================================================");
					}
					else if(y == 6) {
						break;
					}
				}
			}
			else if(c == 2) {
				LogiInForEngineer login = new LogiInForEngineer();
				boolean q = login.loginForEngineer();
				
				while(q) {
					System.out.println("=============================================================");
					System.out.println("Press 1 for view the problem assigned to you");
					System.out.println("Press 2 for update status of the problem addressed by you");
					System.out.println("Press 3 for see the list of the problem you are attending");
					System.out.println("Press 4 for change the password");
					System.out.println("Press 5 for exit the Engineer section");
					
					System.out.println("=============================================================");
					
					int z = sc.nextInt();
					
					if(z == 1) {
						System.out.println("=============================================");
						System.out.println("You can see the list of the assigned tyo you");
						System.out.println("=============================================");
					}
					else if(z == 2) {
						System.out.println("=============================================");
						System.out.println("You can update the status of the problem addressed by you");
						System.out.println("=============================================");
					}
					else if(z == 3) {
						System.out.println("=============================================");
						System.out.println("You can see the list of the problem you are attending");
						System.out.println("=============================================");
					}
					else if(z == 4) {
						System.out.println("=============================================");
						
						ChangePasswordForEngineer change = new ChangePasswordForEngineer();
						
						change.changeThePassword();
						
						System.out.println("=============================================");
					}
					else if(z == 5) {
						break;
					}
					
				}
			}
			else if(c == 3) {
				System.out.println("===============================================");
				System.out.println("Do you have an account");
				System.out.println("Press 1 for yes");
				System.out.println("Press 2 for no");
				System.out.println("===============================================");
				
				int choice = sc.nextInt();
				
				if(choice == 2) {
					RegisterEmployee register = new RegisterEmployee();
					register.eegisterEmployee();
				}
				LoginForEmployee login = new LoginForEmployee();
				boolean x =login.loginForEmployee();
				
				
				while(x) {
					System.out.println("=========================================================================");
					System.out.println("Press 1 for register a complain(Hardware / Software) Through the system");
					System.out.println("Press 2 for seeing the status of your problem by using complain id");
					System.out.println("Press 3 for seeing all the complain raised by you");
					System.out.println("Press 4 for changing the password");
					
					System.out.println("Press 5 for exit the Employee Section");
					System.out.println("=========================================================================");
					
					int choice1 = sc.nextInt();
					
					if(choice1 == 1) {
						System.out.println("===============================================");
						
						RegisterComplain complain = new RegisterComplain();
						complain.registerCommplain();
						
						System.out.println("==================================================");
					}
					else if(choice1 == 2) {
						System.out.println("=================================================");
						
						
						
						System.out.println("=================================================");
					}
					else if(choice1 == 3) {
						System.out.println("==================================================");
						System.out.println("You can see all the complain you have raised");
						System.out.println("==================================================");
					}
					else if(choice1 == 4) {
						System.out.println("==================================================");
						
						ChangeThePasswordForEmployee change = new ChangeThePasswordForEmployee();
						
						change.changeThePassword();
						
						System.out.println("==================================================");
					}
					else if(choice1 == 5) {
						break;
					}
				}
			}
			else if(c == 4) {
				break;
			}
			
			
		}
		
		System.out.println("Thank you for using my application");
		
	}

}
