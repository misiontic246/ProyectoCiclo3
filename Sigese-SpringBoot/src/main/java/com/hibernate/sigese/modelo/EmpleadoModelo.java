package com.hibernate.sigese.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Crear anotacion para la creacion de la tabla en la base de datos
@Entity
@Table(name = "empleados")
public class EmpleadoModelo {

    //Creando atributos para la base de datos
    //Creando el id para la base de datos
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_cargo_empleado")
    private CargoEmpleadoModelo cargo_empleado;
    private String tipo_documento;
    private String identificacion;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String area_empleado;
    private String estado_empleado;

    //Constructor
    
    public EmpleadoModelo() {
    }

    public EmpleadoModelo(int id, CargoEmpleadoModelo cargo_empleado, String tipo_documento, String identificacion,
            String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido,
            String area_empleado, String estado_empleado) {
        this.id = id;
        this.cargo_empleado = cargo_empleado;
        this.tipo_documento = tipo_documento;
        this.identificacion = identificacion;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.area_empleado = area_empleado;
        this.estado_empleado = estado_empleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CargoEmpleadoModelo getCargo_empleado() {
        return cargo_empleado;
    }

    public void setCargo_empleado(CargoEmpleadoModelo cargo_empleado) {
        this.cargo_empleado = cargo_empleado;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getArea_empleado() {
        return area_empleado;
    }

    public void setArea_empleado(String area_empleado) {
        this.area_empleado = area_empleado;
    }

    public String getEstado_empleado() {
        return estado_empleado;
    }

    public void setEstado_empleado(String estado_empleado) {
        this.estado_empleado = estado_empleado;
    }

    
}