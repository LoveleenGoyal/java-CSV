package com.bridgelabz.advancedProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ValidateData {
    public static void main(String[] args) {
        String file = "files/information.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();

            String line;
            int lineNum = 2;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");

                String emailRegex = "^[a-zA-Z0-9][\\w.]*@[a-z]+\\.[a-z]{2,}$";
                String phoneRegex = "^[0-9]{10}$";

                boolean isValid = true;

                if (!columns[1].matches(phoneRegex)) {
                    System.out.println("Invalid phone number in line " + lineNum + ": " + columns[1]);
                    isValid = false;
                }
                if (!columns[2].matches(emailRegex)) {
                    System.out.println("Invalid email in line " + lineNum + ": " + columns[2]);
                    isValid = false;
                }

                if (!isValid) {
                    System.out.println("Invalid row: " + line);
                    System.out.println();
                }
                lineNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
