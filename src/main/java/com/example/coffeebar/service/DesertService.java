package com.example.coffeebar.service;

import com.example.coffeebar.repository.DesertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesertService {

    private DesertRepository desertRepository;

    @Autowired
    public void setDesertRepository(DesertRepository desertRepository) {
        this.desertRepository = desertRepository;
    }


}
