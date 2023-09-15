package com.project.dogsshelters.service;

import com.project.dogsshelters.entity.Dog;
import com.project.dogsshelters.repo.DogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DogService {

    @Autowired
    private DogRepo dogRepo;

    public Optional<Dog> getDogById(String did) {
        return dogRepo.findById(did);
    }

    public Dog addDog(Dog dog) {
        return dogRepo.save(dog);
    }

    public Dog editDog(Dog dog) {
        return dogRepo.save(dog);
    }

    public void deleteDog(String did) {
        dogRepo.deleteById(did);
    }

}
