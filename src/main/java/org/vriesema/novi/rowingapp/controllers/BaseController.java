package org.vriesema.novi.rowingapp.controllers;
/*
 * @created:  2021-07-03
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BaseController {

    @GetMapping(value = "/")
    public String greeting() {
        return "Welcome to the rowing application";
    }
}
