package com.frontend.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.frontend.domain.Users;

public interface UserDao extends CrudRepository<Users, Long> {
	Users findByUsername(String username);
    Users findByEmail(String email);
    List<Users> findAll();
}
