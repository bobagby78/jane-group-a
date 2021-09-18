package org.launchcode.WhatsSup.data;

import org.launchcode.WhatsSup.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    List<Recipe> findByAuthor(String author);
    //List<Recipe> findRecipesByAuthor;
//      List<Recipe> findByRecipeName(String name);
//      List<Recipe> findByRecipeDescription(String description);
//      List<Recipe> findByRecipeDescription(String description);


//      List<Recipe> findByIngredients(String ingredients);
//      List<Recipe> findByRecipesByAuthor(String recipeAuthor);
//      List<Recipe> findByUserRecipe(String recipeAuthor = username);
}