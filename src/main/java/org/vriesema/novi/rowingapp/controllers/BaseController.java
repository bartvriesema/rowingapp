package org.vriesema.novi.rowingapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BaseController {

    @GetMapping(value = "/")
    public String greeting() {
        return "Welcome to the rowing application";
    }

    @GetMapping(value = "/users/")
    public String greetingAuthenticated() {
        return "User is authenticated";
    }
}
