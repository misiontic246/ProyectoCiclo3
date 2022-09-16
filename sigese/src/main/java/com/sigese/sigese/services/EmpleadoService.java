package com.sigese.sigese.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigese.sigese.models.EmpleadoModel;
import com.sigese.sigese.repositories.EmpleadoRepository;
import java.util.ArrayList;
import java.util.Optional;


//@Service convierte la clase a tipo servicio
@Service
public class EmpleadoService {
    //@Autowired instancia de spring 
    @Autowired
    EmpleadoRepository empleadoRepository;
    
    //Obtener todos los empleados que estan en la base de datos 
    public ArrayList<EmpleadoModel> obtenerEmpleado(){
        //Castear en un arreglo de tipo JSON para listar empleados
        return (ArrayList<EmpleadoModel>) empleadoRepository.findAll();
    }
    //Guardar empleado 
    public EmpleadoModel guardarEmpleado(EmpleadoModel empleado){
        return empleadoRepository.save(empleado);
    }
    //Obtener empleado por ID
    public Optional<EmpleadoModel> obtenerPorId(Long id){
        return empleadoRepository.findById(id);
    }

    //Eliminar empleado por ID
    public boolean eliminarEmpleado(Long id){
        try {
            empleadoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
