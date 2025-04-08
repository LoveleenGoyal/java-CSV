package com.bridgelabz.advancedProblems;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.List;

public class CsvToObjects {
    public static void main(String[] args) {
        String file = "files/studentDetails.csv";

        try {
            FileReader reader = new FileReader(file);
            List<Student> students = new CsvToBeanBuilder<Student>(reader)
                    .withType(Student.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();

            for (Student s : students) {
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
