package com.json.jsontoxmlconvertor;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        // Example JSON string
        String jsonString = "{ \"name\": \"Alice\", \"age\": 25, \"city\": \"New York\" }";

        // Convert JSON to XML
        JSONObject jsonObject = new JSONObject(jsonString);
        String xml = XML.toString(jsonObject);

        // Print XML output
        System.out.println("XML Output:\n" + xml);
    }
}
