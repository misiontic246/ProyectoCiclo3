package com.hibernate.sigese.modelo;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados_tiempos")
public class EmpleadoTiempoModelo {
    //Creando atributos para la base de datos
    @Id
    private int id;
    private int id_empleado;
    private Timestamp fecha_entrada;
    private Timestamp fecha_salida;
    private Timestamp created;

    
    public EmpleadoTiempoModelo() {
    }

    public EmpleadoTiempoModelo(int id, int id_empleado, Timestamp fecha_entrada, Timestamp fecha_salida,
            Timestamp created) {
        this.id = id;
        this.id_empleado = id_empleado;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.created = created;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Timestamp getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Timestamp fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Timestamp getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Timestamp fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }


    
}