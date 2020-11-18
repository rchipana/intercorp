package com.richard.intercorp.demo.models.service.interf;

import com.richard.intercorp.demo.models.base.Response;
import com.richard.intercorp.demo.models.dto.ClienteDto;
import com.richard.intercorp.demo.models.dto.KpiClientes;
import com.richard.intercorp.demo.models.entity.Cliente;

import java.util.List;

public interface  IClienteService {
    public List<Cliente> findAll();
    public Cliente save(Cliente cliente);
    public KpiClientes getKpiClientes();
    public List <ClienteDto> findAllDto();
    public Cliente save(ClienteDto clienteDto);
    public Response saveResponse(ClienteDto clienteDto);

}
