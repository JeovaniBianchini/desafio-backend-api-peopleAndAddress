package com.desafioBackendAttornatus.DesafioAttornatus.controllers;

import com.desafioBackendAttornatus.DesafioAttornatus.dtos.PersonDto;
import com.desafioBackendAttornatus.DesafioAttornatus.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/peoples")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> savePerson(@Valid @RequestBody PersonDto personDto){
        PersonDto dto = personService.savePerson(personDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(personDto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<PersonDto>> findAllPerson(Pageable pageable){
        Page<PersonDto> list = personService.findAllPerson(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDto> findByIdPerson(@PathVariable Long id){
        PersonDto dto = personService.findByIdPerson(id);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonDto> updatePerson(@Valid @PathVariable Long id, @RequestBody PersonDto personDto){
        PersonDto dto = personService.updatePerson(id, personDto);
        return ResponseEntity.ok().body(dto);
    }
}
