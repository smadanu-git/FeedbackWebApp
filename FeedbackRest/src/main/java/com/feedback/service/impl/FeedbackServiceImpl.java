package com.feedback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.dao.FeedbackDao;
import com.feedback.dto.EmployeeDTO;
import com.feedback.dto.MyReviewsDTO;
import com.feedback.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;

	@Override
	public List<MyReviewsDTO> getMyReviews(String userName) {
		return feedbackDao.getMyReviews(userName);
	}

	@Override
	public List<MyReviewsDTO> saveReviews(MyReviewsDTO myReviews, String userName) {
		feedbackDao.saveReviews(myReviews);
		List<MyReviewsDTO> reviews = feedbackDao.getMyReviews(userName);
		return reviews;
	}

	@Override
	public List<EmployeeDTO> addEmployee(EmployeeDTO employee) {
		feedbackDao.addEmployee(employee);
		return feedbackDao.getAllEmployees();
	}

	@Override
	public List<EmployeeDTO> editEmployee(EmployeeDTO employee) {
		feedbackDao.editEmployee(employee);
		return feedbackDao.getAllEmployees();
	}

	@Override
	public List<EmployeeDTO> deleteEmployee(EmployeeDTO employee) {
		feedbackDao.deleteEmployee(employee);
		return feedbackDao.getAllEmployees();

	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		return feedbackDao.getAllEmployees();
	}
}
