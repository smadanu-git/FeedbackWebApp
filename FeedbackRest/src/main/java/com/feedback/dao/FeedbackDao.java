package com.feedback.dao;

import java.util.List;

import com.feedback.entities.Users;

public interface FeedbackDao {
	
	List<Users> getAdminDasboard();
	String getEmployeeDashboard();

}
