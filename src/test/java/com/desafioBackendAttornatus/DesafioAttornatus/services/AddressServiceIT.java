package com.desafioBackendAttornatus.DesafioAttornatus.services;

import com.desafioBackendAttornatus.DesafioAttornatus.dtos.AddressReturnDto;
import com.desafioBackendAttornatus.DesafioAttornatus.repositories.AddressRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class AddressServiceIT {

    @Autowired
    private AddressService addressService;

    private String name;

    @BeforeEach
    void setUp() throws Exception{
        name = "Maria";
    }

    @Test
    public void findByPersonShouldReturnListAddressByPerson(){

        List<AddressReturnDto> list = addressService.findByPerson(name);

        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals("Rua pioneiros", list.get(0).getPublicArea());
        Assertions.assertEquals(500, list.get(0).getNumber());

    }
}
