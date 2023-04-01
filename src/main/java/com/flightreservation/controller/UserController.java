package com.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.entities.User;
import com.flightreservation.repositories.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/showReg")  // http://localhost:8080/showReg
	public String showReg() {
		return "login/showReg";
	}
	
	@RequestMapping("/saveReg") 	//	http://localhost:8080/saveReg
	public String saveRegistration(@ModelAttribute("User")User user) {
		userRepo.save(user);
		return "login/login";
		}
	
	@RequestMapping("/showLoginPage")  // http://localhost:8080/
	public String showLoginPage() {
		return "login/login";
	}
	
	@RequestMapping("/verifyLogin")  // http://localhost:8080/verifyLogin
	public String verifyLogin(@RequestParam("emailid")String emailid ,@RequestParam("password")String password ,Model model) {
		User user =userRepo.getByEmail(emailid);
		if(user!=null) {
		if(user.getEmail().equals(emailid) && user.getPassword().equals(password)) {
			return "findFlights";
		}else {
		model.addAttribute("error", "Invalid UserName/Password");
		return "login/login";
		}
		//System.out.println(user);	  // Prints user object address
	   // System.out.println(emailid);  // Prints email
		//System.out.println(password);   //  Prints Password
		//return "findFlights";
		
	    }else {
		model.addAttribute("error", "Invalid UserName/Password");
		return "login/login";
	}
		
	}
}
