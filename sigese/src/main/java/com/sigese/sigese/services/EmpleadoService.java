package com.sigese.sigese.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigese.sigese.models.EmpleadoModel;
import com.sigese.sigese.repositories.EmpleadoRepository;
import java.util.ArrayList;
import java.util.Optional;



@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;
    

    public ArrayList<EmpleadoModel> obtenerEmpleado(){
        
        return (ArrayList<EmpleadoModel>) empleadoRepository.findAll();
    }

    public EmpleadoModel guardarUsuario(EmpleadoModel empleado){
        return empleadoRepository.save(empleado);
    }

    public Optional<EmpleadoModel> obtenerPorId(Long id){
        return empleadoRepository.findById(id);
    }


    public boolean eliminarUsuario(Long id){
        try {
            empleadoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
