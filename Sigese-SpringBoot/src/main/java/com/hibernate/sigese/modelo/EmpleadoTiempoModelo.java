package com.hibernate.sigese.modelo;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados_tiempos")
public class EmpleadoTiempoModelo {
    //Creando atributos para la base de datos
    @Id
    private int id;
    private Date fecha;
    private Time hora_entrada;
    private Time hora_salida;
  
    //Constructor
    public EmpleadoTiempoModelo(int id, Date fecha, Time hora_entrada, Time hora_salida) {
        this.id = id;
        this.fecha = fecha;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
    }
    
    public EmpleadoTiempoModelo() {
    }


    //Consultores y modificadores
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(Time hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public Time getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Time hora_salida) {
        this.hora_salida = hora_salida;
    }


}