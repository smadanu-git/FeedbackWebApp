package com.feedback.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the participants database table.
 * 
 */
@Entity
@Table(name="participants")
public class Participant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="assign_date")
	private Date assignDate;

	@Column(length=300)
	private String comments;

	@Temporal(TemporalType.DATE)
	@Column(name="complete_date")
	private Date completeDate;

	@Column(length=45)
	private String rating;

	@Column(length=45)
	private String status;

	//bi-directional many-to-one association to FeedbackParticipant
	@OneToMany(mappedBy="participant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<FeedbackParticipant> feedbackParticipants;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="participant_id")
	private Users users;

	public Participant() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAssignDate() {
		return this.assignDate;
	}

	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getCompleteDate() {
		return this.completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<FeedbackParticipant> getFeedbackParticipants() {
		return this.feedbackParticipants;
	}

	public void setFeedbackParticipants(Set<FeedbackParticipant> feedbackParticipants) {
		this.feedbackParticipants = feedbackParticipants;
	}

	public FeedbackParticipant addFeedbackParticipant(FeedbackParticipant feedbackParticipant) {
		getFeedbackParticipants().add(feedbackParticipant);
		feedbackParticipant.setParticipant(this);

		return feedbackParticipant;
	}

	public FeedbackParticipant removeFeedbackParticipant(FeedbackParticipant feedbackParticipant) {
		getFeedbackParticipants().remove(feedbackParticipant);
		feedbackParticipant.setParticipant(null);

		return feedbackParticipant;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}