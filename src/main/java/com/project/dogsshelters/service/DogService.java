package com.project.dogsshelters.service;

import com.project.dogsshelters.repo.DogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogService {

    @Autowired
    private DogRepo dogRepo;

}
