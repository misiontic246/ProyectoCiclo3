package com.sigese.sigese.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.sigese.sigese.models.EmpleadoModel;

@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoModel, Long > {
    
}
