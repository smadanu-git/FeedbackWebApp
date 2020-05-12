package com.feedback.service;

import java.util.List;

import com.feedback.entities.Users;

public interface FeedbackService {
	List<Users> getAdminDasboard();
	
	
	String getEmployeeDashboard();
	String addUser();
	String modifyUser();
	String deleteUser();
	String viewUsers();
	
}
