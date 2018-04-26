package edu.kpi.payments.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(path = "/", produces = "text/html")
    public String home() {
        return "<a href='/api/payments'>Find all! /api/payments</a>" +
                "<br/>" +
                "<a href='/api/payments/demo-receipt'>By id /api/payments/{id}</a>";
    }
}
