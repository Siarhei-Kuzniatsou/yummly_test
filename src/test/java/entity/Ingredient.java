package entity;

public class Ingredient {
    private final String MINUS_TOGGLE = "Remove";
    private final String PLUS_TOGGLE = "Add";
    private String description;
    private String toggle;

    public Ingredient(String contentDescription) {
        String[] content = contentDescription.split(" ", 2);
        this.toggle = content[0];
        this.description = content[1];
    }

    public String getDescription() {
        return description;
    }

    public boolean hasMinusToggle() {
        return toggle.equals(MINUS_TOGGLE);
    }

    public boolean hasPlusToggle() {
        return toggle.equals(PLUS_TOGGLE);
    }
}
