package com.desafioBackendAttornatus.DesafioAttornatus.dtos;

import com.desafioBackendAttornatus.DesafioAttornatus.entities.Address;
import com.desafioBackendAttornatus.DesafioAttornatus.entities.Person;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PersonDto implements Serializable {

    private Long id;

    @NotBlank(message = "Campo requerido")
    private String name;

    private LocalDate birthday;

    private List<AddressDto> addresses = new ArrayList<>();

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

    public PersonDto(Person person, Set<Address> addresses) {
        this(person);
        addresses.forEach(adds -> this.addresses.add(new AddressDto(adds)));
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

    public List<AddressDto> getAddresses() {
        return addresses;
    }
}
