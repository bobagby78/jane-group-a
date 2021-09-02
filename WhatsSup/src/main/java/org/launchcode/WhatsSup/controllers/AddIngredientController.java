package org.launchcode.WhatsSup.controllers;

import org.launchcode.WhatsSup.data.AddIngredientRepository;
import org.launchcode.WhatsSup.models.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("ingredient")
public class AddIngredientController {

    @Autowired
    private AddIngredientRepository addIngredientRepository;

    @GetMapping("/add")
    public String displayAddIngredientForm(Model model){
        model.addAttribute("title", "Add Ingredient");
        model.addAttribute(new Ingredient());
        return "/ingredient/add";
    }

    @PostMapping("/add")
    public String processAddIngredientForm(@ModelAttribute Ingredient newIngredient, Model model){
       addIngredientRepository.save(newIngredient);
        return "/ingredient/add";
    }

}
