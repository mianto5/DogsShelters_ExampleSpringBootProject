package com.project.dogsshelters.repo;

import com.project.dogsshelters.entity.Shelter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShelterRepo extends CrudRepository<Shelter, String> {

    public List<Shelter> findByCity(String city);

}
