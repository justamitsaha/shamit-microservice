package com.saha.amit.kafkaApp.repository;

import com.saha.amit.kafkaApp.entity.LibraryEvent;
import org.springframework.data.repository.CrudRepository;

public interface LibraryEventsRepository extends CrudRepository<LibraryEvent,Integer> {
}