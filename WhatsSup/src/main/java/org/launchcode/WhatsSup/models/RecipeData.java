package org.launchcode.WhatsSup.models;

import java.util.ArrayList;

public class RecipeData extends AbstractEntity{

    public static ArrayList<Recipe> findByColumnAndValue(String column, String value, Iterable<Recipe> allRecipes) {

        ArrayList<Recipe> results = new ArrayList<>();

        if (value.equalsIgnoreCase("all")){
            return (ArrayList<Recipe>) allRecipes;
        }

        if (column.equals("all")){
            results = findByValue(value, allRecipes);
            return results;
        }
        for (Recipe recipe : allRecipes) {

            String aValue = getFieldValue(recipe, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(recipe);
            }
        }

        return results;
    }

    public static String getFieldValue(Recipe recipe, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = recipe.getRecipeTitle();
        } else if (fieldName.equals("employer")){
            theValue = recipe.getAuthor().toString();
        } else {
            theValue = recipe.getIngredients().toString();
        }

        return theValue;
    }

    /**
     * Search all Job fields for the given term.
     *
     * @param value The search term to look for.
     * @param allJobs The list of jobs to search.
     * @return      List of all jobs with at least one field containing the value.
     */
    public static ArrayList<Recipe> findByValue(String value, Iterable<Recipe> allJobs) {
        String lower_val = value.toLowerCase();

        ArrayList<Recipe> results = new ArrayList<>();

        for (Recipe recipe : allJobs) {

            if (recipe.getRecipeTitle().toLowerCase().contains(lower_val)) {
                results.add(recipe);
            } else if (recipe.getAuthor().toString().toLowerCase().contains(lower_val)) {
                results.add(recipe);
            } else if (recipe.getIngredients().toString().toLowerCase().contains(lower_val)) {
                results.add(recipe);
            } else if (recipe.toString().toLowerCase().contains(lower_val)) {
                results.add(recipe);
            }

        }

        return results;
    }


}