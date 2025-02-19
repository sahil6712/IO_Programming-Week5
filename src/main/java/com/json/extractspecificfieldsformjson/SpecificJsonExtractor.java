package com.json.extractspecificfieldsformjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpecificJsonExtractor {
    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(new File("src/main/java/com/json/extractspecificfieldsformjson/file.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> names = new ArrayList<>();
        List<String> email = new ArrayList<>();
        for(JsonNode node:jsonNode) {
            names.add(node.get("name").asText());
            email.add(node.get("email").asText());
        }

        // Output
        for(int i=0; i<names.size(); i++) {
            System.out.println(names.get(i)+email.get(i)+"\n");
        }
    }
}
