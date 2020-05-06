package com.feedback.main.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.feedback.main.dao.FeedbackDao;
import com.feedback.main.entities.User;

@Repository
public class FeedbackDaoImpl implements FeedbackDao {

	private EntityManager entityManager;

    @Autowired
    public FeedbackDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;

    }
    
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAdminDasboard() {
		Query userQuery= (Query) entityManager.createQuery("from User");
        List<User> userList = userQuery.getResultList();
        return userList;
	}

	@Override
	public String getEmployeeDashboard() {
		// TODO Auto-generated method stub
		return null;
	}

}
