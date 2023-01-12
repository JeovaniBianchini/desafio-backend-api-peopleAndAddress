package com.desafioBackendAttornatus.DesafioAttornatus.repositories;

import com.desafioBackendAttornatus.DesafioAttornatus.entities.Address;
import com.desafioBackendAttornatus.DesafioAttornatus.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
