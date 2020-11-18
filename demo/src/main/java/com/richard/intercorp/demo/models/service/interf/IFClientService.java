package com.richard.intercorp.demo.models.service.interf;

import com.richard.intercorp.demo.models.dto.ClienteDto;
import com.richard.intercorp.demo.models.entity.Cliente;
import com.richard.intercorp.demo.models.util.Util;

import java.util.function.Function;

@FunctionalInterface
public interface IFClientService {
    public String hellow ();

    Function<Cliente, ClienteDto> mapperGet = (Cliente u) -> {
        ClienteDto dto = new ClienteDto();
        dto.setNombre(u.getNombre());
        dto.setApellido(u.getApellido());
        dto.setEdad(u.getEdad());
        dto.setFecha_nacimiento(u.getFecha_nacimiento());
        dto.setFecha_muerte(Util.calcularFechaDeceso(u.getFecha_nacimiento()));
        return dto;
    };

    Function<ClienteDto, Cliente> mapperPost = (ClienteDto u) -> {
        Cliente cliente = new Cliente();
        cliente.setNombre(u.getNombre());
        cliente.setApellido(u.getApellido());
        cliente.setEdad(u.getEdad());
        cliente.setFecha_nacimiento(u.getFecha_nacimiento());
        return cliente;
    };
}
