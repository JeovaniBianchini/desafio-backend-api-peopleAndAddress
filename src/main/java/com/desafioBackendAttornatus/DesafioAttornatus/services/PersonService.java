package com.desafioBackendAttornatus.DesafioAttornatus.services;

import com.desafioBackendAttornatus.DesafioAttornatus.dtos.PersonDto;
import com.desafioBackendAttornatus.DesafioAttornatus.entities.Person;
import com.desafioBackendAttornatus.DesafioAttornatus.repositories.PersonRepository;
import com.desafioBackendAttornatus.DesafioAttornatus.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public PersonDto savePerson(PersonDto dto){
        Person person = new Person();
        person.setName(dto.getName());
        person.setBirthday(dto.getBirthday());
        person = personRepository.save(person);
        return new PersonDto(person);
    }

    @Transactional(readOnly = true)
    public Page<PersonDto> findAllPerson(Pageable pageable){
        Page<Person> list = personRepository.findAll(pageable);
        return list.map(x -> new PersonDto(x));
    }

    @Transactional(readOnly = true)
    public PersonDto findByIdPerson(Long id){
        Optional<Person> personOptional = personRepository.findById(id);
        Person person = personOptional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new PersonDto(person);
    }

    @Transactional
    public PersonDto updatePerson(Long id, PersonDto dto){
        try {
            Person person = personRepository.getReferenceById(id);
            person.setName(dto.getName());
            person.setBirthday(dto.getBirthday());
            person = personRepository.save(person);
            return new PersonDto(person);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id " + id + " not found ");
        }
    }
}
