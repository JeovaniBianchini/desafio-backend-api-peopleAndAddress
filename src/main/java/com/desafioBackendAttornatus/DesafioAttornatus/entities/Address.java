package com.desafioBackendAttornatus.DesafioAttornatus.entities;

import com.desafioBackendAttornatus.DesafioAttornatus.entities.enums.AddressType;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String publicArea;
    private String zipCode;
    private Integer number;
    private String city;
    private AddressType type;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Address(){
    }

    public Address(Long id, String publicArea, String zipCode, Integer number, String city, Person person, AddressType type) {
        this.id = id;
        this.publicArea = publicArea;
        this.zipCode = zipCode;
        this.number = number;
        this.city = city;
        this.person = person;
        this.type = type;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }
}
