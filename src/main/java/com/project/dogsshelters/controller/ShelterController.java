package com.project.dogsshelters.controller;

import com.project.dogsshelters.entity.Shelter;
import com.project.dogsshelters.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shelters")
public class ShelterController {

    @Autowired
    private ShelterService shelterService;

    @GetMapping("/find")
    public Optional<Shelter> getShelterById(@RequestParam String id){
        return shelterService.getShelterById(id);
    }

    @GetMapping("/all")
    public List<Shelter> getAllShelters(){
        return shelterService.getAllShelters();
    }

    @PostMapping("/add")
    public Shelter addShelter(@RequestBody Shelter shelter) {
        return shelterService.addShelter(shelter);
    }

    @PutMapping("/edit")
    public Shelter editShelter(@RequestBody Shelter shelter) {
        return shelterService.editShelter(shelter);
    }

    @DeleteMapping("/delete")
    public String deleteShelter(@RequestParam String id) {
        return shelterService.deleteShelter(id);
    }

}
