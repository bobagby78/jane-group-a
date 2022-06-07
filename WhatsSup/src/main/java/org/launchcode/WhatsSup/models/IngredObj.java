//package org.launchcode.WhatsSup.models;
//
//import java.util.HashMap;
//import java.util.Objects;
//
//public class IngredObj {
//    HashMap<Ingredient, MeasurementObj> ingredObj = new HashMap<>();
//
//    public IngredObj() {
//    }
//
//    public IngredObj(HashMap<Ingredient, MeasurementObj> ingredObj) {
//        this.ingredObj = ingredObj;
//    }
//
//    public HashMap<Ingredient, MeasurementObj> getIngredObj() {
//        return ingredObj;
//    }
//
//    public void setIngredObj(HashMap<Ingredient, MeasurementObj> ingredObj) {
//        this.ingredObj = ingredObj;
//    }
//
//    @Override
//    public String toString() {
//        return "RecipeIngredObj{" +
//                "ingredObj=" + ingredObj +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        IngredObj that = (IngredObj) o;
//        return Objects.equals(ingredObj, that.ingredObj);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(ingredObj);
//    }
//}
