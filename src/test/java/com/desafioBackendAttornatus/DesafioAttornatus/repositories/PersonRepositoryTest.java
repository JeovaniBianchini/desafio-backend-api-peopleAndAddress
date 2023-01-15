package com.desafioBackendAttornatus.DesafioAttornatus.repositories;

import com.desafioBackendAttornatus.DesafioAttornatus.entities.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository repository;

    @Test
    public void saveShoulPersistWithAutoincrementWhenIdIsNull(){
        Person person = new Person();
        person.setId(null);

        Long expetedId = 2L;

        person = repository.save(person);

        Assertions.assertEquals(expetedId, person.getId());

    }
}
