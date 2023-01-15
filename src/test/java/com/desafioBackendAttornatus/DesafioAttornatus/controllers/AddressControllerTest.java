package com.desafioBackendAttornatus.DesafioAttornatus.controllers;

import com.desafioBackendAttornatus.DesafioAttornatus.Factory;
import com.desafioBackendAttornatus.DesafioAttornatus.dtos.AddressDto;
import com.desafioBackendAttornatus.DesafioAttornatus.services.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(AddressController.class)
public class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AddressService addressService;

    private AddressDto addressDto;

    private Long id;

    @BeforeEach
    void setUp() throws Exception{

        id = 2L;

        addressDto = Factory.createAddressDto();

        Mockito.when(addressService.saveAddress(Mockito.any())).thenReturn(addressDto);
    }

    @Test
    public void saveAddressShouldPersistAddress() throws Exception{
        String jsonBody = objectMapper.writeValueAsString(addressDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/addresses")
                .content(jsonBody)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.personId").value(2));
    }
}
