package com.intermediateproblems.filterrecord;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVFilterRecord {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/intermediateproblems/filterrecord/file.csv";

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = csvReader.readAll();

            // Iterate over records
            System.out.println("Students who scored more than 80:");
            for (int i = 1; i < records.size(); i++) {
                String[] record = records.get(i);
                String name = record[0];
                int marks = Integer.parseInt(record[1]);

                if (marks > 80) {
                    System.out.println("Name: " + name + ", Marks: " + marks);
                }
            }
        } catch (IOException | CsvException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}
