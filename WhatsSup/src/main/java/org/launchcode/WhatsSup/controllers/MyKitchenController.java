package org.launchcode.WhatsSup.controllers;

import org.launchcode.WhatsSup.data.AddIngredientRepository;
import org.launchcode.WhatsSup.models.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("kitchen")
public class MyKitchenController {

    @Autowired
    private AddIngredientRepository addIngredientRepository;

    @GetMapping
    public String displayMyKitchen(Model model){
        model.addAttribute("title", "Hey, Dude. This is my kitchen");
        model.addAttribute(new Ingredient());
        return"kitchen/index";
    }

    @PostMapping
    public String processAddIngredientForm(@ModelAttribute Ingredient newIngredient, Model model){
        addIngredientRepository.save(newIngredient);
        return "/kitchen/index";
    }

}
