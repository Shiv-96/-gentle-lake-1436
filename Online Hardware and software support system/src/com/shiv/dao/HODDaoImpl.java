package com.shiv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shiv.beans.HOD;
import com.shiv.exception.HODException;
import com.shiv.utility.DBUtill;

public class HODDaoImpl implements HODDao {

	@Override
	public String insertHODDetails(String name, String username, String password) {
		// TODO Auto-generated method stub
		String message = "Not Inserted";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into hodLogin values (?, ?, ?)");
			
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, name);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Now you are ready for login";
			}
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		
		
		return message;
	}

	@Override
	public HOD loginHOD(String username, String password) throws HODException {
		
		HOD hod = null;
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from hodLogin where usename = ? AND password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String na = rs.getString("name");
				String uname = rs.getString("username");
				String pass = rs.getString("password");
				
				hod = new HOD(na, uname, pass);
				
			}
			else {
				throw new HODException("Invalid credential");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new HODException(e.getMessage());
		}
		
		return hod;
		
	}

}
