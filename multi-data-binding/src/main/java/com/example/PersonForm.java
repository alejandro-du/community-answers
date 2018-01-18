package com.example;

import com.vaadin.data.Binder;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

public class PersonForm<T extends Person> extends HorizontalLayout {
    private TextField nameField1;
    private TextField nameField2;
    private T person;
    private Binder<T> binder;

    public PersonForm() {
        nameField1 = new TextField("Name1");
        nameField2 = new TextField("Name2");
        addComponents(nameField1, nameField2);
        binder = new Binder<>();
        binder.forField(nameField1).bind(Person::getName, Person::setName);
        binder.forField(nameField2).bind(Person::getName, Person::setName);
        binder.addValueChangeListener(e -> binder.setBean(person));
    }

    public void setPerson(T person) {
        this.person = person;
        this.binder.setBean(this.person);
    }
}
