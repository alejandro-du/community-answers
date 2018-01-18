package com.example;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;

public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        PersonForm<Person> form = new PersonForm<>();
        form.setPerson(new Person("Mr", "Hai Chan"));
        setContent(form);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

}
