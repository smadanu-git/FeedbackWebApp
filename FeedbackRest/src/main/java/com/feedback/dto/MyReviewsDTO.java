package com.feedback.dto;

import java.util.Date;

public class MyReviewsDTO {

	private long participantId;
	private String feedbackName;
	private String revieweeName;
	private String revieweeEmail;
	private String comments;
	private String rating;
	private String status;
	private Date assignedDate;
	
	
	
	public MyReviewsDTO(long participantId, String feedbackName, String revieweeName, String revieweeEmail,
			String comments, String rating, String status, java.sql.Date assignedDate) {
		super();
		this.participantId = participantId;
		this.feedbackName = feedbackName;
		this.revieweeName = revieweeName;
		this.revieweeEmail = revieweeEmail;
		this.comments = comments;
		this.rating = rating;
		this.status = status;
		this.assignedDate = assignedDate != null ? new Date(assignedDate.getTime()) : null;
	}
	/**
	 * @return the participantId
	 */
	public long getParticipantId() {
		return participantId;
	}
	/**
	 * @param participantId the participantId to set
	 */
	public void setParticipantId(long participantId) {
		this.participantId = participantId;
	}
	/**
	 * @return the feedbackName
	 */
	public String getFeedbackName() {
		return feedbackName;
	}
	/**
	 * @param feedbackName the feedbackName to set
	 */
	public void setFeedbackName(String feedbackName) {
		this.feedbackName = feedbackName;
	}
	
	
	/**
	 * @return the revieweeName
	 */
	public String getRevieweeName() {
		return revieweeName;
	}
	/**
	 * @param revieweeName the revieweeName to set
	 */
	public void setRevieweeName(String revieweeName) {
		this.revieweeName = revieweeName;
	}
	/**
	 * @return the revieweeEmail
	 */
	public String getRevieweeEmail() {
		return revieweeEmail;
	}
	/**
	 * @param revieweeEmail the revieweeEmail to set
	 */
	public void setRevieweeEmail(String revieweeEmail) {
		this.revieweeEmail = revieweeEmail;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the assignedDate
	 */
	public Date getAssignedDate() {
		return assignedDate;
	}
	/**
	 * @param assignedDate the assignedDate to set
	 */
	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	
}