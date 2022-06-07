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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("kitchen")
public class MyKitchenController {

    @Autowired
    private AddIngredientRepository addIngredientRepository;

    @GetMapping
    public String displayMyKitchen(Model model){

        ArrayList<Ingredient> spices = new ArrayList<>();
        ArrayList<Ingredient> proteins = new ArrayList<>();
        ArrayList<Ingredient> sides = new ArrayList<>();
        ArrayList<Ingredient> condiments = new ArrayList<>();
        ArrayList<Ingredient> other = new ArrayList<>();

        Iterable<Ingredient> allIngredients;
        allIngredients = addIngredientRepository.findAll();

        for(Ingredient ingredient : allIngredients){
            if(ingredient.getIngredientCategory().toLowerCase().equals("spice")){
                spices.add(ingredient);
            }else if(ingredient.getIngredientCategory().toLowerCase().equals("protein")) {
                proteins.add(ingredient);
            }else if(ingredient.getIngredientCategory().toLowerCase().equals("side")) {
                sides.add(ingredient);
            }else if(ingredient.getIngredientCategory().toLowerCase().equals("condiment")){
                condiments.add(ingredient);
            }else{
                other.add(ingredient);
            }

        }

        model.addAttribute("title", "Hey, Dude. This is my kitchen");
        model.addAttribute(new Ingredient());
        model.addAttribute("spices", spices);
        model.addAttribute("proteins", proteins);
        model.addAttribute("sides", sides);
        model.addAttribute("condiments", condiments);
        model.addAttribute("other", other);
        return"kitchen/index";
    }

    @PostMapping
    public String processAddIngredientForm(@ModelAttribute Ingredient newIngredient, Model model){
        addIngredientRepository.save(newIngredient);
        return "redirect:/kitchen";
    }

}
