package org.launchcode.WhatsSup.models;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.HashMap;

@Entity
public class Recipe extends AbstractEntity{
    //id being extended from AbstrEnt

    private String recipeTitle;
    private String recipeAuthor;
    private int prepTimeMinutes;
    private int totalTimeMinutes;
    private int numServings;
    private String recipeDescription;
    private HashMap<Ingredient, ArrayList> ingredients = new HashMap<>(); //not quite sure this is the route I should be going. Need to take some time to research.
    private ArrayList<String> directions = new ArrayList<>();
    private String notes;

    public Recipe() {
    }

    public Recipe(String recipeTitle, String recipeAuthor, int prepTimeMinutes, int totalTimeMinutes, int numServings, String recipeDescription, HashMap<Ingredient, ArrayList> ingredients, ArrayList<String> directions, String notes) {
        this.recipeTitle = recipeTitle;
        this.recipeAuthor = recipeAuthor;
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

    public String getRecipeAuthor() {
        return recipeAuthor;
    }

    public void setRecipeAuthor(String recipeAuthor) {
        this.recipeAuthor = recipeAuthor;
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

    public HashMap<Ingredient, ArrayList> getIngredients() {
        return ingredients;
    }

    public void setIngredients(HashMap<Ingredient, ArrayList> ingredients) {
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
