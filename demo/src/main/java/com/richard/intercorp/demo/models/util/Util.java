package com.richard.intercorp.demo.models.util;

import com.richard.intercorp.demo.models.entity.Cliente;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Util {

    public static double[] obtenerListaEdad(List<Cliente> listaClientes) {

        double[] listaEdades = new double[listaClientes.size()];
        int i = 0;
        for (Cliente cliente : listaClientes) {
            double val = Double.valueOf(cliente.getEdad());
            listaEdades[i++] = val;
        }

        System.out.println(listaEdades.length);

        return listaEdades;
    }

    public static double calcularPromedio(double numArray[]) {
        double suma = 0.0;
        double promedio = 0.0;

        for (double num : numArray) {
            suma += num;
        }

        promedio = suma / numArray.length;

        return promedio;
    }

    public static double calcularDesviacionEstandar(double numArray[]) {
        double desviacionEstandar = 0.0;
        double promedio = Util.calcularPromedio(numArray);

        for (double num : numArray) {
            desviacionEstandar += Math.pow(num - promedio, 2);
        }

        return Math.sqrt(desviacionEstandar / numArray.length);
    }

    public static Date calcularFechaDeceso(Date fecha) {
        Date date = new Date();
        SimpleDateFormat birthdayFormat = new SimpleDateFormat("dd-MM-yyyy");
        String out = "";
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha);
            calendar.add(Calendar.DATE, Constantes.LIFE_EXPENTANCY);
            out = birthdayFormat.format(calendar.getTime());
            date = birthdayFormat.parse(out);
        } catch(Exception e) {
            return  null;
        }
       return date;
    }
}
