package com.json.jsonfilter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class JsonFilter {
    public static void main(String[] args) {
        // JSON String
        String jsonArray = "[{\"name\":\"Alice\",\"age\":25}, {\"name\":\"Bob\",\"age\":30}, {\"name\":\"Charlie\",\"age\":28}]";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Convert JSON to List of Person objects
            List<Person> people = objectMapper.readValue(jsonArray, new TypeReference<List<Person>>() {});

            // Filter records where age > 25
            List<Person> filteredPeople = people.stream()
                    .filter(person -> person.getAge() > 25)
                    .collect(Collectors.toList());

            // Convert filtered list back to JSON
            String filteredJson = objectMapper.writeValueAsString(filteredPeople);
            System.out.println("Filtered JSON: " + filteredJson);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}