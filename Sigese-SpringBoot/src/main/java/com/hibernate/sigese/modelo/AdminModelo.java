package com.hibernate.sigese.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
public class AdminModelo {
    
    //Creando atributos para la base de datos 
    @Id
    private int id;
    private String email;
    private String password;

    //Constructor
    public AdminModelo(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    //Consultores y modificadores
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
