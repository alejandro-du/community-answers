package org.test;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import javax.servlet.annotation.WebServlet;

/**
 * @author Alejandro Duarte.
 */
public class WebConfig {

    @WebServlet(urlPatterns = "/*", name = "VaadinUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = VaadinUI.class, productionMode = false)
    public static class VaadinUIServlet extends VaadinServlet {
    }

}
