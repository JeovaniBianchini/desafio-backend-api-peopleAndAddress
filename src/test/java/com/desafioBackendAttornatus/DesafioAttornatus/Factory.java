package com.desafioBackendAttornatus.DesafioAttornatus;

import com.desafioBackendAttornatus.DesafioAttornatus.dtos.AddressDto;
import com.desafioBackendAttornatus.DesafioAttornatus.dtos.AddressReturnDto;
import com.desafioBackendAttornatus.DesafioAttornatus.dtos.PersonDto;
import com.desafioBackendAttornatus.DesafioAttornatus.entities.Address;
import com.desafioBackendAttornatus.DesafioAttornatus.entities.Person;
import com.desafioBackendAttornatus.DesafioAttornatus.entities.enums.AddressType;

import java.time.LocalDate;

public class Factory {

    public static Person CreatePerson(){
        Person person = new Person();
        person.setId(2L);
        person.setName("José");
        person.setBirthday(LocalDate.parse("1991-08-30"));
        return person;
    }

    public static PersonDto createPersonDto(){
        Person person = CreatePerson();
        return new PersonDto(person);
    }

    public static Address createAddress(){

        Address address = new Address();
        address.setId(2L);
        address.setPublicArea("Rua Teste");
        address.setZipCode("123456789");
        address.setNumber(100);
        address.setCity("Cidade Teste");
        address.setType(AddressType.PRINCIPAL);
        address.setPerson(CreatePerson());
        return address;
    }

    public static AddressDto createAddressDto(){
        Address address = createAddress();
        return new AddressDto(address);
    }

    public static AddressReturnDto returnDto(){
        Address address = createAddress();
        return new AddressReturnDto(address);
    }
}
