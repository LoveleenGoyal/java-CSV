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

            List<String[]> rows = reader.readAll();
            Set<String> uniqueRows = new HashSet<>();
            Set<String> duplicates = new LinkedHashSet<>();

            for (String[] row : rows) {
                String result = String.join(",", row);
                if (!uniqueRows.add(result)) {
                    duplicates.add(result);
                }
            }

            if (duplicates.isEmpty()) {
                System.out.println("No duplicate rows found.");
            } else {
                System.out.println("Duplicate rows found:");
                for (String d : duplicates) {
                    System.out.println(d);
                }
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

}
