package com.bridgelabz.intermediateProblems;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateRecord {
    public static void main(String[] args) {
        String inputFile = "files/employeeDetails.csv";
        String outputFile = "files/updatedEmployeeDetails.csv";

        List<String> updatedLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String header = br.readLine();
            updatedLines.add(header); // keep the header

            String line;
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(",");

                if (employee.length == 4 && employee[2].trim().equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(employee[3].trim());
                    salary = salary * 1.10; // increase by 10%
                    employee[3] = String.format("%.2f", salary); // format salary
                }

                updatedLines.add(String.join(",", employee));
            }

            // Write updated content to new file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
                for (String updatedLine : updatedLines) {
                    bw.write(updatedLine);
                    bw.newLine();
                }
                System.out.println("Updated employee details saved to: " + outputFile);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

