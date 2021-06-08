package com.insannity.pessoaapi.services;

import com.insannity.pessoaapi.dto.MessageResponseDTO;
import com.insannity.pessoaapi.entity.Person;
import com.insannity.pessoaapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public MessageResponseDTO save(Person person){
        Person savedPerson = repository.save(person);
        return MessageResponseDTO.builder().message("Created id: "+savedPerson.getId()).build();
    }


}
