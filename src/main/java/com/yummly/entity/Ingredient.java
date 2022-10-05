package com.yummly.entity;

public class Ingredient {
    private final String description;
    private final String toggle;

    public Ingredient(String contentDescription) {
        String[] content = contentDescription.split(" ", 2);
        this.toggle = content[0];
        this.description = content[1].replace(" to Shopping List", "")
                .replace(" from Shopping List", "");
    }

    public String getDescription() {
        return description;
    }

    public boolean hasMinusToggle() {
        return toggle.equals("Remove");
    }

    public boolean hasPlusToggle() {
        return toggle.equals("Add");
    }
}
