package com.desafioBackendAttornatus.DesafioAttornatus.repositories;

import com.desafioBackendAttornatus.DesafioAttornatus.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
