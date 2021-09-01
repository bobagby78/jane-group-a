package org.launchcode.WhatsSup.data;
import org.launchcode.WhatsSup.models.Recipe;
import org.launchcode.WhatsSup.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}