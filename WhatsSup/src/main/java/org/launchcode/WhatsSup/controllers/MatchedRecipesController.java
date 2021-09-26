package org.launchcode.WhatsSup.controllers;


import org.launchcode.WhatsSup.data.AddIngredientRepository;
import org.launchcode.WhatsSup.data.AddRecipeRepository;
import org.launchcode.WhatsSup.data.RecipeRepository;
import org.launchcode.WhatsSup.models.Ingredient;
import org.launchcode.WhatsSup.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

//@RestController
@Controller
@RequestMapping("matchedrecipes")
public class MatchedRecipesController {

    @Autowired
    private AddRecipeRepository addRecipeRepository;

    @Autowired
    private AddIngredientRepository addIngredientRepository;


    @GetMapping
    public String displayMatchedRecipes(Model model){

        Iterable<Recipe> recipes;
        recipes=addRecipeRepository.findAll();

        ArrayList<Recipe> matchedRecipes = new ArrayList<>();
        ArrayList<Recipe> userRecipes = new ArrayList<>();

        Iterable<Ingredient> allIngredients = addIngredientRepository.findAll();
        ArrayList<String> myIngredients = new ArrayList<>();


        for (Ingredient ingredient : allIngredients){
            myIngredients.add(ingredient.getIngredientName().toLowerCase());
        }
        for(Recipe recipe : recipes){

            if(myIngredients.contains(recipe.getIngredients())) {
                if (!matchedRecipes.contains(recipe)) {
                    matchedRecipes.add(recipe);
                }
            }
        }
        model.addAttribute("recipes", recipes);


//        model.addAttribute("recipes", addRecipeRepository.findAll());
                //addRecipeRepository.findAll());
//        }

        return "matchedrecipes/index";
    }

    @GetMapping("all")
    public String ListAllRecipes(Model model){
        Iterable<Recipe> recipes;

        recipes=addRecipeRepository.findAll();

        model.addAttribute("recipes", recipes);


        return"matchedrecipes/all";
    }

//TODO: make a list of recipes that can be created using the available ingredient
//        return "myRecipes";


}
