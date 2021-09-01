package org.launchcode.WhatsSup.controllers;
        import org.launchcode.WhatsSup.data.RecipeRepository;
        import org.launchcode.WhatsSup.models.Recipe;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;

        import org.launchcode.WhatsSup.models.RecipeData;

        import java.util.HashMap;


@Controller
@RequestMapping(value = "list")
public class MyRecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public MyRecipeController () {

        columnChoices.put("all", "All");
        columnChoices.put("employer", "Employer");
        columnChoices.put("skill", "Skill");

    }

    @RequestMapping("")
    public String list(Model model) {

        return "list";
    }

    @RequestMapping(value = "recipes")
    public String listRecipesByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Recipe> recipes;
        if (column.toLowerCase().equals("all")){
            recipes = recipeRepository.findAll();
            model.addAttribute("title", "All Recipes");
        } else {
            recipes = RecipeData.findByColumnAndValue(column, value, recipeRepository.findAll());
            model.addAttribute("title", "Recipes with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("jobs", recipes);

        return "list-jobs";
    }
}