package org.launchcode.WhatsSup.models;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Ingredient extends AbstractEntity{
    //id extended by AbstrEnt
    private String ingredientName;
    private String ingredientCategory; //meat, seafood, spice, condiment: from dropdown on "My Kitchen" add ingredient form
    private Date purchaseDate; // as opposed to expiration date. expiration date can be figured from here.
}
