package org.launchcode.WhatsSup.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Ingredient extends AbstractEntity{
    //id extended by AbstrEnt

    private String ingredientName;
    private String ingredientCategory; //meat, seafood, spice, condiment: from dropdown on "My Kitchen" add ingredient form
    private String purchaseDate; // as opposed to expiration date. expiration date can be figured from here.

    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();


    public Ingredient() {
    }

    public Ingredient(String ingredientName, String ingredientCategory, String purchaseDate) {
        this.ingredientName = ingredientName;
        this.ingredientCategory = ingredientCategory;
        this.purchaseDate = purchaseDate;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientCategory() {
        return ingredientCategory;
    }

    public void setIngredientCategory(String ingredientCategory) {
        this.ingredientCategory = ingredientCategory;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(ingredientName, that.ingredientName) && Objects.equals(ingredientCategory, that.ingredientCategory) && Objects.equals(purchaseDate, that.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ingredientName, ingredientCategory, purchaseDate);
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

}
