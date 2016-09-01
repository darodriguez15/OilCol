/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jc.gomez18
 */
@Entity
public class Reporte 
{
 private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;   
    
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;
    
    private Long idSensor; 
    
    private Long idPozo; 
    
    private String tipoSensor; 
    
    
    public Reporte (){}
    
    public Reporte ( Long idS, Long idP, String esta, String tipoS)
    {
        idSensor = idS;
        idPozo = idP; 
        descripcion = esta; 
        tipoSensor = tipoS; 
        
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param des the descripcion to set
     */
    public void setDescripcion (String des) {
        this.descripcion = des;
    }

    /**
     * @return the idSensor
     */
    public Long getIdSensor() {
        return idSensor;
    }

    /**
     * @param idSensor the idSensor to set
     */
    public void setIdSensor(Long idSensor) {
        this.idSensor = idSensor;
    }

    /**
     * @return the idPozo
     */
    public Long getIdPozo() {
        return idPozo;
    }

    /**
     * @param idPozo the idPozo to set
     */
    public void setIdPozo(Long idPozo) {
        this.idPozo = idPozo;
    }

    /**
     * @return the tipoSensor
     */
    public String getTipoSensor() {
        return tipoSensor;
    }

    /**
     * @param tipoSensor the tipoSensor to set
     */
    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }
    
    
    
}
