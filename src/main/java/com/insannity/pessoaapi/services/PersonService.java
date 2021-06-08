package com.insannity.pessoaapi.services;

import com.insannity.pessoaapi.dto.MessageResponseDTO;
import com.insannity.pessoaapi.dto.PersonDTO;
import com.insannity.pessoaapi.entity.Person;
import com.insannity.pessoaapi.mapping.PersonMapper;
import com.insannity.pessoaapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonMapper mapper = PersonMapper.INSTANCE;

    @Autowired
    private PersonRepository repository;


    public MessageResponseDTO save(PersonDTO personDTO){
        Person personSaved = mapper.toModel(personDTO);
        Person savedPerson = repository.save(personSaved);
        return MessageResponseDTO.builder().message("Created id: "+savedPerson.getId()).build();
    }


    public List<PersonDTO> findAll() {
        List<Person> peoples = repository.findAll();
        return peoples.stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
