package com.project.dogsshelters.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int did;
    private String name;
    private String breed;
    private String sex;
    private int age;
    private String status;
    @JsonIgnoreProperties("dogs")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sid")
    private Shelter shelter;

    public Dog() {
        super();
    }

    public Dog(String name, String breed, String sex, int age, String status, Shelter shelter) {
        super();
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.age = age;
        this.status = status;
        this.shelter = shelter;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

}
