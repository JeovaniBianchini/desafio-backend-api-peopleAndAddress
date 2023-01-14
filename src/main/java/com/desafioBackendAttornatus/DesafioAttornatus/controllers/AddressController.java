package com.desafioBackendAttornatus.DesafioAttornatus.controllers;

import com.desafioBackendAttornatus.DesafioAttornatus.dtos.AddressDto;
import com.desafioBackendAttornatus.DesafioAttornatus.dtos.AddressReturnDto;
import com.desafioBackendAttornatus.DesafioAttornatus.dtos.PersonDto;
import com.desafioBackendAttornatus.DesafioAttornatus.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressDto> saveAddress(@Valid @RequestBody AddressDto addressDto){
        AddressDto dto = addressService.saveAddress(addressDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(addressDto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<AddressDto>> findAllAddresses(Pageable pageable){
        Page<AddressDto> list = addressService.findAllAddresses(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AddressDto> findByIdAddress(@PathVariable Long id){
        AddressDto dto = addressService.findByIdAddress(id);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AddressDto> updateAddress(@Valid @PathVariable Long id, @RequestBody AddressDto addressDto){
        AddressDto dto = addressService.updateAddress(id, addressDto);
        return ResponseEntity.ok().body(dto);
    }


    @GetMapping(value = "/person")
    public ResponseEntity<List<AddressReturnDto>> list(@RequestParam(value = "name") String name){
        List<AddressReturnDto> list = addressService.findByPerson(name);
        return ResponseEntity.ok().body(list);
    }



}
