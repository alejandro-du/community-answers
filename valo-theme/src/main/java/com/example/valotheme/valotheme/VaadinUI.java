package com.example.valotheme.valotheme;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.layout.impl.HorizontalSplitCrudLayout;

/**
 * @author Alejandro Duarte.
 */
@SpringUI
@Theme("darktheme")
public class VaadinUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        GridCrud<Person> crud = new GridCrud<>(Person.class, new HorizontalSplitCrudLayout());
        crud.setCrudListener(new PersonService());
        setContent(crud);
    }

}
