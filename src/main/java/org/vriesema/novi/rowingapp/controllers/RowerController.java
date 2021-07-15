package org.vriesema.novi.rowingapp.controllers;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vriesema.novi.rowingapp.model.rowingclub.Rower;
import org.vriesema.novi.rowingapp.service.RowerService;

import java.util.List;

@RestController
@RequestMapping("/api/users/rowers")
public class RowerController {
    private final RowerService rowerService;
    //private final PersonService personService;

    @Autowired
    public RowerController(RowerService rowerService) {
        this.rowerService = rowerService;
    }

    @GetMapping
    public List<Rower> getRowers() {
        return rowerService.getRowers();
    }

    @PostMapping
    public void addRower() {

    }

}
