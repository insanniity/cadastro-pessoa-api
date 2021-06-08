package com.insannity.pessoaapi.controllers;

import com.insannity.pessoaapi.dto.MessageResponseDTO;
import com.insannity.pessoaapi.entity.Person;
import com.insannity.pessoaapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/peoples")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return service.save(person);
    }

}
