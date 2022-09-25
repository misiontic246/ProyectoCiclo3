package com.hibernate.sigese.controlador;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hibernate.sigese.Servicios.EmpleadoTiempoServicio;
import com.hibernate.sigese.modelo.EmpleadoModelo;
import com.hibernate.sigese.modelo.EmpleadoTiempoModelo;
import com.hibernate.sigese.modelo.RegistroEmpleado;

@RestController
@RequestMapping("/tiempos")
public class EmpleadoTiempoControlador {

    private EmpleadoTiempoServicio servicio;

    public EmpleadoTiempoControlador() {
        this.servicio = new EmpleadoTiempoServicio();
    }

    @GetMapping
    // Dar permisos de dominio CrossOrigin
    @CrossOrigin("*")
    public List<EmpleadoTiempoModelo> getList() {
        List<EmpleadoTiempoModelo> tiempos = new ArrayList<>();
        try {
            tiempos = servicio.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tiempos;
    }

    // Obtener tiempos por id
    @GetMapping("/{id}")
    // Dar permisos de dominio CrossOrigin
    @CrossOrigin("*")
    public EmpleadoTiempoModelo redaById(@PathVariable(name = "id") int id) {
        EmpleadoTiempoModelo tiempo = new EmpleadoTiempoModelo();
        try {
            tiempo = servicio.redaById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tiempo;
    }

    //Crear tiempo de entrada de empleado
    @PostMapping
    //Dar permisos de dominio CrossOrigin
    @CrossOrigin("*")
    public Object create(@RequestBody  RegistroEmpleado registro_empleado) {
        try {
            return servicio.create(registro_empleado);
        } catch (Exception e) {
            return e.getMessage();
        }
        
    }

    //Registrar tiempo de salida de empleado
    @PutMapping
    //Dar permisos de dominio CrossOrigin
    @CrossOrigin("*")
    public String update(@RequestBody Object tiempo_empleado) {
        String message = "";
        try {
            servicio.update(tiempo_empleado);
            message = "Hora de salida creada con exito";
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

}
