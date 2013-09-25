package com.meteor.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.meteor.dao.UserDAO;
import com.meteor.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	 @Autowired private UserDAO userDAO;
	 
	 @RequestMapping(value="/")
	 public String index(Model model){
	  List<User> users = userDAO.SelectAllUser();
	  
	  
	  for(int f1=0;f1<users.size();f1++){
		  logger.info(users.get(f1).getName());
	  }
	  //users.size()
	  //logger.info(users.get(0).getName());
	  
	  model.addAttribute("users", users);   
	  return "home";
	 }

	 @RequestMapping(value="/{num}")
	 public String one(Model model,@PathVariable("num") int num){
		 /*
		 
		 User user = userDAO.SelectUser(1);
		 */
		 User user = userDAO.SelectUser(num);
		 
		 logger.info(user.getName());
	  
	  /*
	  for(int f1=0;f1<users.size();f1++){
		  logger.info(users.get(f1).getName());
	  }
	  */
	  //users.size()
	  //logger.info(users.get(0).getName());
	  
	  //model.addAttribute("users", users);   
	  return "home";
	 }
	 
	 @RequestMapping(value="/up{num}")
	 public String update(Model model,@PathVariable("num") int num){
		 /*
		 
		 User user = userDAO.SelectUser(1);
		 */
		 User user = new User("kim",123);
		 user.setId(num);
		 
		 userDAO.UpdateUser(user);
		 
		 
		 //logger.info(user.getName());
	  
	  /*
	  for(int f1=0;f1<users.size();f1++){
		  logger.info(users.get(f1).getName());
	  }
	  */
	  //users.size()
	  //logger.info(users.get(0).getName());
	  
	  //model.addAttribute("users", users);   
	  return "home";
	 }
	 
	 //UpdateUser
	 @RequestMapping(value="/insert")
	 public String insert(Model model){
		 
		 /**/
		 User user = new User("bb",200);
		 
		 userDAO.InsertUser(user);
		 
		 //logger.info(user.getName());
	  
	  /*
	  for(int f1=0;f1<users.size();f1++){
		  logger.info(users.get(f1).getName());
	  }
	  */
	  //users.size()
	  //logger.info(users.get(0).getName());
	  
	  //model.addAttribute("users", users);   
	  return "home";
	 }
	 	 
	 
}
