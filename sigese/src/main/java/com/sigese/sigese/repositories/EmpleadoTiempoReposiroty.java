
package com.sigese.sigese.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sigese.sigese.models.EmpleadoTiempoModel;

@Repository
//Interface y CrudRepository es la clase que implementa los metodos con la base de datos 
public  interface EmpleadoTiempoReposiroty extends CrudRepository <EmpleadoTiempoModel, Long> {
    
}
