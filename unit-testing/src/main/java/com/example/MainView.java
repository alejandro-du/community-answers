package com.example;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;

@Route(MainView.ROUTE)
public class MainView extends Composite<VerticalLayout> {

    public static final String ROUTE = "";

    private final AgeService ageService;

    public MainView(AgeService ageService) {
        this.ageService = ageService;

        DatePicker datePicker = new DatePicker("Birth date");
        Button button = new Button("Calculate age");
        getContent().add(datePicker, button);

        button.addClickListener(event -> calculateAge(datePicker.getValue()));
    }

    protected void calculateAge(LocalDate date) {
        if (date == null) {
            showError();
        } else {
            showAge(date);
        }
    }

    protected void showError() {
        Notification.show("Please enter a date.");
    }

    protected void showAge(LocalDate date) {
        int age = ageService.getAgeByBirthDate(date);
        String text = String.format("Age: %s years old", age);
        getContent().add(new Paragraph(text));
    }

}
