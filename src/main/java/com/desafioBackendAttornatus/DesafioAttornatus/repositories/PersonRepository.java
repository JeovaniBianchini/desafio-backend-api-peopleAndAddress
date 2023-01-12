package com.desafioBackendAttornatus.DesafioAttornatus.repositories;

import com.desafioBackendAttornatus.DesafioAttornatus.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByName(String name);
}
