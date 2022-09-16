package com.hibernate.sigese.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Crear anotacion para la creacion de la tabla en la base de datos
@Entity
@Table(name = "empleados")
public class EmpleadoModelo {

    //Creando atributos para la base de datos
    //Creando el id para la base de datos
    @Id
    private int id;
    private String tipo_documemto;
    private String identificacion;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String area_empleado;
    private String estado_empleado;

    //Constructor
    public EmpleadoModelo(int id, String tipo_documemto, String identificacion, String primer_nombre,
            String segundo_nombre, String primer_apellido, String segundo_apellido, String area_empleado,
            String estado_empleado) {
        this.id = id;
        this.tipo_documemto = tipo_documemto;
        this.identificacion = identificacion;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.area_empleado = area_empleado;
        this.estado_empleado = estado_empleado;
    }
    
    
    public EmpleadoModelo() {
    }


    //Consultores y modificadores
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_documemto() {
        return tipo_documemto;
    }

    public void setTipo_documemto(String tipo_documemto) {
        this.tipo_documemto = tipo_documemto;
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