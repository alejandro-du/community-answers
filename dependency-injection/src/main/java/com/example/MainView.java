package com.example;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;

@Route("")
public class MainView extends Composite<VerticalLayout> {

    private final AgeService ageService;

    public MainView(AgeService ageService) {
        this.ageService = ageService;

        DatePicker datePicker = new DatePicker("Birth date");
        Button button = new Button("Calculate age");
        getContent().add(datePicker, button);

        button.addClickListener(event -> calculateAge(datePicker.getValue()));
    }

    private void calculateAge(LocalDate date) {
        int age = ageService.getAgeByBirthDate(date);
        String text = String.format("Age: %s years old", age);
        getContent().add(new Paragraph(text));
    }

}
