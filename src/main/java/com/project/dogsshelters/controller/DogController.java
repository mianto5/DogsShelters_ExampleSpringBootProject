package com.project.dogsshelters.controller;

import com.project.dogsshelters.entity.DogInsert;
import com.project.dogsshelters.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dogs")
public class DogController {

    @Autowired
    private DogService dogService;

    @GetMapping("/{id}")
    public ResponseEntity getDogById(@PathVariable String id) {
        return dogService.getDogById(id);
    }

    @GetMapping("/all")
    public ResponseEntity getAllDogs(){
        return dogService.getAllDogs();
    }

    @GetMapping("/sex")
    public ResponseEntity getDogsBySex(@RequestParam String sex){
        return dogService.getDogsBySex(sex);
    }

    @GetMapping("/status")
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
