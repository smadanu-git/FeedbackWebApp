package com.feedback.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Reviews implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String comments;
	private String status;
	private String rating;
	private Date submittedDate;

	// bi-directional many-to-one association to Role
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "reviewerId", referencedColumnName = "id", nullable = false)
	private Users reviewers;

	// bi-directional many-to-one association to Role
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "revieweeId", referencedColumnName = "id", nullable = false)
	private Users reviewees;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Users getReviewers() {
		return reviewers;
	}

	public void setReviewers(Users reviewers) {
		this.reviewers = reviewers;
	}

	public Users getReviewees() {
		return reviewees;
	}

	public void setReviewees(Users reviewees) {
		this.reviewees = reviewees;
	}
	
	

}