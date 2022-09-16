package com.hibernate.sigese.Servicios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.sigese.modelo.EmpleadoModelo;

public class EmpleadoServico {
    //Atributos
    SessionFactory factory;
    public EmpleadoServico() {
        // Crear objeto fabrica de session
        factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(EmpleadoModelo.class)
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

}