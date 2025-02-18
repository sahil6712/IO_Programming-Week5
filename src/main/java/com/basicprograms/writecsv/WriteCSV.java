package com.basicprograms.writecsv;

import java.io.*;
import java.util.*;
import com.opencsv.CSVWriter;

public class WriteCSV {
    private final String filePath;

    public WriteCSV(String filePath) {
        this.filePath = filePath;
    }

    public void writeEmployeesToCSV(List<Employee> employees) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(new String[]{"ID", "Name", "Department", "Salary"});
            for (Employee emp : employees) {
                writer.writeNext(new String[]{
                        emp.getId(),
                        emp.getName(),
                        emp.getDepartment(),
                        emp.getSalary()
                });
            }
            System.out.println("CSV file written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/basicprograms/writecsv/employees.csv";
        WriteCSV writer = new WriteCSV(filePath);
        List<Employee> employees = Arrays.asList(
                new Employee("1", "Alice", "IT", "60000"),
                new Employee("2", "Bob", "HR", "55000"),
                new Employee("3", "Charlie", "Finance", "70000"),
                new Employee("4", "David", "Marketing", "50000"),
                new Employee("5", "Eve", "IT", "65000")
        );
        writer.writeEmployeesToCSV(employees);
    }
}
