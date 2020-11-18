package com.richard.intercorp.demo.controller;

import com.richard.intercorp.demo.models.dto.ClienteDto;
import com.richard.intercorp.demo.models.dto.KpiClientes;
import com.richard.intercorp.demo.models.service.interf.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IntercorpControllerTest {
    public static final ClienteDto CLIENTE_DTO = new ClienteDto();

    @Mock
    IClienteService iClienteService;


    @InjectMocks
    IntercorpController intercorpController;



    @Before
    public void init (){
        /*
        Response resp = new Response();


        MockitoAnnotations.initMocks(this);
        CLIENTE_DTO.setNombre("OSCAR");
        CLIENTE_DTO.setApellido("SUAREZ");
        CLIENTE_DTO.setEdad(20);
        CLIENTE_DTO.setFecha_nacimiento(new Date());
       Mockito.when(iClienteService.saveResponse(CLIENTE_DTO));
*/
    }

    @Test
    public void list(){
        MockitoAnnotations.initMocks(this);
        final ClienteDto clienteDto = new ClienteDto();
        when(iClienteService.findAllDto()).thenReturn(Arrays.asList(clienteDto));
        ResponseEntity<Map<String, Object>> httpResponse = (ResponseEntity<Map<String, Object>>) intercorpController.list();
        List<ClienteDto> list = (List<ClienteDto>) httpResponse.getBody().get("list");
        Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(httpResponse);
        Assert.assertFalse(httpResponse.getBody().isEmpty());
        Assert.assertEquals(list.size(), 1);
    }

    @Test
    public void kpideclientes(){
        MockitoAnnotations.initMocks(this);
        final ClienteDto clienteDto = new ClienteDto();
        when(iClienteService.findAllDto()).thenReturn(Arrays.asList(clienteDto));

        ResponseEntity<Map<String, Object>> httpResponse = (ResponseEntity<Map<String, Object>>) intercorpController.kpideclientes();

        KpiClientes kpiClientes = (KpiClientes) httpResponse.getBody().get("kpiClientes");
        Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(httpResponse);
        Assert.assertFalse(httpResponse.getBody().isEmpty());

    }


}
