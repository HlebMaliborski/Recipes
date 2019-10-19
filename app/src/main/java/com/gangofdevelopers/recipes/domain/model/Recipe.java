package com.gangofdevelopers.recipes.domain.model;

/**
 * Recipe model or entity. This class used for domain layer.
 * We can put here some business logic.
 * Also, we can use only one model to transfer it from data to presentation layer, but it would be better
 * to have own model for per layer.
 */
public class Recipe {
    private String id;
    private String imageUrl;
    private String description;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
