package org.launchcode.WhatsSup.data;

import org.launchcode.WhatsSup.models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddIngredientRepository extends CrudRepository<Ingredient, Integer> {

}
