package com.hibernate.sigese.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.sigese.Servicios.CargoEmpleadoServicio;
import com.hibernate.sigese.modelo.CargoEmpleadoModelo;

//
@RestController
@RequestMapping("/cargos")
public class CargoEmpleadoControlador {
    //Atributo para llamar la clase CargoEmpleadoServicio
    private CargoEmpleadoServicio servicio;
    
    public CargoEmpleadoControlador() {
        this.servicio = new CargoEmpleadoServicio();
    }
    
    //Traer lista de empleados en un objeto JSON
    @GetMapping
    //Dar permisos de dominio CrossOrigin
    @CrossOrigin("*")
    public List<CargoEmpleadoModelo> getList() {
        List<CargoEmpleadoModelo> cargos = new ArrayList<>();
        try {
            cargos = servicio.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cargos;
    }

}
