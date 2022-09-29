package com.hibernate.sigese.Servicios;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.sigese.modelo.CargoEmpleadoModelo;
import com.hibernate.sigese.modelo.EmpleadoModelo;
import com.hibernate.sigese.modelo.EmpleadoTiempoModelo;
import com.hibernate.sigese.modelo.RegistroEmpleado;

public class EmpleadoTiempoServicio {
    // Atributos
    SessionFactory factory;

    public EmpleadoTiempoServicio() {
        factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(EmpleadoTiempoModelo.class)
                .addAnnotatedClass(EmpleadoModelo.class)
                .addAnnotatedClass(CargoEmpleadoModelo.class)
                .buildSessionFactory();
    }

    public Session createSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    // Crea un objeto tipo JSON EmpleadoTiempoModelo
    public List<EmpleadoTiempoModelo> getList() throws Exception {
        Session session = createSession();
        List<EmpleadoTiempoModelo> tiempos = session
                .createQuery("from EmpleadoTiempoModelo", EmpleadoTiempoModelo.class).list();
        session.close();
        return tiempos;
    }

    // Buscar tiempos por id
    public EmpleadoTiempoModelo redaById(int id) throws Exception {
        Session session = createSession();
        EmpleadoTiempoModelo tiempo_empleado = session.find(EmpleadoTiempoModelo.class, id);
        session.close();
        return tiempo_empleado;
    }

    // Crear registro de tiempo de empleados
    public Object create_registro(RegistroEmpleado ident) throws Exception {
        Session session = createSession();
            EmpleadoModelo empleado = session
                    .createQuery("from EmpleadoModelo as e where e.identificacion =: ident ",
                            EmpleadoModelo.class)
                            .setParameter("ident", ident.getIdentificacion())
                            .uniqueResult();
        if(empleado == null){
            throw new Exception("Valide su identificacion");
        }
        EmpleadoTiempoModelo empleado_tiempo = session.createQuery(
            "from EmpleadoTiempoModelo as et where et.id_empleado =: id_empleado and et.fecha_salida is null", 
            EmpleadoTiempoModelo.class)
            .setParameter("id_empleado", empleado.getId())
            .uniqueResult();
        Timestamp fecha = new Timestamp(System.currentTimeMillis());
        Date created = new Date(System.currentTimeMillis());
        if(empleado_tiempo == null){
            EmpleadoTiempoModelo empleado_tiempo_n = new EmpleadoTiempoModelo();
            empleado_tiempo_n.setFecha_entrada(fecha);
            empleado_tiempo_n.setId_empleado(empleado.getId());
            empleado_tiempo_n.setCreated(created);
            session.merge(empleado_tiempo_n);
            session.getTransaction().commit();
            session.close();
            return empleado_tiempo_n;
        }
        
        empleado_tiempo.setFecha_salida(fecha);
        session.merge(empleado_tiempo);
        session.getTransaction().commit();
        session.close();
        return empleado_tiempo;
    }


}
