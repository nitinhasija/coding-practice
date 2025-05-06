package com.epam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Ram", 25),
                new Person("Sham", 17),
                new Person("Varun", 30),
                new Person("Arun", 16)
        );

        // converting names to upper case whose age is greater than 18

        List<String> result = people.stream()
                .filter(person -> person.getAge() > 18)
                .map(person -> person.getName().toUpperCase())
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}
