package com.game.dao;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BaseDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		try {
		    return sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    return  sessionFactory.openSession();
		} 
	}
}
