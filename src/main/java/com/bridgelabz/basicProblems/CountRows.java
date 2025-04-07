package com.bridgelabz.basicProblems;

import java.io.*;
import java.util.*;

public class CountRows {
    public static void main(String[] args){
        String recordFile = "records.csv";

        try {
            Scanner sc = new Scanner(new File(recordFile));
            sc.nextLine(); // skip header
            List<String[]> records = new ArrayList<>();
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                records.add(data);
            }
            System.out.println("Number of rows in CSV file: " + records.size());
            for (String[] r : records) {
                System.out.println(Arrays.toString(r));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
