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
public class SensorTemperatura 
{
 private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;   
    
    @NotNull
    @Column(name = "temperatura")
    private double temp;
    
    
    
    public SensorTemperatura (){}
    
    public SensorTemperatura (double esta)
    {
     
        temp = esta; 
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
     * @return the temp
     */
    public double getTemperatura() {
        return temp;
    }

    /**
     * @param des the temp to set
     */
    public void setTemperatura (double des) {
        this.temp = des;
    }
    
}
