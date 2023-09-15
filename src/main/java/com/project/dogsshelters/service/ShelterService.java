package com.project.dogsshelters.service;

import com.project.dogsshelters.repo.ShelterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShelterService {

    @Autowired
    private ShelterRepo shelterRepo;

}
