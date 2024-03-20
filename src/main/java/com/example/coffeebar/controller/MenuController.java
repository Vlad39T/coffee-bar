package com.example.coffeebar.controller;

import com.example.coffeebar.entity.Desert;
import com.example.coffeebar.entity.Drink;
import com.example.coffeebar.service.DesertService;
import com.example.coffeebar.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
}
