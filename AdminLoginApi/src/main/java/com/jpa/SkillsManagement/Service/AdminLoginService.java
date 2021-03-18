package com.jpa.SkillsManagement.Service;

import org.springframework.stereotype.Service;

import com.jpa.SkillsManagement.Bean.AdminClass;

//This is service Class for Admin Login

@Service
public class AdminLoginService {
	
	// Function to check if username and password entered by user are correct
	// If correct username or password is entered login success will be returned
	// If incorrect username or password is entered login fail will be returned

	public String adminLogin(AdminClass admin) {
		if (admin.getAdminUserName().equals("Admin") && admin.getAdminPassword().equals("Admin"))
			return "Login is Successful";
		else
			return "Login Failed.Username/Password do not match";
	}

}
