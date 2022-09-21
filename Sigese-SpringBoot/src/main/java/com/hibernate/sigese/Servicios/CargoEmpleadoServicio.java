package com.hibernate.sigese.Servicios;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.sigese.modelo.CargoEmpleadoModelo;

public class CargoEmpleadoServicio {
    //Atributo
    SessionFactory factory;

    public CargoEmpleadoServicio() {
        // Crear objeto fabrica de session
        factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(CargoEmpleadoModelo.class)
                .buildSessionFactory();
    }
    
    //Creamos la session
    public Session createSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    //Crea un objeto tipo JSON de CargoEmpleadoModelo lista
    public List<CargoEmpleadoModelo> getList() throws Exception {
        Session session = createSession();
        List<CargoEmpleadoModelo> cargos = session.createQuery("from CargoEmpleadoModelo", CargoEmpleadoModelo.class).list();
        session.close();
        return cargos;
    }

    //Crear cargo de empleados
    public String create( CargoEmpleadoModelo cargo) {
        String message = "";
        Session session = createSession();
        try {
        session.persist(cargo);
        session.getTransaction().commit();
        message = "Cargo creado con exito";
        } catch (Exception e) {
            message = e.getMessage();
        }
        session.close();
        return message;
    }
    
    //Metodo de actualizacion de cargo empleado
    public void update(CargoEmpleadoModelo cargo) {
        Session session = createSession();
        // Realizar actualizacion de la BD
        session.merge(cargo);
        session.getTransaction().commit();
        session.close();
    }

    //Metodo para eliminar cargo de empleado
    public String delete(int id) {
        Session session = createSession();
        CargoEmpleadoModelo cargo = session.find(CargoEmpleadoModelo.class, id);
        deleteService(cargo);
        session.close();
        return "Cargo eliminado con exito";
    }

    public void deleteService(CargoEmpleadoModelo cargo) {
        Session session = createSession();
        session.remove(cargo);
        session.getTransaction().commit();
        session.close();
    }

}
