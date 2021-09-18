package org.launchcode.WhatsSup.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Entity
public class Recipe extends AbstractEntity{
    //id being extended from AbstrEnt
    @NotBlank(message="Your recipe needs a title")
    @Size (min=3, max = 250, message="Recipe title should be between 3 and 250 characters")
    private String recipeTitle;

    // initialize author to the currently logged in user.
    @NotNull(message="Please tell us who added the recipe")
    @Size (min=3, max=250, message="Recipe author should be at least 3 characters, but not exceed 250 characters")
    private String user;

    private int prepTimeMinutes;
    @NotNull(message="Please enter a value for total cooking time")
    private int totalTimeMinutes;

    private int numServings;
    @NotBlank(message="Please provide a brief description of your recipe")
    @Size(min=1, max=500, message="Recipe description should not exceed 500 characters")
    private String recipeDescription;

    @NotEmpty(message="It looks like  you haven't added any ingredients to your recipe")
    private ArrayList<String> ingredients;

    @NotEmpty(message="It looks like  you haven't added any directions to your recipe")
    private ArrayList<String> directions;

    private String notes;

    public Recipe(){}

    public Recipe(String recipeTitle,  int prepTimeMinutes, int totalTimeMinutes, int numServings, String recipeDescription, ArrayList<String> ingredients, ArrayList<String> directions, String notes) {
        this.recipeTitle = recipeTitle;
        this.prepTimeMinutes = prepTimeMinutes;
        this.totalTimeMinutes = totalTimeMinutes;
        this.numServings = numServings;
        this.recipeDescription = recipeDescription;
        this.ingredients = ingredients;
        this.directions = directions;
        this.notes = notes;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public int getPrepTimeMinutes() {
        return prepTimeMinutes;
    }

    public void setPrepTimeMinutes(int prepTimeMinutes) {
        this.prepTimeMinutes = prepTimeMinutes;
    }

    public int getTotalTimeMinutes() {
        return totalTimeMinutes;
    }

    public void setTotalTimeMinutes(int totalTimeMinutes) {
        this.totalTimeMinutes = totalTimeMinutes;
    }

    public int getNumServings() {
        return numServings;
    }

    public void setNumServings(int numServings) {
        this.numServings = numServings;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<String> getDirections() {
        return directions;
    }

    public void setDirections(ArrayList<String> directions) {
        this.directions = directions;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
