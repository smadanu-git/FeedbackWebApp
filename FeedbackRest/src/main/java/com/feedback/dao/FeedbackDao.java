package com.feedback.dao;

import java.util.List;

import com.feedback.dto.EmployeeDTO;
import com.feedback.dto.MyReviewsDTO;

public interface FeedbackDao {

	List<MyReviewsDTO> getMyReviews(String userName);

	void saveReviews(MyReviewsDTO myReviews);

	List<EmployeeDTO> getAllEmployees();

	String addEmployee(EmployeeDTO employee);

	void editEmployee(EmployeeDTO employee);

	void deleteEmployee(EmployeeDTO employee);

}
