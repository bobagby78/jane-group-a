package org.launchcode.WhatsSup.models.dto;


        import org.launchcode.WhatsSup.models.Recipe;
        import org.launchcode.WhatsSup.models.Tag;

        import javax.validation.constraints.NotNull;


public class FeaturedIngredientTagDTO {


    @NotNull
    private Recipe featuredIngredient;

    @NotNull
    private Tag tag;

    public FeaturedIngredientTagDTO() {}

    public Recipe getFeaturedIngredient() {
        return featuredIngredient;
    }

    public void setFeaturedIngredient(Recipe featuredIngredient) {
        this.featuredIngredient = featuredIngredient;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}