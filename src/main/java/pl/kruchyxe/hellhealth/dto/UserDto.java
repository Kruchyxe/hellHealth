package pl.kruchyxe.hellhealth.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {

    @NotNull
    @Size(min = 1)
    private int id;

    @NotNull
    @NotBlank
    private String firstname;

    @NotNull
    @NotBlank
    private String lastname;

    @NotNull
    @Size(min = 1)
    private int age;

    @NotNull
    @Size(min=1, max = 3)
    private int weight;

    public UserDto() {
    }

    public UserDto(int id, String firstname, String lastname, int age, int weight) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
}
