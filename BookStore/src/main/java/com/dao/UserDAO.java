package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.Users;

public class UserDAO {

	private Connection con;

	public UserDAO(Connection con) {
		this.con = con;
	}
	
	public boolean getRegister(Users user)
	{
		boolean status=false;
		
		String query="insert into user_info (username,contact,address,email,gender,password) values (?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getContact());
			pstmt.setString(3, user.getAddress());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getGender());
			pstmt.setString(6, user.getPassword());
			
			int count=pstmt.executeUpdate();
			
			if(count==1)
			{
				status=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public Users getLogin(String userName,String pass)
	{
		Users user=null;
		
		String query="select * from user_info where username=? and password=?";
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, userName);
			pstmt.setString(2, pass);
			
			ResultSet res=pstmt.executeQuery();
			
			while(res.next())
			{
				user=new Users();
				user.setuId(res.getInt(1));
				user.setUserName(res.getString(2));
				user.setContact(res.getString(3));
				user.setAddress(res.getString(4));
				user.setEmail(res.getString(5));
				user.setGender(res.getString(6));
				user.setPassword(res.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
