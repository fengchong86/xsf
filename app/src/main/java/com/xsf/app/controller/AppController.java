package com.xsf.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/execute/{args}")
    public String execute(@PathVariable("args") String args){
        return "reponse : request message [" + args +"]";
    }

}
