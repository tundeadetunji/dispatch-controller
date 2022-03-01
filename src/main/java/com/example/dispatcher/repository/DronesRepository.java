package com.example.dispatcher.repository;

import com.example.dispatcher.models.Drones;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DronesRepository extends CrudRepository<Drones, Integer> {

}
