package com.project.dogsshelters.controller;

import com.project.dogsshelters.entity.Dog;
import com.project.dogsshelters.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/dogs")
public class DogController {

    @Autowired
    private DogService dogService;

    @GetMapping("/find")
    public Optional<Dog> getDogById(@RequestParam String id){
        return dogService.getDogById(id);
    }

    @PostMapping("/add")
    public void addDog(@RequestBody Dog dog) {
        dogService.addDog(dog);
    }

}
