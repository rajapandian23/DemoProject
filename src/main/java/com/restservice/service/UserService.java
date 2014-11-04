package com.restservice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.restservice.beans.User;
import com.restservice.database.DBUtility;

public class UserService {
  private Connection connection;
  
  public UserService() {
    connection = DBUtility.getConnection();
  }
  
  public List<User> getAllUsers() {
    List<User> users = new ArrayList<User>();
    try {
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery("select * from nm_user limit 15");
      while (rs.next()) {
        User user = new User();
        user.setUserid(rs.getString("userid"));
        user.setFirstName(rs.getString("firstname"));
        user.setLastName(rs.getString("lastname"));
        user.setEmail(rs.getString("email"));
        users.add(user);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return users;
  }
  
  public User getUserById(String userId) {
    User user = new User();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement("select * from nm_user where userid=?");
      preparedStatement.setString(1, userId);
      ResultSet rs = preparedStatement.executeQuery();
      
      if (rs.next()) {
        user.setUserid(rs.getString("userid"));
        user.setFirstName(rs.getString("firstname"));
        user.setLastName(rs.getString("lastname"));
        
        user.setEmail(rs.getString("email"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user;
  }
}
