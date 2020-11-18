package com.richard.intercorp.demo.models.dto;


import com.fasterxml.jackson.annotation.JsonFormat;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ClienteDto {


    @NotEmpty(message = "el campo nombre no puede estar vacio")
    private String nombre;

    @NotEmpty(message = "el campo apellido no puede estar vacio")
    private String apellido;

    @NotNull(message = "el campo edad no puede ser null")
    private Integer edad;

    @NotNull(message = "el campo fecha nacimiento no puede ser null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-PE", timezone = "Peru/East")
    private Date fecha_nacimiento;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-PE", timezone = "Peru/East")
    private Date fecha_muerte;

    public Date getFecha_muerte() {
        return fecha_muerte;
    }

    public void setFecha_muerte(Date fecha_muerte) {
        this.fecha_muerte = fecha_muerte;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
