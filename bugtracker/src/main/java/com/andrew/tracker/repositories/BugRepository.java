package com.andrew.tracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andrew.tracker.model.Bug;

@Repository
public interface BugRepository extends CrudRepository<Bug, Long> {
	List<Bug> findAll();
	
	Bug findById(Integer id);
}
