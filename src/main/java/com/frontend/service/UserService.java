package com.frontend.service;

import java.util.List;
import java.util.Set;

import com.frontend.domain.Users;


public interface UserService {
	Users findByUsername(String username);

    Users findByEmail(String email);

    boolean checkUserExists(String username, String email);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);
    
    void save (Users user);
    
   
    
    Users saveUser (Users user); 
    
    List<Users> findUserList();

    void enableUser (String username);

    void disableUser (String username);
}
