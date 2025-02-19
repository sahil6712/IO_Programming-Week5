package com.json.validatejson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValidator {
    public static boolean isValidJson(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readTree(json); // Parses JSON
            return true; // Valid JSON
        } catch (Exception e) {
            return false; // Invalid JSON
        }
    }

    public static void main(String[] args) {
        String jsonString = "{ \"name\": \"Sahil\", \"age\": 22 }";
        String invalidJson = "{ name: \"Sahil\", age: 22 ";

        System.out.println("Valid JSON: " + isValidJson(jsonString));
        System.out.println("Invalid JSON: " + isValidJson(invalidJson));
    }
}
