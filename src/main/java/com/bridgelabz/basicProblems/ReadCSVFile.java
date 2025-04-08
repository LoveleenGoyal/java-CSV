package com.bridgelabz.basicProblems;

import java.io.*;

public class ReadCSVFile {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("files/studentDetails.csv"));
            String line;
            reader.readLine(); // skip header line

            System.out.println("Student Details:");
            System.out.println("--------------------");

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                // Print the student details
                System.out.println("ID: " + columns[0]);
                System.out.println("Name: " + columns[1]);
                System.out.println("Age: " + columns[2]);
                System.out.println("Marks: " + columns[3]);
                System.out.println("--------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
