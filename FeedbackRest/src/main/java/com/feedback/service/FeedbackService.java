package com.feedback.service;

import java.util.List;

import com.feedback.entities.User;

public interface FeedbackService {
	List<User> getAdminDasboard();
	String getEmployeeDashboard();
	String addUser();
	String modifyUser();
	String deleteUser();
	String viewUsers();
	
}
