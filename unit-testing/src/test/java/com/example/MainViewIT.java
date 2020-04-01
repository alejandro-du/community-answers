package com.example;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.datepicker.testbench.DatePickerElement;
import com.vaadin.flow.component.html.testbench.ParagraphElement;
import com.vaadin.flow.component.notification.testbench.NotificationElement;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MainViewIT extends AbstractViewTest {

    public MainViewIT() {
        super(MainView.ROUTE);
    }

    @Test
    public void shouldShowNotificationOnNullDate() {
        DatePickerElement datePicker = $(DatePickerElement.class).first();
        datePicker.clear();
        ButtonElement button = $(ButtonElement.class).first();
        button.click();

        NotificationElement notification = $(NotificationElement.class).waitForFirst();
        boolean isOpen = notification.isOpen();
        assertThat(isOpen, is(true));
    }

    @Test
    public void shouldAddParagraphOnNonNullDate() {
        int expectedCount = $(ParagraphElement.class).all().size() + 1;
        DatePickerElement datePicker = $(DatePickerElement.class).first();
        datePicker.setDate(LocalDate.now());
        ButtonElement button = $(ButtonElement.class).first();
        button.click();

        int actualCount = $(ParagraphElement.class).all().size();
        assertThat(actualCount, is(expectedCount));
    }



}
