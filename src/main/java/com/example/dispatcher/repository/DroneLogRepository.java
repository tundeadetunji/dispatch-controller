package com.example.dispatcher.repository;

import com.example.dispatcher.models.DroneLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneLogRepository extends CrudRepository<DroneLog, Integer> {
}
