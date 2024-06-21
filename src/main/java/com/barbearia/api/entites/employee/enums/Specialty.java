package com.barbearia.api.entites.employee.enums;

public enum Specialty {
    BARBER("barber");

    private String Specialty;
    Specialty(String function){
        this.Specialty=function;
    }
    public String getFunction() {
        return Specialty;
    }
}
