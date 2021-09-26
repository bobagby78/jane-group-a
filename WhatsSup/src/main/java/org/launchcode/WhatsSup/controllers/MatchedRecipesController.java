package org.launchcode.WhatsSup.controllers;

import org.launchcode.WhatsSup.data.AddIngredientRepository;
import org.launchcode.WhatsSup.data.AddRecipeRepository;
import org.launchcode.WhatsSup.models.Ingredient;
import org.launchcode.WhatsSup.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("matchedrecipes")
public class MatchedRecipesController {

    @Autowired
    private AddRecipeRepository addRecipeRepository;

    @Autowired
    private AddIngredientRepository addIngredientRepository;


    @GetMapping
    public String displayMatchedRecipes(Model model){

        Iterable<Recipe> allRecipes;
        allRecipes=addRecipeRepository.findAll();

        ArrayList<Recipe> blacklist = new ArrayList<>();
        ArrayList<Recipe> matchedRecipes = new ArrayList<>();
        ArrayList<Recipe> userRecipes = new ArrayList<>();

        Iterable<Ingredient> allIngredients = addIngredientRepository.findAll();
        ArrayList<String> myIngredients = new ArrayList<>();

        for (Ingredient ingredient : allIngredients){
            myIngredients.add(ingredient.getIngredientName().toLowerCase());
        }

        for(Recipe recipe : allRecipes){
            for (String ingredientToMatch : recipe.getFeaturedIngredient()) {
                if(!myIngredients.contains(ingredientToMatch)) {
                   blacklist.add(recipe);
                }else if(!matchedRecipes.contains(recipe)){
                    matchedRecipes.add(recipe);
                }
            }

        }

        model.addAttribute("allRecipes", allRecipes);
        model.addAttribute("matchedRecipes", matchedRecipes);

        return "matchedrecipes/index";
    }

}
