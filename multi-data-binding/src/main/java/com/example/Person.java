package com.example;

import java.io.Serializable;

public class Person implements Serializable {
    private String title;
    private String name;

    public Person() {
    }

    public Person(final String title, final String name) {
        this.title = title;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        System.out.println("Title : " + this.title);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Name : " + this.name);
    }
}
