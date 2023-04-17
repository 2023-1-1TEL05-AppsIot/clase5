package com.example.clase5.model;

import java.util.ArrayList;

public class EmployeeDto {

    private Employee[] lista;
    private String estado;

    public Employee[] getLista() {
        return lista;
    }

    public void setLista(Employee[] lista) {
        this.lista = lista;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
