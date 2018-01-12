package com.example;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;

/**
 * @author Alejandro Duarte
 */
@SpringView(name = "view2")
public class View2 extends Composite implements View {

    private final Service service;

    public View2(Service service) {
        this.service = service;
        setCompositionRoot(new Label(service.view2Message()));
    }
}
