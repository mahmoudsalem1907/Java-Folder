package com.servlet.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

import javax.sql.DataSource;

import com.servlet.model.Account;

public class AccountServiceImpl implements AccountService{

private DataSource dataSource;
	
	public AccountServiceImpl(DataSource dataSource) {
		if (Objects.isNull(dataSource)) {
			throw new IllegalArgumentException("DataSource must not be null");
		}
		this.dataSource = dataSource;
	}
	
	@Override
	public Account login(String userName, String passWord) {

	    return getAccountByUsername(userName,passWord);
	}

	@Override
	public boolean register(Account account) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO ACCOUNT (USERNAME,EMAIL,PASSWORD) VALUES (?,?,?)";
		try (Connection connection = dataSource.getConnection();
	             PreparedStatement ps = connection.prepareStatement(query)) {

	            ps.setString(1, account.getUsername());
	            ps.setString(2, account.getEmail());
	            ps.setString(3, account.getPassword());

	            int rowsAffected = ps.executeUpdate();
	
	            return rowsAffected > 0;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return false;
	}

	@Override
	public Account getAccountByUsername(String username, String passWord) {
		String query =
		        "SELECT * FROM ACCOUNT " +
		        "WHERE USERNAME = ? AND PASSWORD = ?";

		    try (Connection connection = dataSource.getConnection();
		         PreparedStatement ps =
		             connection.prepareStatement(query)) {

		        ps.setString(1, username);
		        ps.setString(2, passWord);

		        ResultSet resultSet = ps.executeQuery();

		        if(resultSet.next()){

		            Account account = new Account();

		            account.setId(
		                resultSet.getInt("ACCOUNT_ID")
		            );

		            account.setUsername(
		                resultSet.getString("USERNAME")
		            );

		            account.setEmail(
		                resultSet.getString("EMAIL")
		            );

		            account.setRole(
		                resultSet.getString("ROLE")
		            );

		            account.setStatus(
		                resultSet.getString("STATUS")
		            );

		            return account;
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return null;
	}
	

}
