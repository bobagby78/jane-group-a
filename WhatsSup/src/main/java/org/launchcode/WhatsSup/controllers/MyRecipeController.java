package org.launchcode.WhatsSup.controllers;

import org.launchcode.WhatsSup.data.RecipeRepository;
import org.launchcode.WhatsSup.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/myrecipes")
    public List<Recipe> findByRecipeAuthor(@PathVariable("recipe_author") String recipeAuthor) {
        return this.recipeRepository.findByRecipeAuthor(recipeAuthor);
	}

    @GetMapping("/byIngredients")
    public List<Recipe> findByIngredients(@PathVariable("ingredients") String ingredients) {
        return this.recipeRepository.findByIngredients(ingredients);
    }
}

