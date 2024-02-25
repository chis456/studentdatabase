package com.quizapp.quizapp.models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int uid;
    private String name;
    private double weight;
    private double height;
    private String hairColour;
    private double gpa;
    private String international;

    public User() {}

    public User(String name, double weight, double height, String hairColour, double gpa, String international)
    {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.hairColour = hairColour;
        this.gpa = gpa;
        this.international = international;
    }

    public int getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getHairColour() {
        return hairColour;
    }

    public double getGpa() {
        return gpa;
    }

    public String getInternational() {
        return international;
    }

    public void setInternational(String international) {
        this.international = international;
    }
}
