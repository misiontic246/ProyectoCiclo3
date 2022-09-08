package com.sigese.sigese.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import java.util.List;

@Entity
@Table(name = "cargos_empleados")
public class CargoEmpleadoModel {
    
    //Creando atributos para la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;
    private String cargo_empleado;

    //Creando relacion de llave foranea entre cargo y empleado
    @OneToMany(mappedBy = "cargo")
    List<EmpleadoModel> empleado;
    
    //Constructor
    public CargoEmpleadoModel(long id, String cargo_empleado, List<EmpleadoModel> empleado) {
        this.id = id;
        this.cargo_empleado = cargo_empleado;
        this.empleado = empleado;
    }
    
    //Metodos consultores y modificadores
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCargo_empleado() {
        return cargo_empleado;
    }

    public void setCargo_empleado(String cargo_empleado) {
        this.cargo_empleado = cargo_empleado;
    }

    public List<EmpleadoModel> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(List<EmpleadoModel> empleado) {
        this.empleado = empleado;
    }

    

}
