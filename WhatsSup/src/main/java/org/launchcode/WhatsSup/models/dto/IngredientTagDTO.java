package org.launchcode.WhatsSup.models.dto;

import org.launchcode.WhatsSup.models.Ingredient;
import org.launchcode.WhatsSup.models.Tag;

import javax.validation.constraints.NotNull;


public class IngredientTagDTO {

    @NotNull
    private Ingredient ingredient;

    @NotNull
    private Tag tag;

    public IngredientTagDTO() {}

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}