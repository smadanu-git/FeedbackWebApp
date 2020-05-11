package com.feedback.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.feedback.dao.FeedbackDao;
import com.feedback.entities.Users;

@Repository
public class FeedbackDaoImpl implements FeedbackDao {

	private EntityManager entityManager;

    @Autowired
    public FeedbackDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;

    }
    
	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getAdminDasboard() {
		Query userQuery= (Query) entityManager.createQuery("from Users");
        List<Users> userList = userQuery.getResultList();
        return userList;
	}

	@Override
	public String getEmployeeDashboard() {
		// TODO Auto-generated method stub
		return null;
	}

}
