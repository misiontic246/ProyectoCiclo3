package com.hibernate.sigese.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cargos_empleados")
public class CargoEmpleadoModelo {
    
    //Creando atributos para la base de datos
    @Id
    private int id_cargo_empleado;
    private String cargo_empleado;

    public CargoEmpleadoModelo(int id_cargo_empleado, String cargo_empleado) {
        this.id_cargo_empleado = id_cargo_empleado;
        this.cargo_empleado = cargo_empleado;
    }

    public CargoEmpleadoModelo() {
    }

    public int getId_cargo_empleado() {
        return id_cargo_empleado;
    }

    public void setId_cargo_empleado(int id_cargo_empleado) {
        this.id_cargo_empleado = id_cargo_empleado;
    }

    public String getCargo_empleado() {
        return cargo_empleado;
    }

    public void setCargo_empleado(String cargo_empleado) {
        this.cargo_empleado = cargo_empleado;
    }


}