package com.example.coffeebar.service;

import com.example.coffeebar.entity.Desert;
import com.example.coffeebar.entity.Drink;
import com.example.coffeebar.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {

   private DrinkRepository drinkRepository;

    @Autowired
    public void setDrinkRepository(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public void addDrink(Drink drink) {
        if (drink != null) {
            drinkRepository.save(drink);
        }
    }

    public List<Drink> getAllDrink() {
        return drinkRepository.findAll();
    }

    public Drink findById(Long drinkId){
        return drinkRepository.findById(drinkId).orElse(new Drink());
    }

    public void deleteDrink(Long idDrink){
        drinkRepository.deleteById(idDrink);
    }
}
