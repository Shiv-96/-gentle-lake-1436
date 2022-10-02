package com.shiv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shiv.beans.Complain;
import com.shiv.beans.Employee;
import com.shiv.beans.EmployeeDTO;
import com.shiv.exception.EmployeeException;
import com.shiv.utility.DBUtill;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String registerEmployee(Employee employee) {
		
		String message = "Not registered";
		
		try (Connection conn = DBUtill.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into employee(name, user, password) value(?, ?, ?)");
			
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getUsername());
			ps.setString(3, employee.getPassword());
			
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Employee Registred Sucessfully";
			}
			
		} catch (SQLException e) {
			
			message = e.getMessage();
			
		}
		
		return message;
		
	}

	@Override
	public Employee loginEmployee(String username, String password) throws EmployeeException {
		Employee employee = null;
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where user = ? and password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String n = rs.getString("name");
				String user = rs.getString("user");
				String pass = rs.getString("password");
				
				employee = new Employee(n, user, pass);
			}
			else {
				throw new EmployeeException("Invalid Credential...");
			}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return employee;
	}

	@Override
	public String changePasswordEmployee(String pass, String user) throws EmployeeException {
		
		String message = null;
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update employee set password = ? where user = ?");
			
			ps.setString(1, pass);
			ps.setString(2, user);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Password changed Succesfully";
			}
			else {
				throw new EmployeeException("Password has not changed");
			}
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			
		}
		
		return message;

	}

	@Override
	public String registerComplain(Complain complain) throws EmployeeException {
		
		String message = "Not registered";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into complain (category, assignedEngineer) value(?, ?)");
			
			ps.setString(1, complain.getCategory());
			ps.setString(2, complain.getAssignedEngineer());
			
			int x= ps.executeUpdate();
			
			if(x>0) {
				message = "Complain Registered";
			}
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
		
	}

//	@Override
//	public List<EmployeeDTO> getComplainStatusById(int id) throws EmployeeException {
//		List<EmployeeDTO> dtos = new ArrayList<>();
//		
//		try(Connection conn = DBUtill.provideConnection()) {
//			
//			PreparedStatement ps = conn.prepareStatement("select ")
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return dtos;
//	}

	
}
