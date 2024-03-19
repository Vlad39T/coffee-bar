package com.example.coffeebar.service;

import com.example.coffeebar.repository.GraphikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraphikService {

    private GraphikRepository graphikRepository;

    @Autowired
    public void setGraphikRepository(GraphikRepository graphikRepository) {
        this.graphikRepository = graphikRepository;
    }
}
