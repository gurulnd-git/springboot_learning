package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {


    public static void main(String[] args) {
        Employee employee = new Employee();
        System.out.println(employee.toString());

       List<Employee> employeeList = Stream.of(
                new Employee("Sardar","453","Ed"),
                new Employee("Vivek","545","Rf"),
                new Employee("Aamir","655","Ed")
        ).collect(Collectors.toList());

       employeeList.forEach(System.out::println);

        Map<String,Employee> collect1 = employeeList.stream().collect(Collectors.toMap(Employee::getEmpId, e -> e));
        System.out.println("1");
        collect1.forEach((o, o2) -> System.out.println(o2.getName()));
        collect1 = employeeList.stream().collect(Collectors.toMap(Employee::getEmpId, Function.identity(),(o1, o2)-> o2));
        System.out.println("2");
        collect1.forEach((o, o2) -> System.out.println(o2.getName()));
        collect1 = employeeList.stream().collect(Collectors.toMap(Employee::getEmpId, Function.identity(),(o1,o2)-> o1, LinkedHashMap::new));
        System.out.println("3");
        collect1.forEach((o, o2) -> System.out.println(o2.getName()));

    }



}
