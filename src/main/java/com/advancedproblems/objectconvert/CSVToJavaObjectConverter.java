package com.advancedproblems.objectconvert;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVToJavaObjectConverter {

    // Student class to hold the data from CSV
    static class Student {
        private String name;
        private int age;
        private double grade;

        public Student(String name, int age, double grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + ", grade=" + grade + "}";
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/advancedproblems/objectconvert/file.csv";

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = csvReader.readAll();
            List<Student> students = new ArrayList<>();

            // Skip header and process each record to create Student objects
            for (int i = 1; i < records.size(); i++) {
                String[] record = records.get(i);
                String name = record[0];
                int age = Integer.parseInt(record[1]);
                double grade = Double.parseDouble(record[2]);

                // Create a Student object and add it to the list
                students.add(new Student(name, age, grade));
            }

            // Print the list of students
            System.out.println("List of Students:");
            for (Student student : students) {
                System.out.println(student);
            }

        } catch (IOException | CsvException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}
