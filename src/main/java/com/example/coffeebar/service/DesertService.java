package com.example.coffeebar.service;

import com.example.coffeebar.entity.Desert;
import com.example.coffeebar.repository.DesertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesertService {

    private DesertRepository desertRepository;

    @Autowired
    public void setDesertRepository(DesertRepository desertRepository) {
        this.desertRepository = desertRepository;
    }

    public void addDesert(Desert desert) {
        if (desert != null) {
            desertRepository.save(desert);
        }
    }

    public List<Desert> getAllDesert() {
        return desertRepository.findAll();
    }

    public Desert findById(Long desertId){
        return desertRepository.findById(desertId).orElse(new Desert());
    }

    public void deleteDesert(Long idDesert){
        desertRepository.deleteById(idDesert);
    }
}
