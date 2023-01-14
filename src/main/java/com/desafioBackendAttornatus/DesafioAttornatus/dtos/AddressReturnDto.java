package com.desafioBackendAttornatus.DesafioAttornatus.dtos;

import com.desafioBackendAttornatus.DesafioAttornatus.entities.Address;
import com.desafioBackendAttornatus.DesafioAttornatus.entities.enums.AddressType;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class AddressReturnDto implements Serializable {

    private String publicArea;
    private String zipCode;
    private Integer number;
    private String city;
    private AddressType type;

    public AddressReturnDto(){
    }

    public AddressReturnDto(String publicArea, String zipCode, Integer number, String city,AddressType type) {
        this.publicArea = publicArea;
        this.zipCode = zipCode;
        this.number = number;
        this.city = city;
        this.type = type;
    }

    public AddressReturnDto(Address address) {;
        publicArea = address.getPublicArea();
        zipCode = address.getZipCode();
        number = address.getNumber();
        city = address.getCity();
        type = address.getType();
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

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }
}
