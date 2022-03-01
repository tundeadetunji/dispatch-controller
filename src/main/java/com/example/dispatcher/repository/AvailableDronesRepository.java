package com.example.dispatcher.repository;

import com.example.dispatcher.models.AvailableDrones;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableDronesRepository extends CrudRepository<AvailableDrones, Integer> {
}
