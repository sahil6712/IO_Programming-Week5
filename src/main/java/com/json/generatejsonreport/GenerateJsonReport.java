package com.json.generatejsonreport;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateJsonReport {
    public static void main(String[] args) {

        JSONArray records = new JSONArray();

        JSONObject record1 = new JSONObject();
        record1.put("id", 1);
        record1.put("name", "Alice");
        record1.put("age", 25);
        record1.put("role", "Developer");
        records.put(record1);

        JSONObject record2 = new JSONObject();
        record2.put("id", 2);
        record2.put("name", "Bob");
        record2.put("age", 30);
        record2.put("role", "Manager");
        records.put(record2);

        JSONObject record3 = new JSONObject();
        record3.put("id", 3);
        record3.put("name", "Charlie");
        record3.put("age", 28);
        record3.put("role", "Designer");
        records.put(record3);

        // Generate JSON report
        JSONObject report = new JSONObject();
        report.put("report_title", "Employee Report");
        report.put("total_records", records.length());
        report.put("data", records);

        // Save JSON report to a file
        try (FileWriter file = new FileWriter("src/main/java/com/json/generatejsonreport/file.json")) {
            file.write(report.toString(4));
            System.out.println("JSON report generated: report.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
