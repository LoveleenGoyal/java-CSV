package com.bridgelabz.advancedProblems;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

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
        String jsonFromCsv = "files/studentsFromCsv.json";

        // Step1: JSON -> CSV
        ObjectMapper objectMapper = new ObjectMapper();

        // Reads json file and maps to list
        List<Students> students = objectMapper.readValue(new File(jsonFile), new TypeReference<List<Students>>() {});

        // Write list to Csv
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


        // Step2: CSV -> JSON
        List<Students> studentsCsv = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            reader.readNext();
            String[] line;
            while ((line = reader.readNext()) != null) {
                int id = Integer.parseInt(line[0]);
                String name = line[1];
                int age = Integer.parseInt(line[2]);
                int marks = Integer.parseInt(line[3]);

                Students s = new Students(id,name,age,marks);
                studentsCsv.add(s);
            }
        } catch (CsvException | IOException e) {
            e.printStackTrace();
        }

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFromCsv), studentsCsv);
        System.out.println("Converted Csv to Json");

    }
}
