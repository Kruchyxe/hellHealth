package pl.kruchyxe.hellhealth.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GroceryListDto {

    private int id;

    @NotBlank
    @Size(min = 1)
    private String ingredient;

    @NotNull
    @Size(min = 1, max = 4)
    private long measure;

    public GroceryListDto() {
    }

    public GroceryListDto(int id, String ingredient, long measure) {
        this.id = id;
        this.ingredient = ingredient;
        this.measure = measure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public long getMeasure() {
        return measure;
    }

    public void setMeasure(long measure) {
        this.measure = measure;
    }
}
