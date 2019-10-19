package com.gangofdevelopers.recipes.data.model;

/**
 * Entity class to work with recipes when we parse them from json or xml.
 */
public class RecipeEntity {
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
