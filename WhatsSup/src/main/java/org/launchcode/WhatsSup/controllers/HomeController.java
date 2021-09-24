package org.launchcode.WhatsSup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index") // changed to be able to send user to landing page if ever necessary
    public String index() {
        return "index";
    }

}