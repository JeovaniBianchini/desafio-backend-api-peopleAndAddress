package com.desafioBackendAttornatus.DesafioAttornatus.services;

import com.desafioBackendAttornatus.DesafioAttornatus.dtos.AddressDto;
import com.desafioBackendAttornatus.DesafioAttornatus.dtos.PersonDto;
import com.desafioBackendAttornatus.DesafioAttornatus.entities.Address;
import com.desafioBackendAttornatus.DesafioAttornatus.entities.Person;
import com.desafioBackendAttornatus.DesafioAttornatus.repositories.AddressRepository;
import com.desafioBackendAttornatus.DesafioAttornatus.repositories.PersonRepository;
import com.desafioBackendAttornatus.DesafioAttornatus.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public AddressDto saveAddress(AddressDto dto){
        Address address = new Address();
        address.setPublicArea(dto.getPublicArea());
        address.setZipCode(dto.getZipCode());
        address.setNumber(dto.getNumber());
        address.setCity(dto.getCity());
        address.setPerson(new Person(dto.getPersonId(), null, null));
        address = addressRepository.save(address);
        return new AddressDto(address);
    }

    @Transactional(readOnly = true)
    public Page<AddressDto> findAllAddresses(Pageable pageable){
        Page<Address> list = addressRepository.findAll(pageable);
        return list.map(x -> new AddressDto(x));
    }

    @Transactional(readOnly = true)
    public AddressDto findByIdAddress(Long id){
        Optional<Address> addressOptional = addressRepository.findById(id);
        Address address = addressOptional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new AddressDto(address);
    }

    @Transactional
    public AddressDto updateAddress(Long id, AddressDto dto){
        try {
            Address address = addressRepository.getReferenceById(id);
            address.setPublicArea(dto.getPublicArea());
            address.setZipCode(dto.getZipCode());
            address.setNumber(dto.getNumber());
            address.setCity(dto.getCity());
            address.setPerson(new Person(dto.getPersonId(), null, null));
            address = addressRepository.save(address);
            return new AddressDto(address);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id " + id + " not found ");
        }
    }

    public List<AddressDto> findByPerson(String name){
        Person person = personRepository.findByName(name);
        List<Address> list = addressRepository.findByPerson(person);
        return list.stream().map(x -> new AddressDto(x)).collect(Collectors.toList());
    }
}
