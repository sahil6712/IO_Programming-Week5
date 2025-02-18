package com.advancedproblems.encryptdecrypt;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EncryptCSVWriter {
    public static void main(String[] args) {
        String csvFile = "src/main/java/com/advancedproblems/encryptdecrypt/file2.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
            // Write header
            writer.writeNext(new String[]{"ID", "Name", "Email", "Salary"});

            // Employee records (Sensitive fields encrypted)
            writer.writeNext(new String[]{"101", "John Doe", AESUtil.encrypt("john.doe@example.com"), AESUtil.encrypt("55000")});
            writer.writeNext(new String[]{"102", "Alice Smith", AESUtil.encrypt("alice.smith@example.com"), AESUtil.encrypt("60000")});
            writer.writeNext(new String[]{"103", "Bob Johnson", AESUtil.encrypt("bob.johnson@example.com"), AESUtil.encrypt("70000")});

            System.out.println("Encrypted data written to CSV successfully!");

        } catch (IOException e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }
}
