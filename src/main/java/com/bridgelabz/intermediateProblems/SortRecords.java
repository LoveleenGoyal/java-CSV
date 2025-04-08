package com.bridgelabz.intermediateProblems;

import java.io.*;
import java.util.*;

class Employee implements Comparable<Employee> {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.department = dept;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(o.salary, this.salary); // descending order
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + department + ", " + salary;
    }
}

public class SortRecords {
    public static void main(String[] args) {
        String file = "files/employee.csv";
        List<Employee> employeeList = new ArrayList<>();

        try (BufferedReader br  = new BufferedReader(new FileReader(file))) {
            br.readLine(); // skip header

            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");

                int id = Integer.parseInt(columns[0]);
                String name = columns[1];
                String dept = columns[2];
                double salary = Double.parseDouble(columns[3]);

                employeeList.add(new Employee(id, name, dept, salary));
            }

            Collections.sort(employeeList);

            for (int i = 0 ; i < 5 ; i++) {
                System.out.println(employeeList.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
