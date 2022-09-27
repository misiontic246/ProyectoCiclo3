package com.hibernate.sigese.modelo;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "horas_trabajadas")
public class HoraEmpleadoModelo {

    // Atributos
    @Id
    private int id;
    private String tipo_documento;
    private String identificacion;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private Date fecha_registro;
    private float horas_trabajadas;

    public HoraEmpleadoModelo() {
    }

    public HoraEmpleadoModelo(int id, String tipo_documento, String identificacion, String primer_nombre,
            String segundo_nombre, String primer_apellido, String segundo_apellido, Date fecha_registro,
            float horas_trabajadas) {
        this.id = id;
        this.tipo_documento = tipo_documento;
        this.identificacion = identificacion;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.fecha_registro = fecha_registro;
        this.horas_trabajadas = horas_trabajadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public float getHoras_trabajadas() {
        return horas_trabajadas;
    }

    public void setHoras_trabajadas(float horas_trabajadas) {
        this.horas_trabajadas = horas_trabajadas;
    }

    

}
