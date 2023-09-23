package com.project.dogsshelters.entity;

public class DogInsert {

    private int did;
    private String name;
    private String breed;
    private String sex;
    private int age;
    private String status;
    private String shelterid;

    public DogInsert() {
        super();
    }

    public DogInsert(String name, String breed, String sex, int age, String status, String shelterid) {
        super();
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.age = age;
        this.status = status;
        this.shelterid = shelterid;
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

    public String getShelterid() {
        return shelterid;
    }

    public void setShelterid(String shelterid) {
        this.shelterid = shelterid;
    }

}
