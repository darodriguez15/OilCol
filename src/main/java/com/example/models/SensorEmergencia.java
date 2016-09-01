/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;
import com.example.services.ReporteService;
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
 * @author fa.vera10
 */
@Entity
public class SensorEmergencia implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    public final static String tipo = "SENSOR_EMERGENCIA"; 
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String emergencia;
    
    public SensorEmergencia (){}
    
     public SensorEmergencia(String emergencia) 
     {
        emergencia = emergencia; 
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
     * @return the emergencia
     */
    public String getEmergencia() {
        return emergencia;
    }

    /**
     * @param emergencia the emergencia to set
     */
    public void setEmergencia(String emergencia) {
        this.emergencia = emergencia;
    }
    
    public void crearReporte(Long idSensor, Long idPozo, String Descripcion)
    {
        ReporteDTO x = new ReporteDTO();
        x.setIdSensor(this.getId());
        x.setIdPozo(idPozo);
        x.setDescripcion(Descripcion);
        x.setTipoSensor(tipo);
        ReporteService rs = new ReporteService();
        rs.createReporte(x); 
    }
}