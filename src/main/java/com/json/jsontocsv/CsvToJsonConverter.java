package com.json.jsontocsv;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        String csvFile = "src/main/java/com/json/jsontocsv/file.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String headerLine = br.readLine();
            String[] headers = headerLine.split(",");

            JSONArray jsonArray = new JSONArray();
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                JSONObject jsonObject = new JSONObject();

                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i], values[i]); // Map column name to value
                }
                jsonArray.put(jsonObject);
            }

            // Print JSON output
            System.out.println(jsonArray.toString(4));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
