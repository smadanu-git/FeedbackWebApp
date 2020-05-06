package com.feedback.main.dao;

import java.util.List;

import com.feedback.main.entities.User;

public interface FeedbackDao {
	
	List<User> getAdminDasboard();
	String getEmployeeDashboard();

}
