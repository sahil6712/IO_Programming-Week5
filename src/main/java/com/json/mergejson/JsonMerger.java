package com.json.mergejson;

import org.json.JSONObject;

public class JsonMerger {
    public static void main(String[] args) {

        // Create the json object
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        JSONObject merged = new JSONObject();

        // Add key value pairs in first json object
        jsonObject.put("name","Sahil Khaimariya");
        jsonObject.put("email","sahilkhemariya327@gmail.com");

        // Add key value pair in second json object
        jsonObject2.put("name","Lihas");
        jsonObject2.put("email","lihar420@gmail.com");

        // Merge both jsonobject into one
        merged.put("1",jsonObject);
        merged.put("2",jsonObject2);

        // Output
        System.out.println(merged.toString());
    }

}
