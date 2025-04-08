package com.bridgelabz.advancedProblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergeFiles {
    public void readFiles(String file1, String file2, String mergedFile) {
        Map<String, String[]> map1 = new HashMap<>();
        Map<String, String[]> map2 = new HashMap<>();

        try {
            CSVReader reader1 = new CSVReader(new FileReader(file1));
            CSVReader reader2 = new CSVReader(new FileReader(file2));

            reader1.readNext();
            reader2.readNext();

            String[] line1;
            String[] line2;
            while ((line1 = reader1.readNext()) != null) {
                map1.put(line1[0], Arrays.copyOfRange(line1,1, line1.length));
            }

            while ((line2 = reader2.readNext()) != null) {
                map2.put(line2[0], Arrays.copyOfRange(line2,1, line2.length));
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        writeToFile(map1, map2, mergedFile);
    }

    public void writeToFile(Map<String, String[]> map1, Map<String, String[]> map2, String mergedFile) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(mergedFile));

            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});

            for (String id : map1.keySet()) {
                if (map2.containsKey(id)) {
                    String[] part1 = map1.get(id);
                    String[] part2 = map2.get(id);

                    String[] mergedRow = new String[5];
                    mergedRow[0] = id;
                    mergedRow[1] = part1[0];        // Name
                    mergedRow[2] = part1[1];        // Age
                    mergedRow[3] = part2[0];        // Marks
                    mergedRow[4] = part2[1];        // Grade
                    writer.writeNext(mergedRow);
                }
                else {
                    System.out.println("Skipping ID " + id + " - not found in second file");
                }
            }
            writer.close();
            System.out.println("merged file created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String file1 = "files/students1.csv";
        String file2 = "files/students2.csv";

        String mergedFile = "files/students_merged.csv";

        MergeFiles mergeFiles = new MergeFiles();
        mergeFiles.readFiles(file1, file2, mergedFile);
    }
}
