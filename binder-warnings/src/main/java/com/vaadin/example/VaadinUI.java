package com.vaadin.example;

import com.vaadin.data.Binder;
import com.vaadin.data.ValidationResult;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ErrorLevel;
import com.vaadin.ui.*;

/**
 * @author Alejandro Duarte.
 */
public class VaadinUI extends UI {

    public static class Bean {

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        TextField textField = new TextField("Max 5 characters, preferably without spaces");

        Binder<Bean> binder = new Binder<>();
        binder.forField(textField)
                .withValidator((v, c) -> v.contains(" ") ? ValidationResult.create("This is a warning!", ErrorLevel.WARNING) : ValidationResult.ok())
                .withValidator((v, c) -> v.length() > 5 ? ValidationResult.error("This is an error!") : ValidationResult.ok())
                .bind(Bean::getValue, Bean::setValue);

        binder.setBean(new Bean());

        Button button = new Button("Validate", e -> {
            if (binder.validate().getValidationErrors().isEmpty()) {
                Notification.show("Valid!");
            } else {
                Notification.show("Not valid!");
            }
        });

        setContent(new VerticalLayout(textField, button));
    }

}
