package com.example.test;

import java.util.*;
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


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6,2);
        int result = numbers
                .stream()
                .reduce(1, (subtotal, element) -> Integer.sum(subtotal,element));
        System.out.println("result : "+ result);
        result = numbers
                .stream()
                .reduce(1, (subtotal, element) -> subtotal+element);

        System.out.println("result 1 : "+ result);
        result = numbers.stream().reduce(0, Integer::sum);
        System.out.println("result 2 : "+ result);
    }



}
