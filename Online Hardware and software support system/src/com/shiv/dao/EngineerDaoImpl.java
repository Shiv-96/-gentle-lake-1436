package com.shiv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shiv.beans.Engineer;
import com.shiv.exception.ComplainException;
import com.shiv.exception.EmployeeException;
import com.shiv.exception.EngineerException;
import com.shiv.utility.DBUtill;

public class EngineerDaoImpl implements EngineerDao {

	@Override
	public String registerEngineer(Engineer engineer) {
		
		String message = "Not Registered";
		
		try (Connection conn = DBUtill.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into engineerlogin (name, username, password, category) values(?, ?, ?, ?)");
			
			ps.setString(1, engineer.getName());
			ps.setString(2, engineer.getUsername());
			ps.setString(3, engineer.getPassword());
			ps.setString(4, engineer.getCategory());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Engineer Added in the System";
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
		
		
		
		return message;
		
		
	}

	@Override
	public List<Engineer> getAllEngineer() throws EngineerException {
		
		List<Engineer> engineers = new ArrayList<>();
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from engineerLogin");
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String n = rs.getString("name");
				String un = rs.getString("username");
				String pa = rs.getString("password");
				String ca = rs.getString("category");
				String iassigned = rs.getString("raisedProblem");
				
				Engineer engineer = new Engineer(id, n, un, pa, ca, iassigned);
				engineers.add(engineer);
			}
			
			
		} catch (SQLException e) {
			throw new EngineerException(e.getMessage());
		}
		
		if(engineers.size() == 0) {
			throw new EngineerException("No Engineer found.....");
		}
		
		
		return engineers;
		
	}

	@Override
	public boolean deleteEngineer(int id) throws EngineerException {
		boolean status = false;
		
		
		
		try (Connection conn = DBUtill.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("delete from engineerLogin where id = ?");
			ps.setInt(1, id);
			
			int rs = ps.executeUpdate();
			
			if(rs > 0) {
				status = true;
			}
			else {
				status = false;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EngineerException(e.getMessage());
		}
		
		
		
		return status;
	}

	@Override
	public List<Engineer> getAssignedProblem() throws EngineerException {
		
		List<Engineer> engineers = new ArrayList<>();
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from engineerLogin where raisedProblem != 'Not Assign'");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String n = rs.getString("name");
				String uname = rs.getString("username");
				String pass = rs.getString("password");
				String ca = rs.getString("category");
				String isAssigned = rs.getString("raisedProblem");
				
				Engineer engineer = new Engineer(n, uname, pass, ca, isAssigned);
				
				engineers.add(engineer);
				
			}
			
			
		} catch (SQLException e) {
			throw new EngineerException(e.getMessage());
		}
		
		if(engineers.size() == 0) {
			
			throw new EngineerException("Not any Engineer is assigned to any problem");
			
		}
		
		
		return engineers;
	}

	@Override
	public Engineer loginForEngineer(String username, String password) throws EngineerException {
		
		Engineer engineer = null;
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from engineerLogin where username  = ? and password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String na = rs.getString("name");
				String uname = rs.getString("username");
				String pass = rs.getString("password");
				String ca = rs.getString("category");
				String iassign = rs.getString("raisedProblem");
				
				engineer = new Engineer(na, uname, pass, ca, iassign);
			}
			else {
				throw new EngineerException("Invalid Credential");
			}
			
		} catch (SQLException e) {

			throw new EngineerException(e.getMessage());
			
		}
		
		return engineer;
		
	}

	
	
	@Override
	public String allocateProblemToEngineer(int engid, int cid) throws EngineerException, ComplainException {
		String message = "Not allocated";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from engineerLogin where id = ?");
			
			ps.setInt(1, engid);
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement("select * from complain where id = ?");
				
				ps2.setInt(1, cid);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					PreparedStatement ps3 = conn.prepareStatement("insert into complain_engineer values(?, ?)");
					
					ps3.setInt(1, engid);
					
					ps3.setInt(2, cid);
					
					int x = ps3.executeUpdate();
					
					if(x > 0) 
						message = "Engineer Allted to the problem";
					else
						throw new EngineerException("Engineer not Avalable");
				}
				else 
					throw new ComplainException("Invalid Complain");
			}
			else
				throw new EngineerException("Invalid Engineer Allocated to problem");
			
		} catch (SQLException e) {
			throw new EngineerException(e.getMessage());
		}
		
		
		
		return message;
	}

	@Override
	public String changePasswordEngineer(String pass, String user) throws EngineerException {
		String message = null;
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update engineerLogin set password = ? where username = ?");
			
			ps.setString(1, pass);
			ps.setString(2, user);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Password changed Succesfully";
			}
			else {
				throw new EngineerException("Password has not changed");
			}
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			
		}
		
		return message;
	}

	

	

	
}
