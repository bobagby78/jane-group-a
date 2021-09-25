package org.launchcode.WhatsSup.controllers;


import org.launchcode.WhatsSup.data.AddRecipeRepository;
import org.launchcode.WhatsSup.data.RecipeRepository;
import org.launchcode.WhatsSup.models.Ingredient;
import org.launchcode.WhatsSup.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

//@RestController
@Controller
@RequestMapping("matchedrecipes")
public class MatchedRecipesController {

    @Autowired
    private AddRecipeRepository addRecipeRepository;


    @GetMapping
    public String displayMatchedRecipes(Model model){

        model.addAttribute("recipes", "Matched Recipes go here");
                //addRecipeRepository.findAll());
//        }

        return "matchedrecipes/index";
    }

    @GetMapping("all")
    public String ListAllRecipes(Model model){

        model.addAttribute("recipes", addRecipeRepository.findAll());


        return"matchedrecipes/all";
    }

//TODO: make a list of recipes that can be created using the available ingredient
//        return "myRecipes";


}
