package com.example.valotheme.valotheme;

import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Alejandro Duarte.
 */
public class PersonService implements CrudListener<Person> {

    private static List<Person> people;

    static {
        people = IntStream.range(1, 50)
                .mapToObj(i -> new Person("Name" + i, new Date(), "email" + i + "@test.com"))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Person> findAll() {
        return people;
    }

    @Override
    public Person add(Person person) {
        people.add(person);
        return person;
    }

    @Override
    public Person update(Person person) {
        return person;
    }

    @Override
    public void delete(Person person) {
        people.remove(person);
    }

}
