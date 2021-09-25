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
@RequestMapping("/matchedrecipes")
public class MatchedRecipesController {
    @Autowired
    private AddRecipeRepository addRecipeRepository;


    @GetMapping String displayMatchedRecipes(Model model, @RequestParam(required = false)Integer recipeId){
//        if (recipeId ==null){

            model.addAttribute("recipes", addRecipeRepository.findAll());
//        }



        return "/matchedRecipe";
    }

//TODO: make a list of recipes that can be created using the available ingredient
//        return "myRecipes";


}
