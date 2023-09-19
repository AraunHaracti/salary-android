package com.example.salary;

import java.io.Serializable;

public class User implements Serializable {
    public String name;
    public String surname;
    public int age;
    public float salary;

    public User(String name, String surname, int age, float salary){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
    }
}
