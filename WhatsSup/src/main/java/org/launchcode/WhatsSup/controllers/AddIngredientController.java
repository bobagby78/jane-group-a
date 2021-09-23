package org.launchcode.WhatsSup.controllers;

import org.launchcode.WhatsSup.data.AddIngredientRepository;
import org.launchcode.WhatsSup.data.TagRepository;
import org.launchcode.WhatsSup.models.Ingredient;
import org.launchcode.WhatsSup.models.Tag;
import org.launchcode.WhatsSup.models.dto.IngredientTagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("ingredient")
public class AddIngredientController {

    @Autowired
    private AddIngredientRepository addIngredientRepository;

    @GetMapping("/add")
    public String displayAddIngredientForm(Model model){
        model.addAttribute("title", "Add Ingredient");
        model.addAttribute(new Ingredient());
        return "/ingredient/add";
    }

    @PostMapping("/add")
    public String processAddIngredientForm(@ModelAttribute Ingredient newIngredient, Model model){
       addIngredientRepository.save(newIngredient);
        return "/ingredient/add";
    }


    //TODO getMapping and html needs work
    @GetMapping("add-tag")
    public String displayAddTagForm(@RequestParam Integer ingredientId, Model model){
        Optional<Ingredient> result = addIngredientRepository.findById(ingredientId);
        Ingredient ingredient = result.get();
        model.addAttribute("title", "Add Tag to: " + ingredient.getIngredientName());


        //TODO fix findAll()

        model.addAttribute("tags", TagRepository.findAll());
        IngredientTagDTO ingredientTagDTO = new IngredientTagDTO();
        ingredientTagDTO.setIngredient(ingredient);
        model.addAttribute("ingredientTag", ingredientTagDTO);
        // TODO return needs work
        return "redirect:add-tag";
    }

    //TODO postmapping and html needs worked
    @PostMapping("add-tag")
    public String processAddTagForm(@ModelAttribute @Valid IngredientTagDTO ingredientTagDTO,
                                    Errors errors,
                                    Model model){

        if (!errors.hasErrors()) {
            Ingredient ingredient = ingredientTagDTO.getIngredient();
            Tag tag = ingredientTagDTO.getTag();
            if (!ingredient.getTags().contains(tag)){
                ingredient.addTag(tag);

                //TODO fix save method
                ingredient.save(ingredient);
            }
            return "redirect:detail?eventId=" + ingredient.getId();
        }
// TODO return statements need worked
        return "redirect:add-tag";
    }
}
