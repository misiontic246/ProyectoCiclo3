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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.sigese.Servicios.EmpleadoServicio;
import com.hibernate.sigese.modelo.EmpleadoModelo;

@RestController
@RequestMapping("/empleados")
public class EmpleadoControlador {
    //Atributos
    private EmpleadoServicio servicio;

    public EmpleadoControlador() {
        this.servicio = new EmpleadoServicio();
    }
    //Traer lista de empleados en un objeto JSON
    @GetMapping
    //Dar permisos de dominio CrossOrigin
    @CrossOrigin("*")
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
    //Dar permisos de dominio CrossOrigin
    @CrossOrigin("*")
    public EmpleadoModelo redaById(@PathVariable(name = "id") int id) {
        EmpleadoModelo empleado = new EmpleadoModelo();
        try {
            empleado = servicio.redaById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleado;
    }
    //Crear empleado
    @PostMapping
    //Dar permisos de dominio CrossOrigin
    @CrossOrigin("*")
    public String create(@RequestBody EmpleadoModelo empleado) {
        return servicio.create(empleado);
    }

    //Buscar empleado por identificacion
    @GetMapping("/fullident")
    //Dar permisos de dominio CrossOrigin
    @CrossOrigin("*")
    public List<EmpleadoModelo> getByIdent(@RequestParam String identificacion) {
        List<EmpleadoModelo> empleado = new ArrayList<>();
        try {
            empleado = servicio.getByIdent(identificacion);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleado;
        // return mascotas;
    }
    
    //Actualizar empleado
    @PutMapping
    //Dar permisos de dominio CrossOrigin
    @CrossOrigin("*")
    public String update(@RequestBody EmpleadoModelo empleado) {
        String message = "";
        try {
            servicio.update(empleado);
            message = "Mascota actualizada con exito";
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    //Eliminar empleado
    @DeleteMapping("/{id}")
    //Dar permisos de dominio CrossOrigin
    @CrossOrigin("*")
    public String delete(@PathVariable(name = "id") int id) {
        return servicio.delete(id);
    }
}
