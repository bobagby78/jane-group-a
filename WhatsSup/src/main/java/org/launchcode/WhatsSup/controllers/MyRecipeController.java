package org.launchcode.WhatsSup.controllers;
        import org.launchcode.WhatsSup.data.AddIngredientRepository;
        import org.launchcode.WhatsSup.data.RecipeRepository;
        import org.launchcode.WhatsSup.models.Ingredient;
        import org.launchcode.WhatsSup.models.Recipe;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;

        import org.launchcode.WhatsSup.models.RecipeData;

        import java.util.HashMap;
        import java.util.List;


@Controller
@RequestMapping("myRecipe")
public class MyRecipeController {

    @Autowired
    private RecipeRepository recipeRepository;
    static HashMap<String, String> columnChoices = new HashMap<>();

    public MyRecipeController () {

        columnChoices.put("all", "All");
        columnChoices.put("recipes", "Recipes");
        columnChoices.put("ingredients", "Ingredients");

    }

    @RequestMapping("")
    public String list(Model model) {

        return "recipes";
    }



//    @RequestMapping("")
    public String recipes(Model model) {
        Iterable<Recipe> recipes = recipeRepository.findAll();
//        List<Ingredient> ingredients = AddIngredientRepository.findAll();

        model.addAttribute("recipes", recipes);
//        model.addAttribute("ingredients", ingredients);

        return "recipes";
    }





//    @RequestMapping(value = "recipe")
    public String listRecipesByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Recipe> recipes;
        if (column.equalsIgnoreCase("all")){
            recipes = recipeRepository.findAll();
            model.addAttribute("title", "All Recipes");
        } else {
            recipes = RecipeData.findByColumnAndValue(column, value, recipeRepository.findAll());
            model.addAttribute("title", "Recipes with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("recipes", recipes);

        return "recipes";
    }
}