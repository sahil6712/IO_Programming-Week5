package com.basicprograms.csvrecordscounter;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVRecordCounter {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/basicprograms/csvrecordscounter/file.csv";
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = csvReader.readAll();
            int rowCount = records.size() - 1; // Excluding the header
            System.out.println("Total records (excluding header): " + rowCount);
        } catch (IOException | CsvException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
