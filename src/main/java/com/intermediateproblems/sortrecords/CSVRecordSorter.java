package com.intermediateproblems.sortrecords;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVRecordSorter {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/intermediateproblems/sortrecords/record.csv";

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = csvReader.readAll();

            // Create a list to store employee records along with their salary for sorting
            List<Employee> employees = new ArrayList<>();

            // Skip the header and read the data
            for (int i = 1; i < records.size(); i++) {
                String[] record = records.get(i);
                String name = record[0];
                String department = record[1];
                double salary = Double.parseDouble(record[2]);

                employees.add(new Employee(name, department, salary));
            }

            // Sort employees by salary in descending order
            employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));

            // Print top 5 highest-paid employees
            System.out.println("Top 5 highest-paid employees:");
            for (int i = 0; i < Math.min(5, employees.size()); i++) {
                Employee emp = employees.get(i);
                System.out.println("Name: " + emp.getName() + ", Department: " + emp.getDepartment() + ", Salary: " + emp.getSalary());
            }

        } catch (IOException | CsvException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    // Employee class to hold the data
    static class Employee {
        private String name;
        private String department;
        private double salary;

        public Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }
    }
}

