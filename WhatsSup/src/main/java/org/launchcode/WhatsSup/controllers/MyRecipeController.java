package org.launchcode.WhatsSup.controllers;

import org.launchcode.WhatsSup.data.RecipeRepository;
import org.launchcode.WhatsSup.models.Recipe;
import org.launchcode.WhatsSup.models.User;
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
@RequestMapping("/myrecipes")
public class MyRecipeController {
    @Autowired
    private final RecipeRepository recipeRepository;

    public MyRecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
  }

    public static void findByUser() {
    }

    @GetMapping("/{user}")
    public HashMap<String, String> findMyRecipesNameAndDescription(@PathVariable("user") User user) {
        List<Recipe> myRecipes = this.recipeRepository.findByUser(user);

        HashMap<String, String> myRecipesNameAndDescription = new HashMap<String, String>();
        for (int i = 0; i < myRecipes.size(); i++){
            myRecipesNameAndDescription.put(myRecipes.get(i).getRecipeTitle(),myRecipes.get(i).getRecipeDescription());
        }
        return myRecipesNameAndDescription;

    }
}
