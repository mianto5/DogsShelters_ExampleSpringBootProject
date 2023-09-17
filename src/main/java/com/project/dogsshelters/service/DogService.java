package com.project.dogsshelters.service;

import com.project.dogsshelters.entity.Dog;
import com.project.dogsshelters.entity.DogInsert;
import com.project.dogsshelters.repo.DogRepo;
import com.project.dogsshelters.repo.ShelterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    @Autowired
    private DogRepo dogRepo;
    @Autowired
    private ShelterRepo shelterRepo;

    public Dog getDogById(String did) {
        return dogRepo.findById(did).orElse(null);
    }

    public List<Dog> getAllDogs() {
        return (List<Dog>) dogRepo.findAll();
    }

    public List<Dog> getDogsByStatus(String status) {
        return (List<Dog>) dogRepo.findByStatus(status);
    }

    public ResponseEntity addDog(DogInsert dogInsert) {
        Dog dog = new Dog();
        try {
            dog.setShelter(shelterRepo.findById(dogInsert.getShelterid())
                    .orElseThrow(() -> new Exception("Shelter with ID = " + dogInsert.getShelterid()
                            + " does not exist in the database.")));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        dog.setName(dogInsert.getName());
        dog.setBreed(dogInsert.getBreed());
        dog.setSex(dogInsert.getSex());
        dog.setAge(dogInsert.getAge());
        dog.setStatus(dogInsert.getStatus());
        return ResponseEntity.ok(dogRepo.save(dog));
    }

    public ResponseEntity editDog(DogInsert dogInsert) {
        Dog dog = new Dog();
        try {
            if(dogRepo.existsById(String.valueOf(dogInsert.getDogid())))
                dog.setDid(dogInsert.getDogid());
            else
                throw new Exception("Dog with ID = " + dogInsert.getDogid()
                            + " does not exist in the database.");
            dog.setShelter(shelterRepo.findById(dogInsert.getShelterid())
                    .orElseThrow(() -> new Exception("Shelter with ID = " + dogInsert.getShelterid()
                            + " does not exist in the database.")));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        dog.setName(dogInsert.getName());
        dog.setBreed(dogInsert.getBreed());
        dog.setSex(dogInsert.getSex());
        dog.setAge(dogInsert.getAge());
        dog.setStatus(dogInsert.getStatus());
        return ResponseEntity.ok(dogRepo.save(dog));
    }

    public String deleteDog(String did) {
        dogRepo.deleteById(did);
        return "Dog with ID = "+did+" deleted successfully.";
    }

}
