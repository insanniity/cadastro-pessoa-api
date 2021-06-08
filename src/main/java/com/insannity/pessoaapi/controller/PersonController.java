package com.insannity.pessoaapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/peoples")
public class PersonController {

    @GetMapping
    public String getPeoples(){
        return "Hello World!";
    }

}
