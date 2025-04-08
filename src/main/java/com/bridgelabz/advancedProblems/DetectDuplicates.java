package com.bridgelabz.advancedProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String file = "files/duplicate.csv";

        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            reader.readNext();

            String[] line;
            Set<String> uniqueIds = new HashSet<>();
            Set<String> duplicates = new LinkedHashSet<>();

            while ((line = reader.readNext()) != null){
                String id = line[0];

                if (!uniqueIds.add(id)) {
                    duplicates.add(id);
                }
            }

            if (duplicates.isEmpty()) {
                System.out.println("No duplicate rows found.");
            } else {
                System.out.println("Duplicate ID found: " + duplicates);
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

}
