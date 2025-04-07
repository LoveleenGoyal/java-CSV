package com.bridgelabz.intermediateProblems;

import java.io.*;

public class FilterRecords {
    public static void main(String[] args) {
        String file = "studentDetails.csv";

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();

            String line;

            System.out.println("Student details who have marks more than 80: ");
            System.out.println("----------------------");

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");

                if (Integer.parseInt(columns[3]) > 80) {
                    System.out.println("ID: " + columns[0]);
                    System.out.println("Name: " + columns[1]);
                    System.out.println("Age: " + columns[2]);
                    System.out.println("Marks: " + columns[3]);
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
