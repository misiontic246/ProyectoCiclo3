package com.sigese.sigese.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigese.sigese.models.EmpleadoModel;
import com.sigese.sigese.services.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping()
    public ArrayList<EmpleadoModel> obtenerEmpleado(){
        return empleadoService.obtenerEmpleado();
    }

    @PostMapping()
    public EmpleadoModel guarEmpleadoModel(@RequestBody EmpleadoModel empleado){
        return this.empleadoService.guardarUsuario(empleado);
    }
}
