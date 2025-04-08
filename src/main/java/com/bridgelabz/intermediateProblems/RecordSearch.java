package com.bridgelabz.intermediateProblems;

import java.io.*;
import java.util.Scanner;

public class RecordSearch {
    public static void main(String[] args) {
        String file = "files/employeeDetails.csv";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim();

        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            br.readLine(); // skip header
            String line;

            while ((line = br.readLine()) != null) {
                String[] employee = line.split(",");

                String name = employee[1];
                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println(name + " is in " + employee[2] + " department and salary is " + employee[3]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
