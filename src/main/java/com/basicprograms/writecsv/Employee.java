package com.basicprograms.writecsv;

public class Employee {
    String id;
    String name;
    String department;
    String salary;

    // Constructor
    Employee(String id, String name, String department, String salary) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
