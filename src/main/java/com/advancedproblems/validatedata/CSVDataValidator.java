package com.advancedproblems.validatedata;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVDataValidator {

    // Regex pattern to validate email format
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    // Regex pattern to validate phone number with exactly 10 digits
    private static final String PHONE_REGEX = "^[0-9]{10}$";

    public static void main(String[] args) {
        String filePath = "src/main/java/com/advancedproblems/validatedata/file.csv";

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = csvReader.readAll();

            // Iterate over records, skipping the header
            for (int i = 1; i < records.size(); i++) {
                String[] record = records.get(i);
                String name = record[0];
                String email = record[1];
                String phoneNumber = record[2];

                // Validate email
                if (!isValidEmail(email)) {
                    System.out.println("Invalid Email at row " + (i + 1) + ": " + email);
                }

                // Validate phone number
                if (!isValidPhoneNumber(phoneNumber)) {
                    System.out.println("Invalid Phone Number at row " + (i + 1) + ": " + phoneNumber);
                }
            }

        } catch (IOException | CsvException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    // Method to validate email using regex
    private static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Method to validate phone number using regex
    private static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
