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

}
