package com.example.coffeebar.controller;

import com.example.coffeebar.entity.Personal;
import com.example.coffeebar.entity.Position;
import com.example.coffeebar.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonalController {

    private PersonalService personalService;

    @Autowired
    public void setPersonalService(PersonalService personalService) {
        this.personalService = personalService;
    }

    @GetMapping("/personal/add")
    public String add(Model model) {
        model.addAttribute("personal", new Personal());
        model.addAttribute("positions", personalService.getAllPositions());
        return "add-personal";
    }

    @PostMapping("/personal/add")
    public String add(@ModelAttribute Personal personal,
                      @RequestParam (name="id_position")Long idPosition,
                      Model model) {

        Personal personalByPhone=  personalService.getPersonalByPhone(personal.getPhone());
        if(personalByPhone !=null){
            model.addAttribute("err","Користувач з таким номером вже існує");
            model.addAttribute("personal", personal);
            model.addAttribute("positions", personalService.getAllPositions());
            return "add-personal";
        }

        personalService.save(personal,idPosition);
        return "index";
    }

    @GetMapping("/personal/graphic/add")
    public String addGraphics(Model model){
        model.addAttribute("personals",personalService.getAllPersonal());
        model.addAttribute("personals",personalService.getAllGraphic());
        return "personal_graphic";
    }
}
