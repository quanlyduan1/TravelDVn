package com.spring.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.file.exception.UserServiceException;
import com.spring.file.model.User;
import com.spring.file.model.UserRequest;
import com.spring.file.repository.UserRepository;
import com.spring.file.service.UserServiceImpl;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:4200")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private UserRepository userRepository;
	
	private static String upload ="D:\\Project\\Angular\\Travel1_Manage\\src\\assets\\images";
	
	@GetMapping("user")
	public ResponseEntity<?>getAllUser(){
		return new ResponseEntity<>(userServiceImpl.getAllUser(),HttpStatus.ACCEPTED);
	}
	
    @GetMapping( "roles")
    public ResponseEntity<?> getallRoles(){
        return new ResponseEntity<>(userServiceImpl.getallRoles(), HttpStatus.ACCEPTED);
    }
	
	
	@PostMapping("user")
	public ResponseEntity<?>AddUser(@RequestBody UserRequest userRequest)throws Exception{
		String temp_email= userRequest.getEmailId();
		if(temp_email != null &&!"". equals(temp_email)) {
			User userObj = userServiceImpl.fetchUserEntityByEmailId(temp_email);
			if(userObj != null) {
				throw new Exception("user with" + temp_email + "is already exit");
			}
		}
		return new ResponseEntity<>(this.userServiceImpl.AddUser(userRequest),HttpStatus.CREATED);
	}
	
	@PostMapping("user/upload/{id}")
	public ResponseEntity<?>UploadFile(@RequestParam MultipartFile file,@PathVariable Integer id){
		User user = userRepository.findById(id).get();
		String FileName = UserServiceException.UploadOneFile(file, upload);
		user.setAvatar(FileName);
		userRepository.save(user);
		return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("user/{id}")
	public ResponseEntity<?>GetUser(@PathVariable Integer id){
		User user = userRepository.findById(id).orElseThrow();
		return  ResponseEntity.ok(user);
	}
	
    @PutMapping("user/{id}")
    public ResponseEntity<?>UpdateUser(@PathVariable Integer id, @RequestBody UserRequest userRequest){
        return new ResponseEntity<>(this.userServiceImpl.UpdateUser(userRequest,id),HttpStatus.ACCEPTED);
    }
	
//	@PutMapping("user/{id}")
//	public ResponseEntity<?>UpdateUser(@PathVariable Integer id, @RequestBody User user){
//		User users = userRepository.findById(id).orElseThrow();
//		users.setUserName(user.getUserName());
//		users.setEmailId(user.getEmailId());
//		users.setPassword(user.getPassword());
//		users.setAdsress(user.getAdsress());
//		users.setDateOfBirth(user.getDateOfBirth());
//		users.setPhone(user.getPhone());
//		users.setNationality(user.getNationality());
//		users.setAvatar(user.getAvatar());
//		return new ResponseEntity<>(this.userServiceImpl.UpdateUser(users),HttpStatus.ACCEPTED);
//	}
	
	@DeleteMapping("user/{id}")
	public Boolean DaleteUser(@PathVariable Integer id) {
		userServiceImpl.DeleteUser(id);
		return true;
	}

	@PostMapping("login")
	public User LoginUser(@RequestBody User user)throws Exception {
		String temp_email = user.getEmailId();
		String temp_password = user.getPassword();
		User userObj = null;
		if(temp_email!=null&& temp_password != null) {
			userObj = userServiceImpl.fetchUserEntityByEmailIdAndPassword(temp_email, temp_password);
		}
		if(userObj == null) {
			throw new Exception("Bad credentials");
		}
		return userObj;
	}
}







































