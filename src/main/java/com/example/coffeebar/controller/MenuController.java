package com.example.coffeebar.controller;

import com.example.coffeebar.entity.Desert;
import com.example.coffeebar.entity.Drink;
import com.example.coffeebar.service.DesertService;
import com.example.coffeebar.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
public class MenuController {
    private DrinkService drinkService;
    private DesertService desertService;

    @Autowired
    public void setDrinkService(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @Autowired
    public void setDesertService(DesertService desertService) {
        this.desertService = desertService;
    }


    @GetMapping("/menu")
    public String getAllAssortment(Model model){
        model.addAttribute("drinks",drinkService.getAllDrink());
        model.addAttribute("deserts",desertService.getAllDesert());
        return "menu";
    }

    @GetMapping("/desert/add")
    public String addDesert(Model model){
        model.addAttribute("desert",new Desert());
        return "add-desert";
    }

    @GetMapping("/drink/add")
    public String addDrink(Model model){
        model.addAttribute("drink",new Drink());
        return "add-drink";
    }

    @PostMapping("/desert/add")
    public String addDesert(@ModelAttribute Desert desert){
        desertService.addDesert(desert);
        return "redirect:/menu";
    }

    @PostMapping("/drink/add")
    public String addDrink(@ModelAttribute Drink drink){
        drinkService.addDrink(drink);
        return "redirect:/menu";
    }

    @GetMapping("/desert/update/{id}")
    public String updateDesert(@PathVariable(name="id")Long idDesert,Model model){
        Desert desertId=desertService.findById(idDesert);
        model.addAttribute("desert",desertId);
        return "add-desert";
    }

    @GetMapping("/drink/update/{id}")
    public String updateDrink(@PathVariable(name="id")Long idDrink,Model model){
        Drink drinkId=drinkService.findById(idDrink);
        model.addAttribute("drink",drinkId);
        return "add-drink";
    }

    @GetMapping("/desert/delete/{id}")
    public String deleteDesert(@PathVariable Long id){
        desertService.deleteDesert(id);
        return "redirect:/menu";
    }

    @GetMapping("/drink/delete/{id}")
    public String deleteDrink(@PathVariable Long id){
        drinkService.deleteDrink(id);
        return "redirect:/menu";
    }

    @GetMapping("/drink/updatePrice/{id}")
    public String updatePriceDrink(@PathVariable Long id,Model model){
        Drink drink = drinkService.findById(id);
        model.addAttribute("drink",drink);
        return "updatePrice-drink";
    }

    @GetMapping("/desert/updatePrice/{id}")
    public String updatePriceDesert(@PathVariable Long id, Model model){
        Desert desert = desertService.findById(id);
        model.addAttribute("desert",desert);
        return "updatePrice-desert";
    }

    @PostMapping("/drink/updatePrice/{id}")
    public String updatePriceDrink(@PathVariable Long id,@RequestParam (name = "price") Integer price){
        Drink drinkId = drinkService.findById(id);
        drinkId.setPrice(price);
        drinkService.saveDrink(drinkId);
        return "redirect:/menu";
    }

    @PostMapping("/desert/updatePrice/{id}")
    public String updatePriceDesert(@PathVariable Long id,@RequestParam(name="price") BigDecimal price){
       Desert desertId = desertService.findById(id);
       desertId.setPrice(price);
       desertService.saveDesert(desertId);
        return "redirect:/menu";
    }
}
