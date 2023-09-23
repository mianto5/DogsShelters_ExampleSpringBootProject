package com.project.dogsshelters.service;

import com.project.dogsshelters.entity.Shelter;
import com.project.dogsshelters.repo.ShelterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ShelterService {

    @Autowired
    private ShelterRepo shelterRepo;

    public ResponseEntity getShelterById(String sid) {
        try {
            if(!shelterRepo.existsById(sid))
                throw new Exception("Shelter with ID = " + sid
                        + " does not exist in the database.");
            return ResponseEntity.ok(shelterRepo.findById(sid));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity getAllShelters() {
        try{
            return ResponseEntity.ok(shelterRepo.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity getSheltersByCity(String city) {
        try{
            return ResponseEntity.ok(shelterRepo.findByCity(city));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity addShelter(Shelter shelter) {
        try{
            return ResponseEntity.ok(shelterRepo.save(shelter));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity editShelter(Shelter shelter) {
        try {
            if(!shelterRepo.existsById(String.valueOf(shelter.getSid())))
                throw new Exception("Shelter with ID = " + shelter.getSid()
                        + " does not exist in the database.");
            shelter.setDogs(shelterRepo.findById(String.valueOf(shelter.getSid())).get().getDogs());
            return ResponseEntity.ok(shelterRepo.save(shelter));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity deleteShelter(String sid) {
        try {
            if(shelterRepo.existsById(sid)) {
                Shelter shelter = shelterRepo.findById(sid).orElse(new Shelter());
                if(!shelter.getDogs().isEmpty() && (shelter.getDogs() != null)){
                    throw new Exception("There are dogs in the shelter, move them first.");
                }
                else
                    shelterRepo.deleteById(sid);
            }
            else
                throw new Exception("Shelter with ID = " + sid
                        + " does not exist in the database.");
            return ResponseEntity.ok("Shelter with ID = " + sid
                    + " deleted successfully.");
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
