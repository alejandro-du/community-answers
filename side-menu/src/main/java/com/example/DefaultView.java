package com.example;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;

/**
 * @author Alejandro Duarte
 */
@SpringView(name = "")
public class DefaultView extends Composite implements View {

    private final Service service;

    public DefaultView(Service service) {
        this.service = service;
        setCompositionRoot(new Label(this.service.defaultMessage()));
    }
}
