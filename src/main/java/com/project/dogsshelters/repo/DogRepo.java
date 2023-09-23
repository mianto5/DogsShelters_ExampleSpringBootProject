package com.project.dogsshelters.repo;

import com.project.dogsshelters.entity.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepo extends CrudRepository<Dog, String> {

    public List<Dog> findBySex(String sex);

    public List<Dog> findByStatus(String status);

}
