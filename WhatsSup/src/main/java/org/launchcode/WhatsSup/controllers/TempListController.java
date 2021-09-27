package org.launchcode.WhatsSup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("temp-list")
public class TempListController {

    @GetMapping
    public String displayList(Model model){
        model.addAttribute("list", "list");
        return "temp-list";
    }

}
