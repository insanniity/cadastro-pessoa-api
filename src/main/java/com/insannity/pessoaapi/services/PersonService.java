package com.insannity.pessoaapi.services;

import com.insannity.pessoaapi.dto.MessageResponseDTO;
import com.insannity.pessoaapi.dto.PersonDTO;
import com.insannity.pessoaapi.entity.Person;
import com.insannity.pessoaapi.exceptions.PersonNotFoundException;
import com.insannity.pessoaapi.mapping.PersonMapper;
import com.insannity.pessoaapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonMapper mapper = PersonMapper.INSTANCE;

    @Autowired
    private PersonRepository repository;

    @Transactional
    public MessageResponseDTO save(PersonDTO personDTO){
        Person personSaved = mapper.toModel(personDTO);
        Person savedPerson = repository.save(personSaved);
        return createdMessageResponse(savedPerson, "Salvo com sucesso, id: ");
    }

    @Transactional(readOnly = true)
    public List<PersonDTO> findAll() {
        List<Person> peoples = repository.findAll();
        return peoples.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PersonDTO findById(Long id) throws PersonNotFoundException {
       Person person = verifyIfExist(id);
       return mapper.toDTO(person);
    }

    public void deleteById(Long id) throws PersonNotFoundException {
        verifyIfExist(id);
        repository.deleteById(id);
    }

    @Transactional
    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExist(id);
        Person person = mapper.toModel(personDTO);
        Person personSaved = repository.save(person);
        return createdMessageResponse(personSaved, "Atualizado com sucesso! id: ");
    }



    private MessageResponseDTO createdMessageResponse(Person personSaved, String message) {
        return MessageResponseDTO.builder().message(message + personSaved.getId()).build();
    }

    private Person verifyIfExist(Long id) throws PersonNotFoundException {
        return repository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }
}
