package com.richard.intercorp.demo.models.service.impl;

import com.richard.intercorp.demo.models.base.Response;
import com.richard.intercorp.demo.models.dao.jpa.IClienteDao;
import com.richard.intercorp.demo.models.dto.ClienteDto;
import com.richard.intercorp.demo.models.dto.KpiClientes;
import com.richard.intercorp.demo.models.entity.Cliente;
import com.richard.intercorp.demo.models.service.interf.IClienteService;
import com.richard.intercorp.demo.models.service.interf.IFClientService;
import com.richard.intercorp.demo.models.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements IClienteService, IFClientService {
    @Autowired
    IClienteDao iClienteDao;

    @Override
    public List<Cliente> findAll() {
        return iClienteDao.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {
        return iClienteDao.save(cliente);
    }

    @Override
    public KpiClientes getKpiClientes() {
        return null;
    }

    @Override
    public List<ClienteDto> findAllDto() {
        try {
            List<Cliente> clientList = iClienteDao.findAll();
            List<ClienteDto> clienteDtoList = clientList.stream()
                    .map(IFClientService.mapperGet)
                    .collect(Collectors.toList());

            return clienteDtoList;
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Cliente save(ClienteDto clienteDto) {
        try {
            Cliente cliente = IFClientService.mapperPost.apply(clienteDto);
            return iClienteDao.save(cliente);
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public Response saveResponse(ClienteDto clienteDto) {
        Response response = new Response();
        Cliente cliente = null;
        try {
            cliente = IFClientService.mapperPost.apply(clienteDto);
            cliente = iClienteDao.save(cliente);
        } catch (DataAccessException e) {
            response.setMensaje(Constantes.NO_OK);
            response.setError(e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return response;
        }catch (NullPointerException ex){
            response.setMensaje(Constantes.NO_OK);
            response.setError(Constantes.NULL);
            return response;
        }

        response.setMensaje(Constantes.OK);
        response.setData(cliente);
        return response;
    }

    @Override
    public String hellow() {
        return null;
    }
}
