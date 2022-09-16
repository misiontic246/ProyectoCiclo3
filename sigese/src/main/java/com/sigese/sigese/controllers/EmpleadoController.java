package com.sigese.sigese.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigese.sigese.models.EmpleadoModel;
import com.sigese.sigese.services.EmpleadoService;
//@RestController para indicar que es un controlador
@RestController
//@RequestMapping("/empleado") direccion del servidor donde se va activar la clase 
@RequestMapping("/empleado")
public class EmpleadoController {
    //@Autowired instancia automatica por spring
    @Autowired
    EmpleadoService empleadoService;
    
    //@GetMapping() 
    @GetMapping()
    public ArrayList<EmpleadoModel> obtenerEmpleado(){
        return empleadoService.obtenerEmpleado();
    }

    @PostMapping()
    public EmpleadoModel guarEmpleadoModel(@RequestBody EmpleadoModel empleado){
        return this.empleadoService.guardarEmpleado(empleado);
    }
    
    @GetMapping(path = "/{id}")
    public Optional<EmpleadoModel> obtenerEmpleadoPorId(@PathVariable("id") long id){
        return this.empleadoService.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") long id){
        boolean ok = this.empleadoService.eliminarEmpleado(id);
        if(ok){
            return "Se elimino el empleado con id: " + id;
        }else{
            return "No se pudo eliminar el usuario con id: " + id;
        }
    }
}
