package com.andrew.tracker.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.andrew.tracker.model.LoginUser;
import com.andrew.tracker.model.User;
import com.andrew.tracker.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	//Validation
	public boolean validation(User newUser, Errors errors) {
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			errors.rejectValue("password", "mismatch", "Passwords do not match");
			return false;
		}
		if(userRepository.findByEmail(newUser.getEmail())!=null) {
			errors.rejectValue("email", "unique", "email is already attached to an account");
			return false;
		}
		return true;
	}
	
	//Registration
	public User register(User newUser) {
		String hashedPass=BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashedPass);
		userRepository.save(newUser);
		return null;
	}
	
	//Finding Users
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	//Authentication
	public User authenticate(LoginUser newLogin, Errors errors) {
		
		User user = userRepository.findByEmail(newLogin.getEmail());
		
		if(user==null) {
			errors.rejectValue("email", "missing", "Email not Found");
			return null;
		} 
		else {
			if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
				errors.rejectValue("password", "False", "Invalid Password");
				return null;
		}
			
		return user;
		
		}
	}
}
