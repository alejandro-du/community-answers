package com.example;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;

/**
 * @author Alejandro Duarte
 */
@SpringView(name = "view1")
public class View1 extends Composite implements View {

    private final Service service;

    public View1(Service service) {
        this.service = service;
        setCompositionRoot(new Label(service.view1Message()));
    }
}
