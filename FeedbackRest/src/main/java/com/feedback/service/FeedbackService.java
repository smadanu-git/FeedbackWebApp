package com.feedback.service;

import java.util.List;

import com.feedback.dto.EmployeeDTO;
import com.feedback.dto.MyReviewsDTO;

public interface FeedbackService {

	List<MyReviewsDTO> getMyReviews(String userName);

	List<MyReviewsDTO> saveReviews(MyReviewsDTO myReviews, String userName);

	List<EmployeeDTO> getAllEmployees();

	List<EmployeeDTO> addEmployee(EmployeeDTO employee);

	List<EmployeeDTO> editEmployee(EmployeeDTO employee);

	List<EmployeeDTO> deleteEmployee(EmployeeDTO employee);

}
