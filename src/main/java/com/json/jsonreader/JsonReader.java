package com.json.jsonreader;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonReader {
    public static void main(String[] args) {
        // Path to JSON file
        File file = new File("src/main/java/com/json/jsonreader/file.json");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON file into a Map
            Map<String, Object> jsonMap = objectMapper.readValue(file, Map.class);

            // Print all keys and values
            for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
