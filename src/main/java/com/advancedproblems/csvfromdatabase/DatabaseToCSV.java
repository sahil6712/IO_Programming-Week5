package com.advancedproblems.csvfromdatabase;

import com.opencsv.CSVWriter;
import java.sql.*;
import java.io.FileWriter;
import java.io.IOException;

public class DatabaseToCSV {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/Sahil_327";
        String username = "Sahil_327";
        String password = "SahilKhe_9";
        String csvFilePath = "src/main/java/com/advancedproblems/csvfromdatabase/file.csv";

        String query = "SELECT employee_id, name, department, salary FROM employees";  // Your SQL query

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {

            // Write the header to the CSV file
            writer.writeNext(new String[] { "Employee ID", "Name", "Department", "Salary" });

            // Process each record from the ResultSet and write it to the CSV file
            while (rs.next()) {
                String employeeId = rs.getString("employee_id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                // Write the data to the CSV file
                writer.writeNext(new String[] { employeeId, name, department, String.valueOf(salary) });
            }

            System.out.println("CSV report generated successfully!");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            System.out.println("Error generating the CSV report: " + e.getMessage());
        }
    }
}
