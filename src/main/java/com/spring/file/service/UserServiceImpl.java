package com.spring.file.service;

import java.util.List;

import com.spring.file.model.Roles;
import com.spring.file.model.User;
import com.spring.file.model.UserRequest;

public interface UserServiceImpl {
	
    List<User> getAllUser();
    List<Roles> getallRoles();
    User AddUser(UserRequest userRequest);
    User GetUserById(User user);
    User UpdateUser(UserRequest userRequest, Integer id);
    User fetchUserEntityByEmailId(String email_id);
    User fetchUserEntityByEmailIdAndPassword(String email_id ,String password);
    void DeleteUser(Integer id);

}
