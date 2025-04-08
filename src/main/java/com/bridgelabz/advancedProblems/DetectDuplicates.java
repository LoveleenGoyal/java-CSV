package com.bridgelabz.advancedProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class DetectDuplicates {
    public static void main(String[] args) {
        String file = "files/duplicate.csv";

        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            reader.readNext();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

}
