package com.project.dogsshelters.controller;

import com.project.dogsshelters.entity.Dog;
import com.project.dogsshelters.entity.DogInsert;
import com.project.dogsshelters.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {

    @Autowired
    private DogService dogService;

    @GetMapping("/find")
    public ResponseEntity getDogById(@RequestParam String id) {
        return dogService.getDogById(id);
    }

    @GetMapping("/all")
    public ResponseEntity getAllDogs(){
        return dogService.getAllDogs();
    }

    @GetMapping("/findBySt")
    public ResponseEntity getDogsByStatus(@RequestParam String status){
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
    public ResponseEntity deleteDog(@RequestParam String id) {
        return dogService.deleteDog(id);
    }

}
