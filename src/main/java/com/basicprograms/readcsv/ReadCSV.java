package com.basicprograms.readcsv;

import java.io.*;
import java.util.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ReadCSV {
    private final String filePath;

    public ReadCSV(String filePath) {
        this.filePath = filePath;
    }

    public void readAndPrintCSV() {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] data;
            while ((data = reader.readNext()) != null) {
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    double marks = Double.parseDouble(data[3].trim());
                    System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age + " | Marks: " + marks);
                } else {
                    System.out.println("Skipping invalid line: " + Arrays.toString(data));
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in CSV file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/basicprograms/readcsv/student.csv";
        ReadCSV reader = new ReadCSV(filePath);
        reader.readAndPrintCSV();
    }
}
