package com.andrew.tracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.andrew.tracker.model.Messages;

public interface MessageRepository extends CrudRepository<Messages, Long> {
	
	List<Messages> findAll();
	
}
