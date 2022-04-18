package com.andrew.tracker.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
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
	public boolean authenticate(LoginUser newLogin, BindingResult result) {
		
		User user = userRepository.findByEmail(newLogin.getUserEmail());
		
		if(user == null) {
			result.rejectValue("userEmail", "missing", "Email or Password is invalid");
			return false;
		} 
		
		
		else {
			if(!BCrypt.checkpw(newLogin.getUserPassword(), user.getPassword())) {
				result.rejectValue("userPassword", "False", "Email or Password is invalid");
				return false;
			}
		}
		return true;
		
	}
}
