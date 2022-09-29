package com.hibernate.sigese.Servicios;
import java.sql.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.sigese.modelo.HoraEmpleadoModelo;

public class HoraEmpleadoServicio {
    // Atributos
    SessionFactory factory;

    public HoraEmpleadoServicio() {
        // Crear objeto fabrica de session
        factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(HoraEmpleadoModelo.class)
                .buildSessionFactory();
    }

    public Session createSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    // Crea un objeto tipo JSON de la tabla horas trabajadas
    public List<HoraEmpleadoModelo> getList() throws Exception {
        Session session = createSession();
        List<HoraEmpleadoModelo> horas_empleados = session
                .createQuery("from HoraEmpleadoModelo", HoraEmpleadoModelo.class).list();
        session.close();
        return horas_empleados;
    }

    // Buscar horas trabajadas por fechas
    public List<HoraEmpleadoModelo> getByDate(Date fecha_1) throws Exception {
        Session session = createSession();
        List<HoraEmpleadoModelo> objFecha = session
                .createQuery("from HoraEmpleadoModelo where fecha_registro = :fecha_1", HoraEmpleadoModelo.class)
                .setParameter("fecha_1", fecha_1)
                .list();
        session.close();
        return objFecha;
    }

    // Buscar horas trabajadas por rango de fechas
    public List<HoraEmpleadoModelo> getByDateRange(Date fecha_1, Date fecha_2) throws Exception {
        Session session = createSession();
        List<HoraEmpleadoModelo> objFecha = session
                .createNativeQuery(
                        " select id, tipo_documento, identificacion, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, fecha_registro, sum(horas_trabajadas) as horas_trabajadas from horas_trabajadas  where fecha_registro between :fecha_1 and :fecha_2 group by id", HoraEmpleadoModelo.class)
                .setParameter("fecha_1", fecha_1)
                .setParameter("fecha_2", fecha_2)
                .list();
        session.close();        
        return objFecha;
    }

}
