package com.jpa.SkillsManagement.Bean;

//This is Bean Class for Admin Login API
public class AdminClass {
	private String adminUserName; // User name for Admin which static username="Admin"
	private String adminPassword; // Password for Admin which static password="Admin"

	public AdminClass(String adminUserName, String adminPassword) {
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "AdminClass [adminUserName=" + adminUserName + ", adminPassword=" + adminPassword + "]";
	}

}
