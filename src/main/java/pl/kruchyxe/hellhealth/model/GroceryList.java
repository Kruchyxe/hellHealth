package pl.kruchyxe.hellhealth.model;

import javax.persistence.*;

@Entity
public class GroceryList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column
    private String ingredient;

    @Column
    private long measure;

    public GroceryList() {
    }

    public GroceryList(int id, String ingredient, long measure) {
        this.id = id;
        this.ingredient = ingredient;
        this.measure = measure;
    }

    public long getId() {
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

    @Override
    public String toString() {
        return "GroceryList{" +
                "id=" + id +
                ", ingredient='" + ingredient + '\'' +
                ", measure=" + measure +
                '}';
    }
}
