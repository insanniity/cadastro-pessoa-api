package com.insannity.pessoaapi.services;

import com.insannity.pessoaapi.dto.MessageResponseDTO;
import com.insannity.pessoaapi.dto.PersonDTO;
import com.insannity.pessoaapi.entity.Person;
import com.insannity.pessoaapi.mapping.PersonMapper;
import com.insannity.pessoaapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonMapper mapper= PersonMapper.INSTANCE;

    @Autowired
    private PersonRepository repository;

    public MessageResponseDTO save(PersonDTO personDTO){
        Person personSaved = mapper.toModel(personDTO);
        Person savedPerson = repository.save(personSaved);
        return MessageResponseDTO.builder().message("Created id: "+savedPerson.getId()).build();
    }


}
