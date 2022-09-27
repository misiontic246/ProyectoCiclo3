package com.hibernate.sigese.controlador;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.sigese.Servicios.HoraEmpleadoServicio;
import com.hibernate.sigese.modelo.HoraEmpleadoModelo;

@RestController
@RequestMapping("/horas")
public class HoraEmpleadoControlador {
    // Atributos
    private HoraEmpleadoServicio servicio;

    public HoraEmpleadoControlador() {
        this.servicio = new HoraEmpleadoServicio();
    }

    // Traer lista de empleados en un objeto JSON
    @GetMapping
    // Dar permisos de dominio CrossOrigin
    @CrossOrigin("*")
    public List<HoraEmpleadoModelo> getList() {
        List<HoraEmpleadoModelo> horas_empleados = new ArrayList<>();
        try {
            horas_empleados = servicio.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return horas_empleados;
    }

    // Buscar registros por fechas
    @GetMapping("/date")
    // Dar permisos de dominio CrossOrigin
    @CrossOrigin("*")
    public List<HoraEmpleadoModelo> getByDate(@RequestParam Date fecha_1) {
        List<HoraEmpleadoModelo> horas_empleados = new ArrayList<>();
        try {
            horas_empleados = servicio.getByDate(fecha_1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return horas_empleados;

    }

    // Buscar registros por fechas
    @GetMapping("/range")
    // Dar permisos de dominio CrossOrigin
    @CrossOrigin("*")
    public List<HoraEmpleadoModelo> getByDateRange(@RequestParam Date fecha_1, @RequestParam Date fecha_2) {
        List<HoraEmpleadoModelo> horas_empleados = new ArrayList<>();
        System.out.println(fecha_1);
        System.out.println(fecha_2);
        try {
            horas_empleados = servicio.getByDateRange(fecha_1, fecha_2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return horas_empleados;

    }

}
