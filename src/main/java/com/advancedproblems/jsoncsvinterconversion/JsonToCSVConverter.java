package com.advancedproblems.jsoncsvinterconversion;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.*;

public class JsonToCSVConverter {

    public static void main(String[] args) {
        String jsonFilePath = "src/main/java/com/advancedproblems/jsoncsvinterconversion/file.json";
        String csvFilePath = "src/main/java/com/advancedproblems/jsoncsvinterconversion/file.csv";

        convertJsonToCsv(jsonFilePath, csvFilePath);
    }

    public static void convertJsonToCsv(String jsonFilePath, String csvFilePath) {
        try {
            // Read JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

            // Open CSV writer
            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {

                // Write header
                writer.writeNext(new String[]{"ID", "Name", "Age", "Marks"});

                // Convert JSON data to CSV format
                for (JsonNode student : rootNode) {
                    String id = student.get("id").asText();
                    String name = student.get("name").asText();
                    String age = student.get("age").asText();
                    String marks = student.get("marks").asText();

                    writer.writeNext(new String[]{id, name, age, marks});
                }
            }

            System.out.println("JSON converted to CSV successfully!");

        } catch (IOException e) {
            System.out.println("Error converting JSON to CSV: " + e.getMessage());
        }
    }
}
