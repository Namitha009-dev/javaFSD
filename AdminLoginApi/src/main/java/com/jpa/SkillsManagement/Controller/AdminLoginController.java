package com.jpa.SkillsManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.SkillsManagement.Bean.AdminClass;
import com.jpa.SkillsManagement.Service.AdminLoginService;

//This is controller for Admin Login API
//URL to login for Admin: http://localhost:9091/Admin/login
//JSON Body to provide for Admin Login:
/*{
	"adminUserName":"Admin",
	"adminPassword":"Admin"
}*/

@RestController
@RequestMapping("/Admin")
public class AdminLoginController {
	@Autowired
	AdminLoginService service;
	 
	//Method for Admin Login which calling function from Service class
	
	@PostMapping("/login")
	public String adminLogin(@RequestBody AdminClass admin) {
		return service.adminLogin(admin);
	}
}
