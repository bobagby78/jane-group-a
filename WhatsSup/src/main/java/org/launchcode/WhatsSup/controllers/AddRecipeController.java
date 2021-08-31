package org.launchcode.WhatsSup.controllers;

import org.launchcode.WhatsSup.data.AddRecipeRepository;
import org.launchcode.WhatsSup.models.IngredObj;
import org.launchcode.WhatsSup.models.MeasurementObj;
import org.launchcode.WhatsSup.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("recipe")
public class AddRecipeController {

    @Autowired
    private AddRecipeRepository addRecipeRepository;

    @GetMapping("/add")
    public String displayAddRecipeForm(Model model){
        model.addAttribute("title", "Add Recipe");
        model.addAttribute(new Recipe());
//        model.addAttribute(new IngredObj());
//        model.addAttribute(new MeasurementObj());
        return"/recipe/add";
    }

    @PostMapping("/add")
    public String processAddRecipeForm(@ModelAttribute @Valid
                                                   Recipe newRecipe,
//                                                   IngredObj newIngredObj,
//                                                   MeasurementObj newMeasurementObj,
//                                                   //Model model,
                                                   Errors errors){
        if(errors.hasErrors()){
            return "/recipe/add";
        }
        addRecipeRepository.save(newRecipe);
        return "redirect:../"; //refactor to return "view-my-recipes" when complete
    }

}
