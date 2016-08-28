/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author da.rodriguez15
 */
@Entity
public class Campo implements Serializable
{
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Column(name = "Longitud")
    private double longitud;
    
    @NotNull
    @Column(name = "Latitud")
    private double latitud;
    
    private String Departamento;
    
    //@ManyToOne(cascade=ALL)
    //private Pozo competitor; poner esto en pozo
    
    //@OneToOne(cascade=ALL, mappedBy="JefeDeCampo")
    //private JefeDeCampo jefeDeCampo;
    
    public Campo (){}
    
     public Campo(double lon,double lat) 
     {
        latitud = lat; 
        longitud = lon;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the longitud
     */
    public double getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the latitud
     */
    public double getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the Departamento
     */
    public String getDepartamento() {
        return Departamento;
    }

    /**
     * @param Departamento the Departamento to set
     */
    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    /**
     * @return the jefeDeCampo
     */
   // public JefeDeCampo getJefeDeCampo() {
     //   return jefeDeCampo;
    //}

    /**
     * @param jefeDeCampo the jefeDeCampo to set
     *
    public void setJefeDeCampo(JefeDeCampo jefeDeCampo) {
        this.jefeDeCampo = jefeDeCampo;
    }
    */
    
    
    
    
    
    
    
    
    
}
