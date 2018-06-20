package com.vaadin.example;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * @author Alejandro Duarte.
 */
public class VaadinUI extends UI {

    public static class View1 extends VerticalLayout implements View {
        @Override
        public void enter(ViewChangeListener.ViewChangeEvent event) {
            Window window = new Window("Window", new Label("It works!"));
            UI.getCurrent().addWindow(window);
        }
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Navigator navigator = new Navigator(this, this);
        navigator.addView("", View1.class);
    }

}
