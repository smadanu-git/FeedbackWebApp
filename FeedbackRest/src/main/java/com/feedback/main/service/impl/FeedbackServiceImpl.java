package com.feedback.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.dao.FeedbackDao;
import com.feedback.entities.User;
import com.feedback.jpa.repositories.UserRepository;
import com.feedback.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;
	
	@Autowired
    UserRepository userRepository;
	
	@Override
	public List<User> getAdminDasboard() {
		return feedbackDao.getAdminDasboard();
		//return userRepository.findAll();
	}

	@Override
	public String getEmployeeDashboard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifyUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String viewUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
