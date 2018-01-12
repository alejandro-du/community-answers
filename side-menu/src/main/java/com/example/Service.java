package com.example;

import org.springframework.stereotype.Component;

/**
 * @author Alejandro Duarte
 */
@Component
public class Service {

    public String defaultMessage() {
        return "This is the default view";
    }

    public String view1Message() {
        return "This is view 1";
    }

    public String view2Message() {
        return "This is view 2";
    }

}
