package edu.kpi.ordermanagement.web.rest.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(path = "/", produces = "text/html")
    public String home() {
        return "<a href='/api/orders'>Find all! /api/orders</a>" +
                "<br/>" +
                "<a href='/api/orders/demo'>By id /api/orders/{id}</a>";
    }
}
