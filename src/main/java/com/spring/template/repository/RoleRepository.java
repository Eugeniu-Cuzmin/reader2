package com.spring.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.template.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
