package com.hibernate.sigese.controlador;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hibernate.sigese.Servicios.EmpleadoTiempoServicio;
import com.hibernate.sigese.modelo.EmpleadoTiempoModelo;

@RestController
@RequestMapping("/fechas")
public class EmpleadoTiempoControlador {
    
    private EmpleadoTiempoServicio servicio;

    public EmpleadoTiempoControlador() {
        this.servicio = new EmpleadoTiempoServicio();
    }

    @GetMapping
    //Dar permisos de dominio CrossOrigin
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

    @GetMapping("/fulldates")
    //Dar permisos de dominio CrossOrigin
    @CrossOrigin("*")
    public List<EmpleadoTiempoModelo> datesTime(@RequestParam Date fecha_1, @RequestParam Date fecha_2) {
        List<EmpleadoTiempoModelo> fechas = new ArrayList<>();
        try {
            fechas = servicio.datesTime(fecha_1, fecha_2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fechas;
        // return mascotas;
    }
}
