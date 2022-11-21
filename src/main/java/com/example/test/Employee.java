package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class Employee {
    @Value("${datasource.username}")
    private String name1;
    @Value("${datasource.password}")
    private String pass;
    public Employee(String name, String empId, String location) {
        this.name = name;
        this.empId = empId;
        this.location = location;
    }

    public Employee() {
    }

    @Autowired
    public Employee(@Value("${datasource.password}") String prop) {
        this.pass = prop;
        System.out.println("================== " + prop + "================== ");
    }

    public String getName1() {
        return name1;
    }

    public String getPass() {
        return pass;
    }

    private String name;
    private String empId;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name1='" + name1 + '\'' +
                ", empId='" + empId + '\'' +
                ", location='" + location + '\'' +
                '}';
    }


}