package com.feedback.entities;

import java.io.Serializable;
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

/**
 * The persistent class for the feedback database table.
 * 
 */
@Entity
@Table(name="feedback")
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(name="feedback_name", length=45)
	private String feedbackName;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="reviewee_id")
	private Users users;

	//bi-directional many-to-one association to FeedbackParticipant
	@OneToMany(mappedBy="feedback", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<FeedbackParticipant> feedbackParticipants;

	public Feedback() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFeedbackName() {
		return this.feedbackName;
	}

	public void setFeedbackName(String feedbackName) {
		this.feedbackName = feedbackName;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Set<FeedbackParticipant> getFeedbackParticipants() {
		return this.feedbackParticipants;
	}

	public void setFeedbackParticipants(Set<FeedbackParticipant> feedbackParticipants) {
		this.feedbackParticipants = feedbackParticipants;
	}

	public FeedbackParticipant addFeedbackParticipant(FeedbackParticipant feedbackParticipant) {
		getFeedbackParticipants().add(feedbackParticipant);
		feedbackParticipant.setFeedback(this);

		return feedbackParticipant;
	}

	public FeedbackParticipant removeFeedbackParticipant(FeedbackParticipant feedbackParticipant) {
		getFeedbackParticipants().remove(feedbackParticipant);
		feedbackParticipant.setFeedback(null);

		return feedbackParticipant;
	}

}