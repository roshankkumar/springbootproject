package com.frontend.service.userServiceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.frontend.dao.RoleDao;
import com.frontend.dao.UserDao;
import com.frontend.domain.Users;
//import com.frontend.domain.security.UserRole;
//import com.frontend.service.AccountService;
import com.frontend.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;
	

	
	public void save(Users user) {
        userDao.save(user);
    }

    public Users findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public Users findByEmail(String email) {
        return userDao.findByEmail(email);
    }
    
    
    
    
    public boolean checkUserExists(String username, String email){
        if (checkUsernameExists(username) || checkEmailExists(username)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUsernameExists(String username) {
        if (null != findByUsername(username)) {
            return true;
        }

        return false;
    }
    
    public boolean checkEmailExists(String email) {
        if (null != findByEmail(email)) {
            return true;
        }

        return false;
    }

    public Users saveUser (Users user) {
        return userDao.save(user);
    }
    
    public List<Users> findUserList() {
        return userDao.findAll();
    }

    public void enableUser (String username) {
        Users user = findByUsername(username);
        user.setEnabled(true);
        userDao.save(user);
    }

    public void disableUser (String username) {
        Users user = findByUsername(username);
        user.setEnabled(false);
        System.out.println(user.getEnabled());
        userDao.save(user);
        System.out.println(username + " is disabled.");
    }
}
