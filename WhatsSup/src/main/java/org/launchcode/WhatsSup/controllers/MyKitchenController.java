package org.launchcode.WhatsSup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("kitchen")
public class MyKitchenController {

    //Needs a repository for @Autowire

    @GetMapping
    public String displayMyKitchen(Model model){
        model.addAttribute("title", "My Kitchen");
        return"/kitchen";
    }

}
