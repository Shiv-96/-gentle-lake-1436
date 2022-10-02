package com.shiv.dao;

import java.util.List;

import com.shiv.beans.Complain;
import com.shiv.beans.Employee;
import com.shiv.beans.EmployeeDTO;
import com.shiv.exception.EmployeeException;

public interface EmployeeDao {

	public String registerEmployee(Employee employee);
	
	public Employee loginEmployee(String username, String password) throws EmployeeException;
	
	public String changePasswordEmployee(String pass, String user) throws EmployeeException;
	
	public String registerComplain(Complain complain) throws EmployeeException;
	
//	public List<EmployeeDTO> getComplainStatusById(int id) throws EmployeeException;
	
}
