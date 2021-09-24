package org.launchcode.WhatsSup.controllers;

import org.launchcode.WhatsSup.data.AddRecipeRepository;
import org.launchcode.WhatsSup.data.TagRepository;
import org.launchcode.WhatsSup.models.IngredObj;
import org.launchcode.WhatsSup.models.MeasurementObj;
import org.launchcode.WhatsSup.models.Recipe;
import org.launchcode.WhatsSup.models.Tag;
import org.launchcode.WhatsSup.models.dto.FeaturedIngredientTagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("recipe")
public class AddRecipeController { //refactor to just be RecipeController

    @Autowired
    private AddRecipeRepository addRecipeRepository; //refactor to just RecipeRepository

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/add")
    public String displayAddRecipeForm(Model model){
        model.addAttribute("title", "Add Recipe");
        model.addAttribute(new Recipe());
        return"/recipe/add";
    }

    @PostMapping("/add")
    public String processAddRecipeForm(@ModelAttribute @Valid
                                                   Recipe newRecipe,
                                                   Errors errors){
        if(errors.hasErrors()){
            return "/recipe/add";
        }
        addRecipeRepository.save(newRecipe);
        return "redirect:../"; //refactor to return "view-my-recipes" when complete
    }

    @GetMapping("/view/{recipeId}")
    public String displayRecipe(Model model, @PathVariable int recipeId){

        Optional optRecipe = addRecipeRepository.findById(recipeId);
        if (optRecipe.isPresent()){
            Recipe recipe = (Recipe) optRecipe.get();
            model.addAttribute("title", "View Recipe");
            model.addAttribute("recipe", recipe);

        }

        return"/recipe/view"; //optional, follow model from jobs with jobID as req param.
    }


    @GetMapping("add-tag")
    public String displayAddTagForm(@RequestParam Integer recipeId, Model model){
        //TODO is Recipe or AddRecipe what should be optional<>?
        Optional<Recipe> result = addRecipeRepository.findById(recipeId);
        Recipe featuredIngredient = result.get();
        model.addAttribute("title", "Add Tag to: " + featuredIngredient.getFeaturedIngredient());
        model.addAttribute("tags", tagRepository.findAll());
        FeaturedIngredientTagDTO featuredIngredientTag = new FeaturedIngredientTagDTO();
        featuredIngredientTag.setFeaturedIngredient(featuredIngredient);
        model.addAttribute("featuredRecipeTag", featuredIngredientTag);
        return "events/add-tag.html";
    }

    @PostMapping("add-tag")
    public String processAddTagForm(@ModelAttribute @Valid FeaturedIngredientTagDTO featuredIngredientTag,
                                    Errors errors,
                                    Model model){

        if (!errors.hasErrors()) {
            Recipe featuredIngredient = featuredIngredientTag.getFeaturedIngredient();
            Tag tag = featuredIngredientTag.getTag();
            if (!featuredIngredient.getTags().contains(tag)){
                featuredIngredient.addTag(tag);
                addRecipeRepository.save(featuredIngredient);
            }
            return "redirect:detail?eventId=" + featuredIngredient.getId();
        }

        return "redirect:add-tag";
    }

}
