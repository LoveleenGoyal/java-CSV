package com.bridgelabz.advancedProblems;

import com.opencsv.bean.CsvBindByName;

public class Student {
    @CsvBindByName(column = "ID")
    private int id;

    @CsvBindByName(column = "Name")
    private String name;

    @CsvBindByName(column = "Age")
    private int age;

    @CsvBindByName(column = "Marks")
    private int marks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", age = " + age +
                ", marks = " + marks +
                '}';
    }
}
