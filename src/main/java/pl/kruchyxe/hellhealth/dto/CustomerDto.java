package pl.kruchyxe.hellhealth.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerDto {

    @NotNull
    @Size(min = 1)
    private int id;

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @Size(min = 1)
    private int age;

    @NotNull
    @Size(min=1, max = 3)
    private int weight;

    @NotBlank
    @Size(min = 1)
    private String gender;

    public CustomerDto() {
    }

    public CustomerDto(
            int id, String firstName,
            String lastName, int age,
            int weight, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
