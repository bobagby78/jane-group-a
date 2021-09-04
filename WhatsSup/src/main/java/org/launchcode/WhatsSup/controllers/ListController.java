package org.launchcode.WhatsSup.controllers;

import org.launchcode.WhatsSup.data.RecipeRepository;
import org.launchcode.WhatsSup.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
@Controller
@RequestMapping(value = "list")
public class ListController {


    @Autowired
    private RecipeRepository recipeRepository;


    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("employer", "Employer");
        columnChoices.put("skill", "Skill");

    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("employers", recipeRepository.findAll());
        return "list";
    }

    @RequestMapping(value = "recipes")
    public String findByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Recipe> recipes;
        if (column.toLowerCase().equals("all")){
            recipes = recipeRepository.findAll();
            model.addAttribute("title", "All Jobs");
        } else {
            recipes = recipeRepository.findAll();
            model.addAttribute("title", "Jobs with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("recipes", recipes);

        return "list-jobs";
    }
}
