package com.json.validateemail;

import org.json.JSONObject;
import java.util.regex.Pattern;

public class EmailValidator {
    public static void main(String[] args) {
        // JSON string
        String jsonString = "{ \"email\": \"test@example.com\" }";

        // Parse JSON using JSONObject
        JSONObject jsonObject = new JSONObject(jsonString);
        String email = jsonObject.getString("email");

        // Validate email
        if (isValidEmail(email)) {
            System.out.println("Valid Email!");
        } else {
            System.out.println("Invalid Email!");
        }
    }

    // Method to validate email using regex
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }
}
