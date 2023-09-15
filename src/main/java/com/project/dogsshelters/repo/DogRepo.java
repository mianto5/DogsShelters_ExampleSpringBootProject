package com.project.dogsshelters.repo;

import com.project.dogsshelters.entity.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepo extends CrudRepository<Dog, String> {

}
