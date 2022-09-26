package com.hibernate.sigese.modelo;

public class RegistroEmpleado {
    
    private String identificacion;

    public RegistroEmpleado() {
    }

    public RegistroEmpleado(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }


}
