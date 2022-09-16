package com.sigese.sigese.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sigese.sigese.models.AdminModel;


@Repository
//Interface y CrudRepository es la clase que implementa los metodos con la base de datos 
public  interface AdminRepository extends CrudRepository<AdminModel, Long> {
    
}
