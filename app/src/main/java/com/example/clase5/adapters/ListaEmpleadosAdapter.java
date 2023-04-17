package com.example.clase5.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clase5.R;
import com.example.clase5.model.Employee;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ListaEmpleadosAdapter
        extends RecyclerView.Adapter<ListaEmpleadosAdapter.EmpleadoViewHolder>{

    private List<Employee> listaEmpleados;
    private Context context;

    @NonNull
    @Override
    public EmpleadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv, parent, false);
        return new EmpleadoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpleadoViewHolder holder, int position) {
        Employee employee = listaEmpleados.get(position);

        holder.employee = employee;

        TextView textViewName= holder.itemView.findViewById(R.id.textViewFirstName);
        TextView textViewLastName = holder.itemView.findViewById(R.id.textViewLastName);

        textViewName.setText(employee.getFirstName());
        textViewLastName.setText(employee.getLastName());

        if(employee.getFirstName().equals("Lex")){
            holder.itemView.findViewById(R.id.caraFeliz).setVisibility(View.VISIBLE);
        }else{
            holder.itemView.findViewById(R.id.caraFeliz).setVisibility(View.GONE);
        }

        Button button = holder.itemView.findViewById(R.id.button);
        button.setOnClickListener(view -> {
            Toast.makeText(context, "Emp salary: " + employee.getSalary(), Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return listaEmpleados.size();
    }

    public class EmpleadoViewHolder extends RecyclerView.ViewHolder{

        Employee employee;

        public EmpleadoViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }


    public List<Employee> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Employee> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
