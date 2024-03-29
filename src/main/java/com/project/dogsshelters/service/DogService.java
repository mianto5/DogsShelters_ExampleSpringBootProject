package com.project.dogsshelters.service;

import com.project.dogsshelters.entity.Dog;
import com.project.dogsshelters.entity.DogInsert;
import com.project.dogsshelters.repo.DogRepo;
import com.project.dogsshelters.repo.ShelterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DogService {

    @Autowired
    private DogRepo dogRepo;
    @Autowired
    private ShelterRepo shelterRepo;

    public ResponseEntity getDogById(String did) {
        try {
            if(!dogRepo.existsById(did))
                throw new Exception("Dog with ID = " + did
                        + " does not exist in the database.");
            return ResponseEntity.ok(dogRepo.findById(did));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity getAllDogs() {
        try{
            return ResponseEntity.ok(dogRepo.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity getDogsBySex(String sex) {
        try{
            if(!sex.toLowerCase().equals("pes") && !sex.toLowerCase().equals("fena"))
                throw new Exception("Invalid sex, choose either 'pes' or 'fena'.");
            return ResponseEntity.ok(dogRepo.findBySex(sex));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity getDogsByStatus(String status) {
        try{
            return ResponseEntity.ok(dogRepo.findByStatus(status));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity addDog(DogInsert dogInsert) {
        Dog dog = new Dog();
        try {
            dog.setShelter(shelterRepo.findById(dogInsert.getShelterid())
                    .orElseThrow(() -> new Exception("Shelter with ID = " + dogInsert.getShelterid()
                            + " does not exist in the database.")));
            dog.setName(dogInsert.getName());
            dog.setBreed(dogInsert.getBreed());
            dog.setSex(dogInsert.getSex().toLowerCase());
            dog.setAge(dogInsert.getAge());
            dog.setStatus(dogInsert.getStatus().toLowerCase());
            return ResponseEntity.ok(dogRepo.save(dog));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity editDog(DogInsert dogInsert) {
        Dog dog = new Dog();
        try {
            if(dogRepo.existsById(String.valueOf(dogInsert.getDid())))
                dog.setDid(dogInsert.getDid());
            else
                throw new Exception("Dog with ID = " + dogInsert.getDid()
                            + " does not exist in the database.");
            dog.setShelter(shelterRepo.findById(dogInsert.getShelterid())
                    .orElseThrow(() -> new Exception("Shelter with ID = " + dogInsert.getShelterid()
                            + " does not exist in the database.")));
            dog.setName(dogInsert.getName());
            dog.setBreed(dogInsert.getBreed());
            dog.setSex(dogInsert.getSex().toLowerCase());
            dog.setAge(dogInsert.getAge());
            dog.setStatus(dogInsert.getStatus().toLowerCase());
            return ResponseEntity.ok(dogRepo.save(dog));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity deleteDog(String did) {
        try {
            if(dogRepo.existsById(did))
                dogRepo.deleteById(did);
            else
                throw new Exception("Dog with ID = " + did
                        + " does not exist in the database.");
            return ResponseEntity.ok("Dog with ID = " + did
                    + " deleted successfully.");
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
