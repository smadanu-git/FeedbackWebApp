package com.feedback.dto;

import java.util.List;

public class MyReviewsResponse {
	private String taskName;
	private List<MyReviewsDTO> myReviewsList;
	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}
	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * @return the myReviewsList
	 */
	public List<MyReviewsDTO> getMyReviewsList() {
		return myReviewsList;
	}
	/**
	 * @param myReviewsList the myReviewsList to set
	 */
	public void setMyReviewsList(List<MyReviewsDTO> myReviewsList) {
		this.myReviewsList = myReviewsList;
	}
	
	
}
