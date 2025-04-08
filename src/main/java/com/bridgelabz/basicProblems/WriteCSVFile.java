package com.bridgelabz.basicProblems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSVFile {
    public static void main(String[] args) {
        String employeeFile = "files/employeeDetails.csv";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(employeeFile));

            writer.write("ID,Name,Department,Salary\n");
            writer.write("104,Alice Williams,Finance,62000\n");
            writer.write("101,Loveleen,HR,60000\n");
            writer.write("107,Yagyata,Research,50000\n");
            writer.write("102,Love,Finance,45000");
            writer.close();

            System.out.println("CSV file written successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
