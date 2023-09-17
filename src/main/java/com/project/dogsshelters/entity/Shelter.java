package com.project.dogsshelters.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "shelters")
public class Shelter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
    private String name;
    private String city;
    private String contactnum;
    @JsonIgnoreProperties("shelter")
    @OneToMany(mappedBy = "shelter", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Dog> dogs;

    public Shelter() {
        super();
    }

    public Shelter(int sid) {
        super();
        this.sid = sid;
    }

    public Shelter(String name, String city, String contactnum) {
        super();
        this.name = name;
        this.city = city;
        this.contactnum = contactnum;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactnum() {
        return contactnum;
    }

    public void setContactnum(String contactnum) {
        this.contactnum = contactnum;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
        dogs.forEach(item -> item.setShelter(this));
    }

}
