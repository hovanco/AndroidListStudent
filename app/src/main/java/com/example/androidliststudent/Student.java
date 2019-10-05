package com.example.androidliststudent;
//    Create constructor
//    Define the attribute of the Student object

public class Student {
    private String name;
    private int age;
    private String galaxy;

    public Student(String name, int age, String galaxy) {
        this.name = name;
        this.age = age;
        this.galaxy = galaxy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(String galaxy) {
        this.galaxy = galaxy;
    }


}
