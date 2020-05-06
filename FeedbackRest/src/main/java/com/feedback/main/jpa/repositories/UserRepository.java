package com.feedback.main.jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.feedback.main.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String username);
}

