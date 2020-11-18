package com.richard.intercorp.demo.models.dto;

public class KpiClientes {
    private static final long serialVersionUID = 1L;
    private double ageAvarage;
    private double standarDeviation;

    public double getAgeAvarage() {
        return ageAvarage;
    }

    public void setAgeAvarage(double ageAvarage) {
        this.ageAvarage = ageAvarage;
    }

    public void setStandarDeviation(double standarDeviation) {
        this.standarDeviation = standarDeviation;
    }

    public double getStandarDeviation() {
        return standarDeviation;
    }
}
