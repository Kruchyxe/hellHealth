package pl.kruchyxe.hellhealth.model;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "customer_gender")
    private String gender;

    @Column
    private int age;

    @Column
    private int weight;

    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, int age, String gender, int weight) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.weight = weight;

    }

    public Customer(String firstname, String lastname, int age, int weight, String gender) {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return firstName;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", surename='" + lastName + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
