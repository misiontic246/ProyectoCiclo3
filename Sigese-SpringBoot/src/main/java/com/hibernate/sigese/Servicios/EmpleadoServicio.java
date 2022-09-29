package com.hibernate.sigese.Servicios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.sigese.modelo.CargoEmpleadoModelo;
import com.hibernate.sigese.modelo.EmpleadoModelo;

public class EmpleadoServicio {
    //Atributos
    SessionFactory factory;
    public EmpleadoServicio() {
        // Crear objeto fabrica de session
        factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(EmpleadoModelo.class)
                .addAnnotatedClass(CargoEmpleadoModelo.class)
                .buildSessionFactory();
    }
    
    public Session createSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    //Crea un objeto tipo JSON de EmpleadoModelo
    public List<EmpleadoModelo> getList() throws Exception {
        Session session = createSession();
        List<EmpleadoModelo> empleados = session.createQuery("from EmpleadoModelo", EmpleadoModelo.class).list();
        session.close();
        return empleados;
    }
    
    //Buscar empleado por id
    public EmpleadoModelo redaById(int id) throws Exception {
        Session session = createSession();
        EmpleadoModelo empleado = session.find(EmpleadoModelo.class, id);
        session.close();
        return empleado;
    }
    //Crear empleado
    public String create(EmpleadoModelo empleado) {
        String message = "";
        Session session = createSession();
        try {
        session.persist(empleado);
        session.getTransaction().commit();
        message = "Empleado creado con exito";
        } catch (Exception e) {
            message = e.getMessage();
        }
        session.close();
        return message;
    }
    //Buscar empleado por numero de documento
    public List<EmpleadoModelo> getByIdent(String identificacion ) throws Exception {
        Session session = createSession();
        List<EmpleadoModelo> objEmpleado = session
                .createQuery("from EmpleadoModelo where identificacion = :ident", EmpleadoModelo.class)
                .setParameter("ident", identificacion).list();
        session.close();
        return objEmpleado;
    }
    //Actualizar datos de empleado
    public void update(EmpleadoModelo empleado) {
        Session session = createSession();
        // Realizar actualizacion de la BD
        session.merge(empleado);
        session.getTransaction().commit();
        session.close();
    }

    //Eliminar empleados
    public String delete(int id) {
        Session session = createSession();
        EmpleadoModelo empleado = session.find(EmpleadoModelo.class, id);
        deleteService(empleado);
        session.close();
        return "Empleado eliminado con exito";
    }

    public void deleteService(EmpleadoModelo empleado) {
        Session session = createSession();
        session.remove(empleado);
        session.getTransaction().commit();
        session.close();
    }

}