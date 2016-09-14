package com.spring.template.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.template.model.User;

@Service
public class UserService {
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public List<User> getAll(){
		List<User> result = em.createQuery("select u from User u", User.class).getResultList();
		return result;
	}
	
	@Transactional
	public void addUser(User u){
		em.persist(u);
	}
}
