package com.example.dispatcher.repository;

import com.example.dispatcher.models.LoadedMedications;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadedMedicationsRepository extends CrudRepository<LoadedMedications, Integer> {
}
