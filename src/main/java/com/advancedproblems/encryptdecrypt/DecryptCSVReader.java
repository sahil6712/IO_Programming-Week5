package com.advancedproblems.encryptdecrypt;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DecryptCSVReader {
    public static void main(String[] args) {
        String csvFile = "src/main/java/com/advancedproblems/encryptdecrypt/file.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> records = reader.readAll();

            // Print headers
            System.out.println("ID | Name | Email | Salary");

            // Process each row (Skip header)
            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                String id = row[0];
                String name = row[1];
                String email = AESUtil.decrypt(row[2]);
                String salary = AESUtil.decrypt(row[3]);

                System.out.println(id + " | " + name + " | " + email + " | " + salary);
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
