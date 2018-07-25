package com.ef.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ef.domain.LogEntry;

public interface LogEntryRepository extends JpaRepository<LogEntry, Long>{

}

