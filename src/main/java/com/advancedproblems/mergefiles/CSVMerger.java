package com.advancedproblems.mergefiles;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CSVMerger {

    public static void main(String[] args) {
        String filePath1 = "src/main/java/com/advancedproblems/mergefiles/student1.csv";
        String filePath2 = "src/main/java/com/advancedproblems/mergefiles/student2.csv";
        String outputFilePath = "src/main/java/com/advancedproblems/mergefiles/merged.csv";

        try (CSVReader reader1 = new CSVReader(new FileReader(filePath1));
             CSVReader reader2 = new CSVReader(new FileReader(filePath2));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {

            // Read both CSV files into lists
            List<String[]> records1 = reader1.readAll();
            List<String[]> records2 = reader2.readAll();

            // Create a map to store students from the first file (students1.csv)
            Map<String, String[]> studentMap = new HashMap<>();

            // Skip header and store records from the first file (students1.csv) in the map
            for (int i = 1; i < records1.size(); i++) {
                String[] record = records1.get(i);
                String id = record[0];
                studentMap.put(id, record);
            }

            // Create a list to hold merged records
            List<String[]> mergedRecords = new ArrayList<>();
            // Add header to merged records
            mergedRecords.add(new String[] { "ID", "Name", "Age", "Marks", "Grade" });

            // Iterate through the second file (students2.csv) and merge with the first
            for (int i = 1; i < records2.size(); i++) {
                String[] record2 = records2.get(i);
                String id = record2[0];

                // Check if ID exists in the first file (studentMap)
                if (studentMap.containsKey(id)) {
                    String[] student1 = studentMap.get(id);
                    String name = student1[1];
                    String age = student1[2];
                    String marks = record2[1];
                    String grade = record2[2];

                    // Merge the data and add to the merged list
                    mergedRecords.add(new String[] { id, name, age, marks, grade });
                }
            }

            // Write the merged records to the output file
            writer.writeAll(mergedRecords);

            System.out.println("CSV files have been merged successfully!");

        } catch (IOException | CsvException e) {
            System.out.println("Error reading or writing the CSV files: " + e.getMessage());
        }
    }
}
