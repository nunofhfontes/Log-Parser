package com.ef.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ef.domain.LogEntry;

public interface LogEntryRepository extends JpaRepository<LogEntry, Long>{

	public Optional<LogEntry> findById(Long id);
	
	public List<LogEntry> findAll();
	
	public List<LogEntry> findFirst10ByOrderByInsertionDateDesc();
	
	
}

