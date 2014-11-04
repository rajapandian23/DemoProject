package com.restservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restservice.beans.User;
import com.restservice.service.UserService;

@RestController
@RequestMapping("/service/user/")
public class ServiceController {
  
  @Autowired
  UserService userService;
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
  public User getUser(@PathVariable String id) {
    User user = userService.getUserById(id);
    return user;
  }
  
  @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
  public List<User> getAllUsers() {
    List<User> users = userService.getAllUsers();
    return users;
  }
  
}
