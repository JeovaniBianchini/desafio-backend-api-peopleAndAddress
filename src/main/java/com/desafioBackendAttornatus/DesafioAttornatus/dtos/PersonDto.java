package com.desafioBackendAttornatus.DesafioAttornatus.dtos;

import com.desafioBackendAttornatus.DesafioAttornatus.entities.Person;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.time.LocalDate;

public class PersonDto implements Serializable {

    private Long id;

    @NotBlank(message = "Campo requerido")
    private String name;

    @NotBlank(message = "Campo requerido")
    private LocalDate birthday;

    public PersonDto(){
    }

    public PersonDto(Long id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public PersonDto(Person person) {
        id = person.getId();
        name = person.getName();
        birthday = person.getBirthday();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
