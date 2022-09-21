package com.hibernate.sigese.Servicios;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.sigese.modelo.EmpleadoTiempoModelo;


public class EmpleadoTiempoServicio {
    //Atributos
    SessionFactory factory;

    public EmpleadoTiempoServicio(){
        factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(EmpleadoTiempoModelo.class)
        .buildSessionFactory();
    }

    public Session createSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    public List<EmpleadoTiempoModelo> getList() throws Exception {
        Session session = createSession();
        List<EmpleadoTiempoModelo> tiempos = session.createQuery("from EmpleadoTiempoModelo", EmpleadoTiempoModelo.class).list();
        session.close();
        return tiempos;
    }

    public List<EmpleadoTiempoModelo> datesTime(Date fecha_1, Date fecha_2 ) throws Exception {
        Session session = createSession();
        List<EmpleadoTiempoModelo> objDatesTime = session
                .createQuery("from EmpleadoTiempoModelo where fecha BETWEEN fecha_1 = :date_1 and fecha_2 = :date_2", EmpleadoTiempoModelo.class)
                .setParameter("date_1", fecha_1)
                .setParameter("date_2", fecha_2 ).list();
        session.close();
        return objDatesTime;
        // return mascotas;
    }
}
