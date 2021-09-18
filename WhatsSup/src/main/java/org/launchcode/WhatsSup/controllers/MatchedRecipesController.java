package org.launchcode.WhatsSup.controllers;


import org.launchcode.WhatsSup.data.RecipeRepository;
import org.launchcode.WhatsSup.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@Controller
@RequestMapping("/matchedrecipes")
public class MatchedRecipesController {
    @Autowired
    private final RecipeRepository recipeRepository;

    public MatchedRecipesController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/{ingredients}")
    public List<Recipe> findMatchedRecipes(@PathVariable("ingredients") String ingredients) {
        List<Recipe> matchedRecipes = this.recipeRepository.findByIngredients(ingredients);

//        HashMap<String, String> myRecipesNameAndDescription = new HashMap<String, String>();
//        for (int i = 0; i < myRecipes.size(); i++){
//            myRecipesNameAndDescription.put(myRecipes.get(i).getRecipeTitle(),myRecipes.get(i).getRecipeDescription());
//        }
        return matchedRecipes;

    }
}
