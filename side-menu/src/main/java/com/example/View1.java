package com.example;

import com.vaadin.navigator.View;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;

/**
 * @author Alejandro Duarte
 */
public class View1 extends Composite implements View {

    public View1() {
        setCompositionRoot(new Label("This is view 1"));
    }
}
