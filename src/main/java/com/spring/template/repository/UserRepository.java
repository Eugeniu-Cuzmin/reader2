package com.spring.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.template.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}