package com.example.coffeebar.service;

import com.example.coffeebar.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkService {

   private DrinkRepository drinkRepository;

    @Autowired
    public void setDrinkRepository(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }
}
