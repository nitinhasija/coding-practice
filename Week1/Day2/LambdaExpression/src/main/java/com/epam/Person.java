package com.epam;

/**
 * The type Person.
 */
class Person {
    /**
     * The Name.
     */
    String name;
    /**
     * The Age.
     */
    int age;

    /**
     * Instantiates a new Person.
     *
     * @param name the name
     * @param age  the age
     */
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }
}
