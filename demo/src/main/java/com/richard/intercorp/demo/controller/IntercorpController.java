package com.richard.intercorp.demo.controller;


import com.richard.intercorp.demo.models.base.Response;
import com.richard.intercorp.demo.models.dto.ClienteDto;
import com.richard.intercorp.demo.models.dto.KpiClientes;
import com.richard.intercorp.demo.models.entity.Cliente;
import com.richard.intercorp.demo.models.service.interf.IClienteService;
import com.richard.intercorp.demo.models.util.Constantes;
import com.richard.intercorp.demo.models.util.Util;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v0/api")
public class IntercorpController {


    IClienteService iClienteService;

    public IntercorpController(IClienteService iClienteService) {
        this.iClienteService = iClienteService;
    }

    @GetMapping("/index")
    public String index() {
        return "ok";
    }

    @ApiOperation(value = "list clientes", notes = "Retorna list con fecha de deceso")
    @ApiResponses({@ApiResponse(code = 200, message = "operación exitosa"),
            @ApiResponse(code = 400, message = "error de validación"),
            @ApiResponse(code = 500, message = "error interno")})
    @GetMapping("/clients")
    public ResponseEntity<?> list() {
        Map<String, Object> response = new HashMap<>();
        List<ClienteDto> clienteDtoList = null;

        try {
            clienteDtoList = iClienteService.findAllDto();
        } catch (DataAccessException e) {
            response.put("message", Constantes.ERROR);
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("message", Constantes.EXITO);
        response.put("list", clienteDtoList);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Crea un Cliente", notes = "Retorna el id si es exitoso")
    @ApiResponses({@ApiResponse(code = 200, message = "operación exitosa"),
            @ApiResponse(code = 400, message = "error de validación"),
            @ApiResponse(code = 500, message = "error interno")})
    @PostMapping("/clients")
    public ResponseEntity<?> createCliente(@Valid @RequestBody ClienteDto clienteDto , BindingResult result) {

        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> "El campo' " +err.getField()+"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors" , errors);
            return new ResponseEntity<Map<String , Object>>(response , HttpStatus.BAD_REQUEST);
        }


        Cliente cliente = null;
        Response resp = new Response();

        resp = iClienteService.saveResponse(clienteDto);
        if (resp.getMensaje().equalsIgnoreCase(Constantes.NO_OK)) {
            response.put("mensaje", resp.getMensaje());
            response.put("error", resp.getError());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        cliente = (Cliente) resp.getData();

        response.put("mensaje", Constantes.EXITO);
        response.put("cliente", cliente.getId());
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

    @ApiOperation(value = "kpi clientes", notes = "Retorna kpi clientes")
    @ApiResponses({@ApiResponse(code = 200, message = "operación exitosa"),
            @ApiResponse(code = 400, message = "error de validación"),
            @ApiResponse(code = 500, message = "error interno")})
    @GetMapping("/kpideclientes")
    public ResponseEntity<?> kpideclientes() {
        Map<String, Object> response = new HashMap<>();
        KpiClientes kpiClientes = new KpiClientes();

        try {
            List<Cliente> listaClientes = iClienteService.findAll();
            kpiClientes.setAgeAvarage(Util.calcularPromedio(Util.obtenerListaEdad(listaClientes)));
            kpiClientes.setStandarDeviation(Util.calcularDesviacionEstandar(Util.obtenerListaEdad(listaClientes)));
        } catch (DataAccessException e) {
            response.put("mensaje", Constantes.ERROR);
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
        }

        response.put("mensaje", Constantes.EXITO);
        response.put("kpiClientes", kpiClientes);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }


}
