package com.feedback.dao;

import java.util.List;

import com.feedback.entities.User;

public interface FeedbackDao {
	
	List<User> getAdminDasboard();
	String getEmployeeDashboard();

}
