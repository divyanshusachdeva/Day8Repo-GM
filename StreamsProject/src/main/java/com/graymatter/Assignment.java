package com.graymatter;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

/*
1. WAP to implement a lambda expression to sort a list of strings in alphabetical order.
2. WAP to implement a lambda expression to find the average of list of doubles.
3. WAP to implement a lambda expression to check if a number is prime.
4. WAP to implement a lambda expression to concatenate 2 strings.
5. WAP to implement a lambda expression to count the words in a paragraph.
6. Create a Person class with the properties name, age, city, Aadhaar number. Create a collection
   of n number of persons and check for whether the person is eligible to cast vote. If not, it
   should throw an AgeNotSufficient Exception. (exceptional handling is in Day 4)*/


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.function.Function;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Assignment {

    public static void main(String[] args) {

        // 1. Lambda to sort a list of strings alphabetically
        ArrayList<String> al = new ArrayList<String>();
        al.add("Hello");
        al.add("World");
        al.add("How");
        al.add("Are");
        al.add("You");
        al.add("Service");
        al.add("Divyanshu");

        Collections.sort(al, (s1, s2) -> s1.compareTo(s2));
        System.out.println("Sorted List: " + al);

        // 2. Lambda to find the average of a list of doubles
        List<Double> doublesList = Arrays.asList(45.0, 52.0, 97.0, 15.0, 68.0, 15.0, 45.0);
        double average = doublesList.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        System.out.println("Average: " + average);

        // 3. Lambda to check if a number is prime
        Predicate<Integer> isPrime = n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
        System.out.println(isPrime.test(7));
        System.out.println(isPrime.test(10));

        // 4. Lambda to concatenate two strings
        BiFunction<String, String, String> concatenate = (s1, s2) -> s1 + s2;
        System.out.println(concatenate.apply("Hello", "World"));

        // 5. Lambda to count the words in a paragraph
        String paragraph = "This is an assignment on Lambda Expressions..";
        Function<String, Long> wordCount = p -> Arrays.stream(p.split("\\s+")).count();
        System.out.println("Word count: " + wordCount.apply(paragraph));

        // 6. Person class and voting eligibility
        List<Person> persons = Arrays.asList(
            new Person("Divyanshu", 25, "Bangalore", "1234-5678-9101"),
            new Person("Aman", 16, "Mumbai", "1234-5678-9102"),
            new Person("Rita", 30, "Delhi", "1234-5678-9103")
        );

        persons.forEach(person -> {
            try {
                if (person.getAge() < 18) {
                    throw new AgeNotSufficientException("Person " + person.getName() + " is not eligible to vote.");
                } else {
                    System.out.println("Person " + person.getName() + " is eligible to vote.");
                }
            } catch (AgeNotSufficientException e) {
                System.out.println(e.getMessage());
            }
        });
    }
}

class Person {
    private String name;
    private int age;
    private String city;
    private String aadhaarNumber;

    public Person(String name, int age, String city, String aadhaarNumber) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.aadhaarNumber = aadhaarNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }
}

class AgeNotSufficientException extends Exception {
    public AgeNotSufficientException(String message) {
        super(message);
    }
}
