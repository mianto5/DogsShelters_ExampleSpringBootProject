package com.project.dogsshelters.controller;

import com.project.dogsshelters.entity.Dog;
import com.project.dogsshelters.entity.DogInsert;
import com.project.dogsshelters.entity.Shelter;
import com.project.dogsshelters.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dogs")
public class DogController {

    @Autowired
    private DogService dogService;

    @GetMapping("/find")
    public Dog getDogById(@RequestParam String id) {
        return dogService.getDogById(id);
    }

    @GetMapping("/all")
    public List<Dog> getAllDogs(){
        return dogService.getAllDogs();
    }

    @GetMapping("/findBySt")
    public List<Dog> getDogsByStatus(@RequestParam String status){
        return dogService.getDogsByStatus(status);
    }

    @PostMapping("/add")
    public ResponseEntity addDog(@RequestBody DogInsert dogInsert) {
        return dogService.addDog(dogInsert);
    }

    @PutMapping("/edit")
    public ResponseEntity editDog(@RequestBody DogInsert dogInsert) {
        return dogService.editDog(dogInsert);
    }

    @DeleteMapping("/delete")
    public String deleteDog(@RequestParam String id) {
        return dogService.deleteDog(id);
    }

}
