package org.launchcode.WhatsSup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WhatsSupController {

    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "What's for dinner?";
    }
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "I don't know, wish I had an app to help me find a cool recipe.";
    }

}
