package com.desafioBackendAttornatus.DesafioAttornatus.dtos;

import com.desafioBackendAttornatus.DesafioAttornatus.entities.Address;
import com.desafioBackendAttornatus.DesafioAttornatus.entities.enums.AddressType;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class AddressDto implements Serializable {

    private Long id;
    private String publicArea;

    @NotBlank(message = "Campo requerido")
    private String zipCode;

    private Integer number;

    @NotBlank(message = "Campo requerido")
    private String city;

    private AddressType type;

    private Long personId;


    public AddressDto(){
    }

    public AddressDto(Long id, String publicArea, String zipCode, Integer number, String city, Long personId, AddressType type) {
        this.id = id;
        this.publicArea = publicArea;
        this.zipCode = zipCode;
        this.number = number;
        this.city = city;
        this.personId = personId;
        this.type = type;
    }

    public AddressDto(Address address) {
        id = address.getId();
        publicArea = address.getPublicArea();
        zipCode = address.getZipCode();
        number = address.getNumber();
        city = address.getCity();
        personId = address.getPerson().getId();
        type = address.getType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublicArea() {
        return publicArea;
    }

    public void setPublicArea(String publicArea) {
        this.publicArea = publicArea;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }
}
