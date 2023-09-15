package com.project.dogsshelters.service;

import com.project.dogsshelters.entity.Shelter;
import com.project.dogsshelters.repo.ShelterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShelterService {

    @Autowired
    private ShelterRepo shelterRepo;

    public Optional<Shelter> getShelterById(String sid) {
        return shelterRepo.findById(sid);
    }

    public List<Shelter> getAllShelters() {
        return (List<Shelter>) shelterRepo.findAll();
    }

    public Shelter addShelter(Shelter shelter) {
        return shelterRepo.save(shelter);
    }

    public Shelter editShelter(Shelter shelter) {
        return shelterRepo.save(shelter);
    }

    public String deleteShelter(String sid) {
        shelterRepo.deleteById(sid);
        return "Shelter with id = "+sid+" deleted successfully.";
    }

}
