package com.insannity.pessoaapi.controllers;

import com.insannity.pessoaapi.dto.MessageResponseDTO;
import com.insannity.pessoaapi.dto.PersonDTO;
import com.insannity.pessoaapi.exceptions.PersonNotFoundException;
import com.insannity.pessoaapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/peoples")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return service.save(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll (){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        service.deleteById(id);
    }



}
