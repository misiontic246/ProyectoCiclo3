package com.sigese.sigese.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class EmpleadosModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;


    private long id_cargo_empleado;
    private String tipo_documemto;
    private String identificacion;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String area_empleado;
    private String estado_empleado;

    //Metodos consultores y modificadores

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getId_cargo_empleado() {
        return id_cargo_empleado;
    }
    public void setId_cargo_empleado(long id_cargo_empleado) {
        this.id_cargo_empleado = id_cargo_empleado;
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
