package com.advancedproblems.detectduplicate;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVDuplicateDetector {

    public static void main(String[] args) {
        String filePath = "src/main/java/com/advancedproblems/detectduplicate/file.csv";
        Set<String> seenIDs = new HashSet<>();  // Set to store unique IDs
        List<String[]> duplicateRecords = new ArrayList<>();  // List to store duplicate records

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = csvReader.readAll();

            // Skip header row if needed
            String[] header = records.get(0);

            // Iterate over each record (starting from index 1 to skip header)
            for (int i = 1; i < records.size(); i++) {
                String[] record = records.get(i);
                String id = record[0];  // Assuming the ID is the first column (index 0)

                // Check if the ID has already been seen
                if (seenIDs.contains(id)) {
                    // If seen, store the duplicate record
                    duplicateRecords.add(record);
                } else {
                    // If not seen, add the ID to the set
                    seenIDs.add(id);
                }
            }

            // Print the duplicate records
            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicates found.");
            } else {
                System.out.println("Duplicate records:");
                for (String[] record : duplicateRecords) {
                    System.out.println(Arrays.toString(record));
                }
            }

        } catch (IOException | CsvException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}
