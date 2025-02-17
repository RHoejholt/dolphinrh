package app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class PersonDetail
{
    @Id
    @GeneratedValue
    private Integer id;
    private String Address;
    private int zip;
    private String city;
    private int age;

    // Relationer 1:1

    @OneToOne
    @MapsId
    @ToString.Exclude
    private Person person;

    public PersonDetail(String address, int zip, String city, int age)
    {
        Address = address;
        this.zip = zip;
        this.city = city;
        this.age = age;
    }
}
