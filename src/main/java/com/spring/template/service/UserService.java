package com.spring.template.service;

import com.spring.template.model.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);
}

//@Service
//public class UserService {
//	@PersistenceContext
//	private EntityManager em;
//	
//	@Transactional
//	public List<User> getAll(){
//		List<User> result = em.createQuery("select u from User u", User.class).getResultList();
//		return result;
//	}
//	
//	@Transactional
//	public void addUser(User u){
//		em.persist(u);
//	}
//}
