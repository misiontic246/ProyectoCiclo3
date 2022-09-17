package com.hibernate.sigese.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cargos_empleados")
public class CargoEmpleadoModelo {
    
    //Creando atributos para la base de datos
    @Id
    private int id;
    private String cargo_empleado;

    //Constructor
    public CargoEmpleadoModelo(int id, String cargo_empleado) {
        this.id = id;
        this.cargo_empleado = cargo_empleado;
    }
    public CargoEmpleadoModelo() {
    }

    //Consultores y modificadores
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo_empleado() {
        return cargo_empleado;
    }

    public void setCargo_empleado(String cargo_empleado) {
        this.cargo_empleado = cargo_empleado;
    }


}