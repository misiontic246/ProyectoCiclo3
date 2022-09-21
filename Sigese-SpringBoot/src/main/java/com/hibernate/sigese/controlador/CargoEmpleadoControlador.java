package com.hibernate.sigese.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    //Crear cargo empleado
    @PostMapping
    //Dar permisos de dominio CrossOrigin
    @CrossOrigin("*")
    public String create(@RequestBody CargoEmpleadoModelo cargo) {
        return servicio.create(cargo);
    }
    
    //Llamar metodo para la actualizacion de cargo de empleado
    @PutMapping
    //Dar permisos de dominio CrossOrigin
    @CrossOrigin("*")
    public String update(@RequestBody CargoEmpleadoModelo cargo) {
        String message = "";
        try {
            servicio.update(cargo);
            message = "Cargo actualizado con exito";
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }
    
    //LLamar metodo para eliminar cargo de empleado
    @DeleteMapping("/{id}")
    //Dar permisos de dominio CrossOrigin
    @CrossOrigin("*")
    public String delete(@PathVariable(name = "id") int id) {
        return servicio.delete(id);
    }
    
}
