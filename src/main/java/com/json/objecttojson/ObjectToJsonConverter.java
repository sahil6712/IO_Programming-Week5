package com.json.objecttojson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJsonConverter {
    public static void main(String[] args) throws Exception {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Car car = new Car("TATA","CURV",2100000);

            // Convert java object to json
            String jsonString = objectMapper.writeValueAsString(car);

            // Output
            System.out.println(jsonString);
        } catch (Exception e) {
            throw new Exception(e);
        }

    }
}
