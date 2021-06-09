package com.insannity.pessoaapi.controllers;

import com.insannity.pessoaapi.dto.MessageResponseDTO;
import com.insannity.pessoaapi.dto.PersonDTO;
import com.insannity.pessoaapi.exceptions.PersonNotFoundException;
import com.insannity.pessoaapi.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/peoples")
@AllArgsConstructor
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return service.save(personDTO);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@RequestBody @Valid PersonDTO personDTO, @PathVariable Long id) throws PersonNotFoundException {
        return service.updateById(id, personDTO);
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
