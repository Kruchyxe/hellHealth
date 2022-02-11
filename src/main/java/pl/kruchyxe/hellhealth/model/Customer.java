package pl.kruchyxe.hellhealth.model;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column
    private int age;

    @Column
    private int weight;

    public Customer() {
    }

    public Customer(int id, String firstname, String lastname, int age, int weight) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return firstname;
    }

    public void setName(String firstname) {
        this.firstname = firstname;
    }

    public String getSurename() {
        return lastname;
    }

    public void setSurename(String lastname) {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + firstname + '\'' +
                ", surename='" + lastname + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
