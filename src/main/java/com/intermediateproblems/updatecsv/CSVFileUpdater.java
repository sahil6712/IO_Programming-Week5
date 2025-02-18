package com.intermediateproblems.updatecsv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVFileUpdater {
    public static void main(String[] args) {
        String inputFilePath = "src/main/java/com/intermediateproblems/updatecsv/input.csv";
        String outputFilePath = "src/main/java/com/intermediateproblems/updatecsv/output.csv";

        try (CSVReader csvReader = new CSVReader(new FileReader(inputFilePath))) {
            List<String[]> records = csvReader.readAll();

            // Create a CSVWriter to write to a new file
            try (CSVWriter csvWriter = new CSVWriter(new FileWriter(outputFilePath))) {

                // Write the header to the new file
                csvWriter.writeNext(records.get(0));

                // Iterate over the records and update the salary for IT department
                for (int i = 1; i < records.size(); i++) {
                    String[] record = records.get(i);
                    String name = record[0];
                    String department = record[1];
                    double salary = Double.parseDouble(record[2]);

                    // Check if the department is "IT"
                    if ("IT".equalsIgnoreCase(department)) {
                        // Increase the salary by 10%
                        salary *= 1.10;
                        record[2] = String.format("%.2f", salary);  // Update salary in the record
                    }

                    // Write the updated record to the new file
                    csvWriter.writeNext(record);
                }

                System.out.println("Updated CSV file has been saved successfully.");
            }

        } catch (IOException | CsvException e) {
            System.out.println("Error reading or writing the CSV file: " + e.getMessage());
        }
    }
}
