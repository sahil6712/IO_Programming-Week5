package com.advancedproblems.readlargecsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeCSVReader {

    public static void main(String[] args) {
        String filePath = "src/main/java/com/advancedproblems/readlargecsv/file.csv";
        int chunkSize = 100;  // Number of lines to process at a time
        int totalRecordsProcessed = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineCount = 0;

            // Skip header line (if there is one)
            br.readLine();

            // Process the file in chunks of 100 lines
            while ((line = br.readLine()) != null) {
                lineCount++;

                // Every 100 lines, display the count and reset
                if (lineCount % chunkSize == 0) {
                    totalRecordsProcessed += chunkSize;
                    System.out.println("Processed " + totalRecordsProcessed + " records so far.");
                    // Simulate processing of the chunk here (e.g., parsing and storing the data)
                }
            }

            // If there are leftover lines after the last chunk
            if (lineCount % chunkSize != 0) {
                totalRecordsProcessed += lineCount % chunkSize;
                System.out.println("Processed " + totalRecordsProcessed + " records in total.");
            }

        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}
