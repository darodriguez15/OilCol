/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.main.PersistenceManager;
import com.example.models.Campo;
import com.example.models.CampoDTO;
import com.example.models.Competitor;
import com.example.models.CompetitorDTO;
        
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONObject;
/**
 *
 * @author da.rodriguez15
 */
@Path("/campos")
@Produces(MediaType.APPLICATION_JSON)
public class CampoService 
{
    @PersistenceContext(unitName ="OilPU")
    EntityManager entityManager; 
    
    @PostConstruct
    public void init() {
        try {
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Query q = entityManager.createQuery("select u from Campo u order by u.id ASC");
        List<Campo> campos = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(campos).build();
    } 
    
      @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCampo(CampoDTO campo) {
        JSONObject rta = new JSONObject();
        Campo c = new Campo();
        c.setDepartamento(campo.getDepartamento());
        c.setLatitud(campo.getLatitud());
        c.setLongitud(campo.getLongitud());
 
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(c);
            entityManager.getTransaction().commit();
            entityManager.refresh(c);
            rta.put("campo_id", c.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            c = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    } 
    
    
    
}
