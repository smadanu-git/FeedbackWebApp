package com.feedback.jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.feedback.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String username);
}

