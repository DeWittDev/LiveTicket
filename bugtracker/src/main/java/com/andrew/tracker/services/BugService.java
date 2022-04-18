package com.andrew.tracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrew.tracker.model.Bug;
import com.andrew.tracker.repositories.BugRepository;

@Service
public class BugService {
	@Autowired
	private BugRepository bugRepository;
	
	//Find
	public List<Bug> findAll() {
		return bugRepository.findAll();
	}
	
	public Bug findById(Long id) {
		Optional<Bug> result = bugRepository.findById(id);
			if(result.isPresent()) {
				return result.get();
			}
			return null;
	}
	
	//Create
	public Bug addBug(Bug newBug) {
		bugRepository.save(newBug);
		return null;
	}
	
	//Edit
	public Bug editBug(Bug edit) {
		bugRepository.save(edit);
		return null;
	}
	
	//Delete
	public Bug delete(Long id) {
		bugRepository.deleteById(id);
		return null;
	}
}
