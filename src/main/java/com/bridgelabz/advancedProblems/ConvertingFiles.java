package com.bridgelabz.advancedProblems;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.*;

class Students {
    public int id;
    public String name;
    public int age;
    public int marks;

    public Students() {}

    public Students(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
}
public class ConvertingFiles {
    public static void main(String[] args) throws IOException {
        String jsonFile = "files/students.json";
        String csvFile = "files/csvStudents.csv";

        ObjectMapper objectMapper = new ObjectMapper();

        List<Students> students = objectMapper.readValue(new File(jsonFile), new TypeReference<List<Students>>() {});

        try (CSVWriter writer  = new CSVWriter(new FileWriter(csvFile))){
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks"});
            for (Students s : students) {
                writer.writeNext(new String[]{
                        String.valueOf(s.id),
                        s.name,
                        String.valueOf(s.age),
                        String.valueOf(s.marks)
                });
            }
        }
        System.out.println("Converted Json to Csv");

    }
}
