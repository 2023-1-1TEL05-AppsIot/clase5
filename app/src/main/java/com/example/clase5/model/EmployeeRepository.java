package com.example.clase5.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeRepository {

    @GET("/")
    Call<EmployeeDto> obtenerEmpleados();
}
