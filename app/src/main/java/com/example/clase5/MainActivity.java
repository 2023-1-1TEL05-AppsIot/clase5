package com.example.clase5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.clase5.adapters.ListaEmpleadosAdapter;
import com.example.clase5.databinding.ActivityMainBinding;
import com.example.clase5.model.Employee;
import com.example.clase5.model.EmployeeDto;
import com.example.clase5.model.EmployeeRepository;
import com.example.clase5.model.RetrofitBuilder;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ListaEmpleadosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cargarLista();

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Employee> listaEmpleados = adapter.getListaEmpleados();
                Employee employee = listaEmpleados.get(0);
                employee.setFirstName("Jex");
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void cargarLista() {
        EmployeeRepository employeeRepository = RetrofitBuilder.createRepo("http://10.101.50.106:8080");

        employeeRepository.obtenerEmpleados().enqueue(new Callback<EmployeeDto>() {
            @Override
            public void onResponse(Call<EmployeeDto> call, Response<EmployeeDto> response) {
                if (response.isSuccessful()) {
                    EmployeeDto employeeDto = response.body();
                    for (Employee e : employeeDto.getLista()) {
                        Log.d("msg-test", "first_name: " + e.getFirstName());
                    }

                    //aca ya tengo la lista :D
                    adapter = new ListaEmpleadosAdapter();
                    adapter.setListaEmpleados(Arrays.asList(employeeDto.getLista()));
                    adapter.setContext(MainActivity.this);

                    binding.recyclerView.setAdapter(adapter);
                    binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                } else {
                    Log.d("msg-test", "Algo pasó :/");
                }
            }

            @Override
            public void onFailure(Call<EmployeeDto> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}