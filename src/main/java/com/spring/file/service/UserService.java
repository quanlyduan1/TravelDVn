package com.spring.file.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.file.model.Roles;
import com.spring.file.model.User;
import com.spring.file.model.UserRequest;
import com.spring.file.repository.RoleRepository;
import com.spring.file.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceImpl {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User GetUserById(User user) {
        return userRepository.save(user);
    }

    @Override
    public void DeleteUser(Integer id) {
    	userRepository.deleteById(id);
    }

    @Override
    public User fetchUserEntityByEmailId(String email_id) {
        return userRepository.findByEmailId(email_id);
    }

    @Override
    public User fetchUserEntityByEmailIdAndPassword(String email_id, String password) {
        return userRepository.findByEmailIdAndPassword(email_id,password);
    }

	@Override
	public List<Roles> getallRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public User AddUser(UserRequest userRequest) {
    	User user = new User();
    	Roles role = new Roles();      	
    	user.setPassword(userRequest.getPassword());
    	user.setEmailId(userRequest.getEmailId());
    	user.setUserName(userRequest.getUserName());
    	user.setAdsress(userRequest.getAdsress());
    	user.setDateOfBirth(userRequest.getDateOfBirth());
    	user.setPhone(userRequest.getPhone());
    	user.setNationality(userRequest.getNationality());
//    	Optional<Roles> optionalRole = roleRepository.findById(userRequest.getRole_id());
//    	role = optionalRole.get();
//    	user.setRole_id(role);
    	user.setRole_id(roleRepository.findById(userRequest.getRole_id()).orElseThrow());
    	return userRepository.save(user);
	}

	@Override
	public User UpdateUser(UserRequest userRequest, Integer id) {
		User  user= userRepository.findById(id).orElseThrow();
		user.setEmailId(userRequest.getEmailId());
		user.setUserName(userRequest.getUserName());
		user.setPassword(userRequest.getPassword());
		user.setRole_id(roleRepository.findById(userRequest.getRole_id()).orElseThrow());
		return userRepository.save(user);
		
	}
}


























