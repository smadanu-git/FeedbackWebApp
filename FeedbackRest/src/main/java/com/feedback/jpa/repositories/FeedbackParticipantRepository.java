package com.feedback.jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.feedback.entities.FeedbackParticipant;

public interface FeedbackParticipantRepository extends CrudRepository<FeedbackParticipant, Long> {

}
