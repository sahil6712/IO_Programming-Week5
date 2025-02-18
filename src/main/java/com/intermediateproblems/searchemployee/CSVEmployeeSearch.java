package com.intermediateproblems.searchemployee;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CSVEmployeeSearch {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/intermediateproblems/searchemployee/employee.csv";
        Scanner scanner = new Scanner(System.in);

        // Asking for the employee's name to search
        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine();

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = csvReader.readAll();
            boolean found = false;

            // Iterate over records, skipping the header
            for (int i = 1; i < records.size(); i++) {
                String[] record = records.get(i);
                // name is in the first column
                String name = record[0];
                // department is in the second column
                String department = record[1];
                // salary is in the third column
                String salary = record[2];

                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("Employee found:");
                    System.out.println("Name: " + name);
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + salary);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }

        } catch (IOException | CsvException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}
