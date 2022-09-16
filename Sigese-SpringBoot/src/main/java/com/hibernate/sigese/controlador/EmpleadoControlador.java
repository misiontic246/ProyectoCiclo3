package com.hibernate.sigese.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.sigese.Servicios.EmpleadoServico;
import com.hibernate.sigese.modelo.EmpleadoModelo;

@RestController
@RequestMapping("/empleados")
public class EmpleadoControlador {
    //Atributos
    private EmpleadoServico servicio;

    public EmpleadoControlador() {
        this.servicio = new EmpleadoServico();
    }
    //Traer lista de empleados en un objeto JSON
    @GetMapping
    public List<EmpleadoModelo> getList() {
        List<EmpleadoModelo> empleados = new ArrayList<>();
        try {
            empleados = servicio.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleados;
    }
    //Obtener empleados por id
    @GetMapping("/{id}")
    public EmpleadoModelo redaById(@PathVariable(name = "id") int id) {
        EmpleadoModelo empleado = new EmpleadoModelo();
        try {
            empleado = servicio.redaById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleado;
    }
}